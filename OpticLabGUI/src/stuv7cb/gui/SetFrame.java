package stuv7cb.gui;

import java.awt.BorderLayout;
import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

class SetFrame extends JFrame
{
	private MainFrame parent;
	private int ID;
	private final int WIDTH=100;
	private final int HEIGHT=300;
	private final String TITLE="Окно настройки";
	JPanel panel;
	SetFrame(MainFrame frame, int id)
	{
		parent=frame;
		ID=id;
		setSize(WIDTH, HEIGHT);
		setTitle(TITLE);
		setLocationByPlatform(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		addObjects();
		addButton();
		setVisible(true);
	}
	SetFrame()
	{
		super();
	}
	void addObjects()
	{
		switch (ID)
		{
			case 0:
			{
				SetLense panel=new SetLense(parent);
				panel.addFields();
				add(panel, BorderLayout.CENTER);
				this.panel=panel;
				break;
			}
			case 1:
			{
				SetSource panel=new SetSource(parent);
				panel.addFields();
				add(panel, BorderLayout.CENTER);
				this.panel=panel;
				break;
		}
			case 2:
			{
				SetWall panel=new SetWall(parent);
				panel.addFields();
				add(panel, BorderLayout.CENTER);
				this.panel=panel;
				break;
			}
		}
	}
	void addButton()
	{
		JPanel panelB = new JPanel();
		JButton button = new JButton("Добавить");
		JFrame frame=this;
		button.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
				((SetPanel)panel).addObject();
				frame.dispose();
				}
				catch(NumberFormatException nfe)
				{
					System.out.println(nfe.getLocalizedMessage()+"number is invalid.");	
				}
			}
		});
		panelB.add(button);
		add(panelB, BorderLayout.SOUTH);
	}
}
