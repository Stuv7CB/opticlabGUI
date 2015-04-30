package stuv7cb.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Point;
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
	/**
	 * 
	 */
	private static final long serialVersionUID = 8613616493043654911L;
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
		//TODO Use polymorphism!
		LabelObject label=this;
		addMouseMotionListener(new MouseMotionListener()
		{
			@Override		
			public void mouseDragged(MouseEvent e) 
			{
				label.setLocation(label.getX()+e.getX()-clickX, label.getY()+e.getY()-clickY);
				label.changeCenter(label.getCenter().getX()+e.getX()-clickX, label.getCenter().getY()+e.getY()-clickY);
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
				if (e.getButton()==MouseEvent.BUTTON3)
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
				@SuppressWarnings("unused")
				SetFrame frame=new SetFrame(parent, ID)
				{//Begin of override of SetFrame
					/**
					 * 
					 */
					private static final long serialVersionUID = 8856504742615904849L;
					void addObjects()
					{
						switch (ID)
						{
							case 2:
							{
								SetLense panel=new SetLense(parent)
								{
									/**
									 * 
									 */
									private static final long serialVersionUID = 1317636620999020251L;

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
									/**
									 * 
									 */
									private static final long serialVersionUID = -4864093504858950013L;

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
									/**
									 * 
									 */
									private static final long serialVersionUID = -8262698205245021655L;

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
									/**
									 * 
									 */
									private static final long serialVersionUID = -7744158490634809134L;

									void addObject()
									{
										((LabelMirror)label).changeLength(Double.valueOf(length.getText()));
										((LabelMirror)label).changeAngle(Double.valueOf(angle.getText()));
										((LabelMirror)label).changeCenter(Double.valueOf(xcord.getText()), Double.valueOf(ycord.getText()));
										((LabelMirror)label).setDimension();
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
									/**
									 * 
									 */
									private static final long serialVersionUID = 4134310404204984628L;

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
							case 4:
							{
								SetPlate panel=new SetPlate(parent)
								{
									/**
									 * 
									 */
									private static final long serialVersionUID = 7570566962019361304L;

									void addObject() 
									{
										((LabelPlate)label).changeCenter(Double.valueOf(xcord.getText()), Double.valueOf(ycord.getText()));
										((LabelPlate)label).changeAngle(Double.valueOf(angle.getText()));
										((LabelPlate)label).changeLength(Double.valueOf(length.getText()));
										((LabelPlate)label).changeWidth(Double.valueOf(width.getText()));
										((LabelPlate)label).changeN(Double.valueOf(n.getText()));
										((LabelPlate)label).paint(((LabelPlate)label).getGraphics());
										((LabelPlate)label).updateUI();
									}
								};
								panel.addFields();
								add(panel, BorderLayout.CENTER);
								this.panel=panel;
								break;
							}
							case 6:
							{
								SetPrism panel=new SetPrism(parent)
								{
									/**
									 * 
									 */
									private static final long serialVersionUID = -7549903345315889770L;

									void addObject() 
									{
										((LabelPrism)label).changeCenter(Double.valueOf(xcord.getText()), Double.valueOf(ycord.getText()));
										((LabelPrism)label).changeAngle(Double.valueOf(angle.getText()));
										((LabelPrism)label).changeA(Double.valueOf(a.getText()));
										((LabelPrism)label).changeB(Double.valueOf(b.getText()));
										((LabelPrism)label).changeC(Double.valueOf(c.getText()));
										((LabelPrism)label).changeN(Double.valueOf(n.getText()));
										((LabelPrism)label).paint(((LabelPrism)label).getGraphics());
										((LabelPrism)label).updateUI();
									}
								};
								panel.addFields();
								add(panel, BorderLayout.CENTER);
								this.panel=panel;
								break;
							}
							case 7:
							{
								SetSphereMirror panel=new SetSphereMirror(parent)
								{
									/**
									 * 
									 */
									private static final long serialVersionUID = -4713732881465506820L;

									void addObject() 
									{
										((LabelSphereMirror)label).changeCenter(Double.valueOf(xcord.getText()), Double.valueOf(ycord.getText()));
										((LabelSphereMirror)label).changeStartAngle(Double.valueOf(angle.getText()));
										((LabelSphereMirror)label).changeEndAngle(Double.valueOf(endAngle.getText()));
										((LabelSphereMirror)label).changeR(Double.valueOf(r.getText()));
										((LabelSphereMirror)label).paint(((LabelSphereMirror)label).getGraphics());
										((LabelSphereMirror)label).updateUI();
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
	abstract void changeCenter(double x, double y);
	abstract Point getCenter();
}
