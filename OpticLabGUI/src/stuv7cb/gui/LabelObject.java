package stuv7cb.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

abstract class LabelObject extends JLabel 
{
	protected int clickX;
	protected int clickY;
	protected int ID;
	protected JPopupMenu popup=new JPopupMenu();
	int getID()
	{
		return ID;
	}
	void addMouseControl()
	{
		//TODO It doesn't work!
		LabelObject label=this;
		addMouseMotionListener(new MouseMotionListener()
		{
			@Override		
			public void mouseDragged(MouseEvent e) 
			{
				label.setLocation(label.getX()+e.getX()-clickX, label.getY()+e.getY()-clickY);
				if (label instanceof LabelLense)
				{
					((LabelLense) label).changeCenter(((LabelLense) label).getCenter().getX()+e.getX()-clickX, ((LabelLense) label).getCenter().getY()+e.getY()-clickY);
				}
				if (label instanceof LabelDisplay)
				{
					((LabelDisplay) label).changeCenter(((LabelDisplay) label).getCenter().getX()+e.getX()-clickX, ((LabelDisplay) label).getCenter().getY()+e.getY()-clickY);
				}
				if (label instanceof LabelSource)
				{
					((LabelSource) label).changeCenter(((LabelSource) label).getCenter().getX()+e.getX()-clickX, ((LabelSource) label).getCenter().getY()+e.getY()-clickY);
				}
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
				label.setBorder(BorderFactory.createDashedBorder(Color.BLACK));
			}

			@Override
			public void mouseReleased(MouseEvent e) 
			{
				label.setBorder(BorderFactory.createEmptyBorder());
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
		LabelObject label=this;
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
		JMenuItem set = new JMenuItem("Настроить");
		set.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				SetFrame frame=new SetFrame(parent, ID)
				{//Begin of override of SetFrame
					void addObjects()
					{
						switch (ID)
						{
							case 2:
							{
								SetLense panel=new SetLense(parent)
								{
									void addObject() 
									{
										((LabelLense)label).changeLength(Double.valueOf(length.getText()));
										((LabelLense)label).changeAngle(Double.valueOf(angle.getText()));
										((LabelLense)label).changeCenter(Double.valueOf(xcord.getText()), Double.valueOf(ycord.getText()));
										((LabelLense)label).setDimension();
										((LabelLense)label).changeFocus(Double.valueOf(f.getText()));
										((LabelLense)label).paint(((LabelLense)label).getGraphics());
										((LabelLense)label).updateUI();
									}
								};
								panel.addFields();
								add(panel, BorderLayout.CENTER);
								this.panel=panel;
								break;
							}
							case 0:
							{
								SetSource panel=new SetSource(parent)
								{
									void addObject() 
									{
										((LabelSource)label).changeCenter(Double.valueOf(xcord.getText()), Double.valueOf(ycord.getText()));
										((LabelSource)label).paint(((LabelSource)label).getGraphics());
										((LabelSource)label).updateUI();
									}
								};
								panel.addFields();
								add(panel, BorderLayout.CENTER);
								this.panel=panel;
								break;
							}
							case 1:
							{
								SetDisplay panel=new SetDisplay(parent)
								{
									void addObject()
									{
										((LabelDisplay)label).changeLength(Double.valueOf(length.getText()));
										((LabelDisplay)label).changeAngle(Double.valueOf(angle.getText()));
										((LabelDisplay)label).changeCenter(Double.valueOf(xcord.getText()), Double.valueOf(ycord.getText()));
										((LabelDisplay)label).setDimension();
										((LabelDisplay)label).paint(((LabelDisplay)label).getGraphics());
										((LabelDisplay)label).updateUI();
									}
								};
								panel.addFields();
								add(panel, BorderLayout.CENTER);
								this.panel=panel;
								break;
							}
							case 3:
							{
								SetMirror panel=new SetMirror(parent)
								{
									void addObject()
									{
										((LabelMirror)label).changeLength(Double.valueOf(length.getText()));
										((LabelMirror)label).changeAngle(Double.valueOf(angle.getText()));
										((LabelMirror)label).setLocation(Integer.valueOf(xcord.getText()), Integer.valueOf(ycord.getText()));
										((LabelMirror)label).setSize((int)(Double.valueOf(length.getText())*Math.sin(Double.valueOf(angle.getText())))+10, (int)(Double.valueOf(length.getText())*Math.cos(Double.valueOf(angle.getText())))+10);
										((LabelMirror)label).paint(((LabelMirror)label).getGraphics());
										((LabelMirror)label).updateUI();
									}
								};
								panel.addFields();
								add(panel, BorderLayout.CENTER);
								this.panel=panel;
								break;
							}
							case 5:
							{
								SetLaser panel=new SetLaser(parent)
								{
									void addObject() 
									{
										((LabelLaser)label).changeCenter(Double.valueOf(xcord.getText()), Double.valueOf(ycord.getText()));
										((LabelLaser)label).changeAngle(Double.valueOf(angle.getText()));
										((LabelLaser)label).paint(((LabelLaser)label).getGraphics());
										((LabelLaser)label).updateUI();
									}
								};
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
				};//End of override
			}
		});
		popup.add(set);
		popup.addSeparator();
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
	abstract String getParams();
}
