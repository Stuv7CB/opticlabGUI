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
		MainFrame q=(MainFrame) c;
		addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
					//ip=(new Scanner(System.in)).nextLine();
				ip="localhost";
					//port=(new Scanner(System.in)).nextInt();
				port=6666;
				try
				{
					Socket s=new Socket(ip, port);
					DataOutputStream sout=new DataOutputStream(s.getOutputStream());
					DataInputStream sin=new DataInputStream(s.getInputStream());
					Component[] component=((MainFrame)q).getComponentsofMainPanel();
					for (int i=0;i<component.length; i++)
					{
						sout.writeInt(((LabelObject)component[i]).getID());
						sout.flush();
					}
					s.close();
				}
				catch(ConnectException e)
				{
					System.out.println("Can't connect to server");
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}
}
