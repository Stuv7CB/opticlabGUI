package stuv7cb.gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ConnectException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

class ButtonRun extends JButton
{
	String ip;
	int port;
	ButtonRun(String a)
	{
		super(a);
	}
	void addClient()
	{
		addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				SetFrame frame=new SetFrame()
				{
					void addButton()
					{
						setResizable(false);
						JPanel panel=new JPanel();
						setTitle("Input address");
						setLocationByPlatform(true);
						setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
						JTextField IP=new JTextField("ip");
						JTextField PORT=new JTextField("port");
						panel.setLayout(new GridLayout(2,1));
						panel.add(IP);
						panel.add(PORT);
						add(panel, BorderLayout.CENTER);
						JButton b=new JButton("Ввести");
						b.addActionListener(new ActionListener()
						{
							@Override
							public void actionPerformed(ActionEvent e) 
							{
								try
								{
									ip=IP.getText();
									port=Integer.valueOf(PORT.getText());
								}
								catch(NumberFormatException nfe)
								{
									System.err.println(nfe.getLocalizedMessage()+" number is invalid.");	
									}
								addSocket();
								dispose();
							}
						});
						add(b, BorderLayout.NORTH);
						pack();
						setVisible(true);
					}
				};
				frame.addButton();
				
			}
		});
	}
	void addSocket()
	{
		Container c=this;
		while ( c.getParent() != null)
		{
			c = c.getParent();
			if(c instanceof MainFrame)
			{
				break;
			}
		}
		MainFrame mainFrame=(MainFrame) c;
		try
		{
			Socket socket=new Socket(ip, port);
			DataOutputStream out=new DataOutputStream(socket.getOutputStream());
			DataInputStream in=new DataInputStream(socket.getInputStream());
			Component[] component=mainFrame.getComponentsofMainPanel();
			out.writeInt(component.length);
			out.flush();
			for (int i=0;i<component.length; i++)
			{
				out.writeInt(((LabelObject)component[i]).getID());
				out.flush();
			}
			while(in.readUTF().equals("Next"))
			{
				mainFrame.mainPanelPaint(in.readInt(), in.readInt(), in.readInt(), in.readInt());
			}
			socket.close();
		}
		catch(ConnectException e)
		{
			System.err.println("Can't connect to server");
		}
		catch(IOException e)
		{
			
		}
	}
}
