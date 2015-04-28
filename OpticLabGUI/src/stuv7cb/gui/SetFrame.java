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
	private final String TITLE="Окно настройки";
	JPanel panel;
	SetFrame(MainFrame frame, int id)
	{
		parent=frame;
		ID=id;
		setTitle(TITLE);
		setLocationByPlatform(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		addObjects();
		addButton();
		pack();
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
			case 2:
			{
				SetLense panel=new SetLense(parent);
				panel.addFields();
				add(panel, BorderLayout.CENTER);
				this.panel=panel;
				break;
			}
			case 0:
			{
				SetSource panel=new SetSource(parent);
				panel.addFields();
				add(panel, BorderLayout.CENTER);
				this.panel=panel;
				break;
			}
			case 1:
			{
				SetDisplay panel=new SetDisplay(parent);
				panel.addFields();
				add(panel, BorderLayout.CENTER);
				this.panel=panel;
				break;
			}
			case 3:
			{
				SetMirror panel=new SetMirror(parent);
				panel.addFields();
				add(panel, BorderLayout.CENTER);
				this.panel=panel;
				break;
			}
			case 4:
			{
				SetPlate panel=new SetPlate(parent);
				panel.addFields();
				add(panel, BorderLayout.CENTER);
				this.panel=panel;
				break;
			}
			case 5:
			{
				SetLaser panel=new SetLaser(parent);
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
					System.err.println(nfe.getLocalizedMessage()+"number is invalid.");	
				}
			}
		});
		panelB.add(button);
		add(panelB, BorderLayout.SOUTH);
	}
}
