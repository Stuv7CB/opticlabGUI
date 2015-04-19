package stuv7cb.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Line2D;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.SwingUtilities;

class LabelLense extends JLabel 
{
	static private int number=0;
	private int id;
	private double length;
	private double f;
	private int clickX;
	private int clickY;
	private double angle;
	private JPopupMenu popup=new JPopupMenu();
	LabelLense(double l, double f, double a)
	{
		id=number;
		number++;
		length=l;
		angle=a;
		if(a!=0)
		{
			setSize((int)(l*Math.cos(angle)), (int)(l*Math.sin(angle)));
		}
		this.f=f;
		LabelLense label=this;
		addMouseMotionListener(new MouseMotionListener()
		{
			@Override		
			public void mouseDragged(MouseEvent e) 
			{
				label.setLocation(label.getX()+e.getX()-clickX, label.getY()+e.getY()-clickY);	
			}
			@Override
			public void mouseMoved(MouseEvent e) 
			{
				// TODO Auto-generated method stub	
			}
		});
		addMouseListener(new MouseListener()
		{

			@Override
			public void mouseClicked(MouseEvent e)
			{
				if (e.getButton()==e.BUTTON3)
				{
			        popup.show(e.getComponent(), e.getX(), e.getY());
				}
			}

			@Override
			public void mouseEntered(MouseEvent e)
			{
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) 
			{
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) 
			{
				clickX=e.getX();
				clickY=e.getY();
			}

			@Override
			public void mouseReleased(MouseEvent e) 
			{
				// TODO Auto-generated method stub
				
			}
			
		});
	}
	void addPopup()
	{
		Container c = this;
		while ( c.getParent() != null)
		{
			c = c.getParent();
			if(c instanceof MainPanel)
			{
				break;
			}
		}
		JLabel label=this;
		MainPanel q=(MainPanel) c;
		while ( c.getParent() != null)
		{
			c = c.getParent();
			if(c instanceof MainFrame)
			{
				break;
			}
		}
		MainFrame parent=(MainFrame)c;
		/*JMenuItem set = new JMenuItem("Настроить");
		set.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				SetFrame set=new SetFrame(parent, "Л")
				{
					void addButton()
					{
						JPanel panelB = new JPanel();
						JButton button = new JButton("Добавить");
						JFrame frame=this;
						SetLense p=new SetLense(parent)
						{
							void addObject() 
							{
								label.setLocation(Integer.valueOf(xcord.getText()), Integer.valueOf(ycord.getText()));
								q.updateUI();
							}
						};
						button.addActionListener(new ActionListener()
						{

							@Override
							public void actionPerformed(ActionEvent e) 
							{
								try
								{
								((SetPanel)p).addObject();
								frame.dispose();
								}
								catch(NumberFormatException nfe)
								{
									System.out.println(nfe.getLocalizedMessage()+"number is invalid.");	
									System.out.println(p.xcord.getText());
								}
							}
						});
						panelB.add(button);
						add(panelB, BorderLayout.SOUTH);
					}
				};
			}
		});
		popup.add(set);
		popup.addSeparator();*/
		JMenuItem delete=new JMenuItem("Удалить.");
		delete.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				q.remove(label);
				q.updateUI();
			}	
		});
		popup.add(delete);
		popup.updateUI();
	}
	public void paint(Graphics g)
	{
		Graphics2D g2=(Graphics2D) g;
		g2.setPaint(Color.black);
		g2.draw(new Line2D.Double(0, getSize().getHeight(), getSize().getWidth(), 0));
		g2.draw(new Line2D.Double(0, getSize().getHeight(), 15*Math.cos(angle+0.261799388), getSize().getHeight()-15*Math.sin(angle+0.261799388)));
		g2.draw(new Line2D.Double(0, getSize().getHeight(), 15*Math.cos(angle-0.261799388), getSize().getHeight()-15*Math.sin(angle-0.261799388)));
	}
}