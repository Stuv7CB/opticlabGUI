package stuv7cb.gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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
	Socket mainSocket;
	String ip=/*"ip"*/"192.168.1.15";
	boolean saveSocket=false;
	int port=5678;
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
						JTextField IP=new JTextField(ip);
						JTextField PORT=new JTextField(String.valueOf(port));
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
			int status;
			/*out.write(String.valueOf(component.length).getBytes());
			out.flush();*/
			for (int i=0;i<component.length; i++)
			{
				String line=String.valueOf(((LabelObject)component[i]).getID())+" "+((LabelObject)component[i]).getParams();
				System.out.println(line);
				status=in.read()-48;
				if (status!=1)
				{
					System.err.println("Error in socket");
					socket.close();
				}
				System.out.println(status);
				out.write(line.getBytes());
				out.flush();
			}
			status=in.read()-48;
			if (status!=1)
			{
				System.err.println("Error in socket");
				socket.close();
			}
			else
			{
				out.write("FINISH".getBytes());
				out.flush();
			}
			byte []buf=new byte[100];
			if(in.read(buf)==-1)
			{
				System.out.println("EOF");
			}
			else
			{
				String line=new String(buf, "US-ASCII");
				System.out.println(line);
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
		/*Component[] component=mainFrame.getComponentsofMainPanel();
		for (int i=0;i<component.length; i++)
		{
			String line=String.valueOf(((LabelObject)component[i]).getID())+" "+((LabelObject)component[i]).getParams();
			System.out.println(line);
			send(line);
		}
		send("FINISH");
		try {
			DataInputStream in=new DataInputStream(mainSocket.getInputStream());
			int buf=in.read()-48;
			System.out.println(buf);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}
	void send(String line)
	{
		try
		{
			Socket socket=new Socket(ip, port);
			DataOutputStream out=new DataOutputStream(socket.getOutputStream());
			DataInputStream in=new DataInputStream(socket.getInputStream());
			//out.write(String.valueOf(component.length).getBytes());
			//out.flush();
				out.write(line.getBytes());
				out.flush();
				in.read();
				mainSocket=socket;
		}
		catch(ConnectException e)
		{
			System.err.println("Can't connect to server.");
		}
		catch(IOException e)
		{
			
		}
	}
}
