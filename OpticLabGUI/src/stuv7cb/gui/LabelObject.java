package stuv7cb.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
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
import javax.swing.JOptionPane;
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
	private MouseListener ml;
	private MouseMotionListener mml;
	protected JPopupMenu popup=new JPopupMenu();
	void addMouseControl()
	{
		LabelObject label=this;
		mml=new MouseMotionListener()
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
		};
		addMouseMotionListener(mml);
		ml=new MouseListener()
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
		};
		addMouseListener(ml);
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
									JOptionPane.showMessageDialog(frame, nfe.getLocalizedMessage()+"number is invalid.");
								}
							}
						});
						panelB.add(button);
						add(panelB, BorderLayout.SOUTH);
					}
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
									
									@Override
									void addFields() 
									{
										xcord.setText(""+label.getCenter().getX());
										ycord.setText(""+label.getCenter().getY());
										length.setText(""+((LabelLense)label).getLength());
										angle.setText(""+((LabelLense)label).getAngle());
										f.setText(""+((LabelLense)label).getFocus());
										setLayout(new GridLayout(10,1));
										add(new JLabel("Линза"));
										add(new JLabel("Координаты"));
										add(xcord);
										add(ycord);
										add(new JLabel("Длина"));
										add(length);
										add(new JLabel("Угол"));
										add(angle);
										add(new JLabel("Фокус"));
										add(f);
									}
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

									void addFields() 
									{
										xcord.setText(""+label.getCenter().getX());
										ycord.setText(""+label.getCenter().getY());
										setLayout(new GridLayout(4,1));
										add(new JLabel("Источник"));
										add(new JLabel("Координаты"));
										add(xcord);
										add(ycord);
									}
									void addObject() 
									{
										((LabelSource)label).changeCenter(Double.valueOf(xcord.getText()), Double.valueOf(ycord.getText()));
										((LabelSource)label).setDimension();
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

									@Override
									void addFields()
									{
										xcord.setText(""+label.getCenter().getX());
										ycord.setText(""+label.getCenter().getY());
										length.setText(""+((LabelDisplay)label).getLength());
										angle.setText(""+((LabelDisplay)label).getAngle());
										setLayout(new GridLayout(8,1));
										add(new JLabel("Экран"));
										add(new JLabel("Координаты"));
										add(xcord);
										add(ycord);
										add(new JLabel("Длина"));
										add(length);
										add(new JLabel("Угол"));
										add(angle);
									}
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

									void addFields()
									{
										xcord.setText(""+label.getCenter().getX());
										ycord.setText(""+label.getCenter().getY());
										length.setText(""+((LabelDisplay)label).getLength());
										angle.setText(""+((LabelDisplay)label).getAngle());
										setLayout(new GridLayout(8,1));
										add(new JLabel("Зеркало"));
										add(new JLabel("Координаты"));
										add(xcord);
										add(ycord);
										add(new JLabel("Длина"));
										add(length);
										add(new JLabel("Угол"));
										add(angle);
									}
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

									@Override
									void addFields() 
									{
										xcord.setText(""+label.getCenter().getX());
										ycord.setText(""+label.getCenter().getY());
										angle.setText(""+((LabelLaser)label).getAngle());
										setLayout(new GridLayout(6,1));
										add(new JLabel("Лазер"));
										add(new JLabel("Координаты"));
										add(xcord);
										add(ycord);
										add(new JLabel("Угол"));
										add(angle);
									}
									void addObject() 
									{
										((LabelLaser)label).changeCenter(Double.valueOf(xcord.getText()), Double.valueOf(ycord.getText()));
										((LabelLaser)label).changeAngle(Double.valueOf(angle.getText()));
										((LabelLaser)label).setDimension();
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

									@Override
									void addFields()
									{
										xcord.setText(""+label.getCenter().getX());
										ycord.setText(""+label.getCenter().getY());
										angle.setText(""+((LabelPlate)label).getAngle());
										length.setText(""+((LabelPlate)label).getLength());
										width.setText(""+((LabelPlate)label).getSpan());
										n.setText(""+((LabelPlate)label).getN());
										setLayout(new GridLayout(12,1));
										add(new JLabel("Пластинка"));
										add(new JLabel("Координаты"));
										add(xcord);
										add(ycord);
										add(new JLabel("Длина"));
										add(length);
										add(new JLabel("Ширина"));
										add(width);
										add(new JLabel("Угол"));
										add(angle);
										add(new JLabel("Показатель преломления"));
										add(n);
									}
									void addObject() 
									{
										((LabelPlate)label).changeCenter(Double.valueOf(xcord.getText()), Double.valueOf(ycord.getText()));
										((LabelPlate)label).changeAngle(Double.valueOf(angle.getText()));
										((LabelPlate)label).changeLength(Double.valueOf(length.getText()));
										((LabelPlate)label).changeWidth(Double.valueOf(width.getText()));
										((LabelPlate)label).changeN(Double.valueOf(n.getText()));
										((LabelPlate)label).setDimension();
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

									void addFields()
									{
										xcord.setText(""+label.getCenter().getX());
										ycord.setText(""+label.getCenter().getY());
										x2.setText(""+((LabelPrism)label).getB().getX());
										y2.setText(""+((LabelPrism)label).getB().getY());
										x3.setText(""+((LabelPrism)label).getC().getX());
										y3.setText(""+((LabelPrism)label).getC().getY());
										n.setText(""+((LabelPrism)label).getN());
										setLayout(new GridLayout(12,1));
										add(new JLabel("Призма"));
										add(new JLabel("Координаты A"));
										add(xcord);
										add(ycord);
										add(new JLabel("Координаты B"));
										add(x2);
										add(y2);
										add(new JLabel("Координаты C"));
										add(x3);
										add(y3);
										add(new JLabel("Показатель преломлени"));
										add(n);
									}
									void addObject() 
									{
										((LabelPrism)label).changeCenter(Double.valueOf(xcord.getText()), Double.valueOf(ycord.getText()));
										((LabelPrism)label).changeB(Double.valueOf(x2.getText()), Double.valueOf(y2.getText()));
										((LabelPrism)label).changeC(Double.valueOf(x3.getText()), Double.valueOf(y3.getText()));
										((LabelPrism)label).changeN(Double.valueOf(n.getText()));
										((LabelPrism)label).setDimension();
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

									void addFields() 
									{
										xcord.setText(""+label.getCenter().getX());
										ycord.setText(""+label.getCenter().getY());
										angle.setText(""+((LabelSphereMirror)label).getStartAngle());
										endAngle.setText(""+((LabelSphereMirror)label).getEndAngle());
										r.setText(""+((LabelSphereMirror)label).getR());
										setLayout(new GridLayout(10,1));
										add(new JLabel("Сферическое зеркало"));
										add(new JLabel("Координаты"));
										add(xcord);
										add(ycord);
										add(new JLabel("Угол начала"));
										add(angle);
										add(new JLabel("Угол конца"));
										add(endAngle);
										add(new JLabel("Радиус"));
										add(r);
									}
									void addObject() 
									{
										((LabelSphereMirror)label).changeCenter(Double.valueOf(xcord.getText()), Double.valueOf(ycord.getText()));
										((LabelSphereMirror)label).changeStartAngle(Double.valueOf(angle.getText()));
										((LabelSphereMirror)label).changeEndAngle(Double.valueOf(endAngle.getText()));
										((LabelSphereMirror)label).changeR(Double.valueOf(r.getText()));
										((LabelSphereMirror)label).setDimension();
										((LabelSphereMirror)label).paint(((LabelSphereMirror)label).getGraphics());
										((LabelSphereMirror)label).updateUI();
									}
								};
								panel.addFields();
								add(panel, BorderLayout.CENTER);
								this.panel=panel;
								break;
							}
							case 8:
							{
								SetRealLense panel=new SetRealLense(parent)
								{	
									/**
									 * 
									 */
									private static final long serialVersionUID = -4588540064778051364L;

									void addFields() 
									{
										xcord.setText(""+label.getCenter().getX());
										ycord.setText(""+label.getCenter().getY());
										angle.setText(""+((LabelRealLense)label).getAngle());
										R1.setText(""+((LabelRealLense)label).getR1());
										R2.setText(""+((LabelRealLense)label).getR2());
										length.setText(""+((LabelRealLense)label).getLength());
										n.setText(""+((LabelRealLense)label).getN());
										d.setText(""+((LabelRealLense)label).getD());
										setLayout(new GridLayout(16,1));
										add(new JLabel("Толстая линза"));
										add(new JLabel("Координаты"));
										add(xcord);
										add(ycord);
										add(new JLabel("Радиус одной поверхности"));
										add(R1);
										add(new JLabel("Радиус второй поверхности"));
										add(R2);
										add(new JLabel("Угол"));
										add(angle);
										add(new JLabel("Показатель преломления"));
										add(n);
										add(new JLabel("Длина"));
										add(length);
										add(new JLabel("Толщина"));
										add(d);
									}
									void addObject()
									{
										((LabelRealLense)label).changeCenter(Double.valueOf(xcord.getText()), Double.valueOf(ycord.getText()));
										((LabelRealLense)label).changeR1(Double.valueOf(R1.getText()));
										((LabelRealLense)label).changeR2(Double.valueOf(R2.getText()));
										((LabelRealLense)label).changeAngle(Double.valueOf(angle.getText()));
										((LabelRealLense)label).changeN(Double.valueOf(n.getText()));
										((LabelRealLense)label).changeLength(Double.valueOf(length.getText()));
										((LabelRealLense)label).changeD(Double.valueOf(d.getText()));
										((LabelRealLense)label).setDimension();
										((LabelRealLense)label).paint(((LabelRealLense)label).getGraphics());
										((LabelRealLense)label).updateUI();
									}
								};
								panel.addFields();
								add(panel, BorderLayout.CENTER);
								this.panel=panel;
								break;
							}
							case 9:
							{
								SetEllepticMirror panel=new SetEllepticMirror(parent)
								{
									/**
									 * 
									 */
									private static final long serialVersionUID = -4713732881465506820L;

									void addFields() 
									{
										xcord.setText(""+label.getCenter().getX());
										ycord.setText(""+label.getCenter().getY());
										angle.setText(""+((LabelEllepticMirror)label).getAngle());
										b.setText(""+((LabelEllepticMirror)label).getB());
										a.setText(""+((LabelEllepticMirror)label).getA());
										setLayout(new GridLayout(10,1));
										add(new JLabel("Эллиптическое зеркало"));
										add(new JLabel("Координаты"));
										add(xcord);
										add(ycord);
										add(new JLabel("Угол"));
										add(angle);
										add(new JLabel("Большая полуось"));
										add(a);
										add(new JLabel("Малая полуось"));
										add(b);
									}
									void addObject() 
									{
										((LabelEllepticMirror)label).changeCenter(Double.valueOf(xcord.getText()), Double.valueOf(ycord.getText()));
										((LabelEllepticMirror)label).changeAngle(Double.valueOf(angle.getText()));
										((LabelEllepticMirror)label).changeB(Double.valueOf(b.getText()));
										((LabelEllepticMirror)label).changeA(Double.valueOf(a.getText()));
										((LabelEllepticMirror)label).setDimension();
										((LabelEllepticMirror)label).paint(((LabelEllepticMirror)label).getGraphics());
										((LabelEllepticMirror)label).updateUI();
									}
								};
								panel.addFields();
								add(panel, BorderLayout.CENTER);
								this.panel=panel;
								break;
							}
						}
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
	}
	abstract void changeCenter(double x, double y);
	abstract Point getCenter();
	int getID()
	{
		return ID;
	}
	abstract String getParams();
	void removeMouseControl()
	{
		removeMouseListener(ml);
		removeMouseMotionListener(mml);
	}
}
