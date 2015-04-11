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

import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

class LabelLense extends JLabel 
{
	static private int number=0;
	private int id;
	private final double length;
	private final double f;
	private int clickX;
	private int clickY;
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
				// TODO Auto-generated method stub
				
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