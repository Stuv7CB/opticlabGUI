package stuv7cb.gui;

import java.awt.BorderLayout;
import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

class SetFrame extends JFrame
{
	private final MainFrame parent;
	private final String type;
	private final int WIDTH=100;
	private final int HEIGHT=300;
	private final String TITLE="Окно настройки";
	private JPanel panel;
	SetFrame(MainFrame frame, String s)
	{
		parent=frame;
		type=s;
		setSize(WIDTH, HEIGHT);
		setTitle(TITLE);
		setLocationByPlatform(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		addObjects();
		addButton();
		setVisible(true);
	}
	void addObjects()
	{
		switch (type)
		{
		case "Л":
		{
			SetLense panel=new SetLense(parent);
			panel.addFields();
			add(panel, BorderLayout.CENTER);
			this.panel=panel;
			break;
		}
		case "И":
		{
			SetSource panel=new SetSource(parent);
			panel.addFields();
			add(panel, BorderLayout.CENTER);
			this.panel=panel;
			break;
		}
		case "Э":
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
				((SetPanel)panel).addObject();
				frame.dispose();
			}
		});
		panelB.add(button);
		add(panelB, BorderLayout.SOUTH);
	}
}
