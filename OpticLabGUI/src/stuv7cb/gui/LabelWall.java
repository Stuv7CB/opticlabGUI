package stuv7cb.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Line2D;

import javax.swing.JLabel;

class LabelWall extends JLabel 
{
	private double length;
	private int clickX;
	private int clickY;
	LabelWall(double l)
	{
		length=l;
		setSize(30, (int)l);
		JLabel label=this;
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
		for (int i=0; i<length; i+=4)
		{
			g2.draw(new Line2D.Double(15d, (double)i,20d, (double)i+15d));
		}
	}
}
