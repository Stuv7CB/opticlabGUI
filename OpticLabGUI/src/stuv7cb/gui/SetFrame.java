package stuv7cb.gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

class SetFrame extends JFrame
{
	private final MainFrame parent;
	private final String type;
	private final int WIDTH=100;
	private final int HEIGHT=300;
	private final String TITLE="Свойства объекта";
	private JPanel panelWithParams = new JPanel();
	private JTextField xcord = new JTextField("x");
	private JTextField ycord = new JTextField("y");
	private JTextField length = new JTextField("length");
	private JTextField uni;
	SetFrame(MainFrame frame, String s)
	{
		super();
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
		if(type.equals("Л"))
		{
			panelWithParams.setLayout(new GridLayout(5,1));
		}
		else
		{
			panelWithParams.setLayout(new GridLayout(3,1));
		}
		panelWithParams.add(new JLabel("Введите координаты"));	
		xcord.setFocusable(true);
		panelWithParams.add(xcord);
		panelWithParams.add(ycord);
		add(panelWithParams, BorderLayout.CENTER);
	}
	void addButton()
	{
		JPanel panel = new JPanel();
		if(type.equals("Л"))
		{
			panelWithParams.add(length);
			uni = new JTextField("f");
			panelWithParams.add(uni);
		}
		JButton button = new JButton("Добавить");
		final JFrame frame=this;
		button.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				if(type.equals("Л"))
				{
					final LabelLense label=new LabelLense(Double.valueOf(length.getText()), Double.valueOf(uni.getText()));
					label.setLocation(Integer.valueOf(xcord.getText()), Integer.valueOf(ycord.getText()));
					label.setSize(1, Integer.valueOf(length.getText()));
					label.addMouseListener(new MouseListener()
					{
						@Override
						public void mouseClicked(MouseEvent arg0)
						{
							
						}

						@Override
						public void mouseEntered(MouseEvent arg0)
						{

						}


						@Override

						public void mouseExited(MouseEvent arg0) 
						{

						}


						@Override

						public void mousePressed(MouseEvent arg0)
						{

						}

						@Override
						public void mouseReleased(MouseEvent arg0)
						{
							arg0.setSource(parent.mainPanel);
							label.setLocation(arg0.getPoint());
							System.out.println(arg0.getPoint().x+" "+arg0.getPoint().y);
						}
					});
					parent.mainPanel.add(label);
					label.updateUI();
				}
				else
				{
					JLabel label = new JLabel(type);
					label.setLocation(Integer.valueOf(xcord.getText()), Integer.valueOf(ycord.getText()));
					label.setSize(10, 10);
					parent.mainPanel.add(label);
					label.updateUI();
				}
				frame.dispose();
			}
		});
		panel.add(button);
		add(panel, BorderLayout.SOUTH);
	}
}
