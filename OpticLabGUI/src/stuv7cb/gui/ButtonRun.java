package stuv7cb.gui;

import java.awt.Component;
import java.awt.Container;
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

class ButtonRun extends JButton
{
	private int port;
	private String ip;
	ButtonRun(String a)
	{
		super(a);
	}
	void addClient()
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
		addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
					//ip=(new Scanner(System.in)).nextLine();
				ip="192.168.1.15";
					//port=(new Scanner(System.in)).nextInt();
				port=6666;
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
		});
	}
}
