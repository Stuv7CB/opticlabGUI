package stuv7cb.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Line2D;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.SwingUtilities;

class LabelLense extends JLabel 
{
	static private int number=0;
	private int id;
	private final double length;
	private final double f;
	LabelLense(double l, double f)
	{
		id=number;
		number++;
		length=l;
		setSize(30,(int)l);
		this.f=f;
		LabelLense label=this;
		JPopupMenu popup = new JPopupMenu();
		popup.add(new JMenuItem("Настроить"));
		JMenuItem delete = new JMenuItem("Удалить");
		delete.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				label.setVisible(false);
			}
			
		});
		popup.add(delete);
		addMouseListener(new MouseListener()
		{
			private int X;
			private int Y;
			private Timer timer=new Timer();
			@Override
			public void mouseClicked(MouseEvent event)
			{
				if (SwingUtilities.isRightMouseButton(event))
				{
					popup.show(label, event.getX(), event.getY());
				}
			}

			@Override
			public void mouseEntered(MouseEvent event)
			{

			}


			@Override

			public void mouseExited(MouseEvent event) 
			{

			}


			@Override

			public void mousePressed(MouseEvent event)
			{
				X=event.getX();
				Y=event.getY();
				System.out.println("hhhhh");
				label.addMouseMotionListener(new MouseMotionListener(){

					@Override
					public void mouseDragged(MouseEvent e) {
						// TODO Auto-generated method stub
						System.out.println(e.getX()+" "+e.getY()+" "+X+" "+event.getX());
						label.setLocation(label.getX()+e.getX()-X, label.getY()+e.getY()-Y);
					}

					@Override
					public void mouseMoved(MouseEvent e) {
						// TODO Auto-generated method stub
					}
					
				});
			}

			@Override
			public void mouseReleased(MouseEvent event)
			{
				//label.setLocation(label.getX()+event.getX()-X, label.getY()+event.getY()-Y);
			}
		});
	}
	public void paint(Graphics g)
	{
		Graphics2D g2=(Graphics2D) g;
		g2.setPaint(Color.black);
		g2.draw(new Line2D.Double(15d,0d,15d,length));
		g2.draw(new Line2D.Double(15d,0d,3d,12d));
		g2.draw(new Line2D.Double(15d,0d,27d,12d));
		g2.draw(new Line2D.Double(15d,length,3d,length-13d));
		g2.draw(new Line2D.Double(15d,length,27d,length-13d));
	}
}