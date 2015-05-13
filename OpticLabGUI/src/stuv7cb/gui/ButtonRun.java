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
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

class ButtonRun extends JButton
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7936232824411414193L;
	String ip="127.0.0.1";
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
					/**
					 * 
					 */
					private static final long serialVersionUID = 1481598913629240428L;

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
						add(b, BorderLayout.SOUTH);
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
		mainFrame.clean();
		try
		{
			Socket socket=new Socket(ip, port);
			DataOutputStream out=new DataOutputStream(socket.getOutputStream());
			DataInputStream in=new DataInputStream(socket.getInputStream());
			Component[] component=mainFrame.getComponentsofMainPanel();
			int status;
			for (int i=0;i<component.length; i++)
			{
				String line=String.valueOf(((LabelObject)component[i]).getID())+" "+((LabelObject)component[i]).getParams();
				System.out.println(line);
				status=in.read()-48;
				if (status!=1)
				{
					System.err.println("Error in server");
					socket.close();
				}
				System.out.println(status);
				out.write(line.getBytes());
				out.flush();
			}
			status=in.read()-48;
			if (status!=1)
			{
				System.err.println("Error in server");
				socket.close();
			}
			else
			{
				out.write("FINISH".getBytes());
				out.flush();
			}
			byte []buf=new byte[100];
			while(in.read(buf)!=-1)
			{
				int i;
				for (i=0; i<buf.length;i++)
				{
					if(buf[i]==0)
					{
						break;
					}
				}
				String line=new String(buf, 0, i, "US-ASCII");
				if((line.compareTo("FINISH")==0)||(line.compareTo("ERR")==0))
				{
					socket.close();
					break;
				}
				else
				{
					out.write("1".getBytes());
					out.flush();
					System.out.println(line);
					mainFrame.mainPanelPaint(line);
					buf=new byte[100];
				}
			}
		}
		catch(ConnectException e)
		{
			System.err.println("Can't connect to server");
			JOptionPane.showMessageDialog(mainFrame, "Can't connect to server");
		}
		catch(IOException e)
		{
			System.err.println("IO exception");
			System.err.println(e.getLocalizedMessage());
			JOptionPane.showMessageDialog(mainFrame, "IO exception");
		}
		finally
		{
			mainFrame.mayClean();
		}
	}
}
