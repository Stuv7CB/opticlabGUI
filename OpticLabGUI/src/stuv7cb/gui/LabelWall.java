package stuv7cb.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Line2D;

import javax.swing.JLabel;

class LabelWall extends JLabel 
{
	private double length;
	LabelWall(double l)
	{
		length=l;
		setSize(30, (int)l);
		JLabel label=this;
		addMouseListener(new MouseListener()
		{
			private int X;
			private int Y;
			@Override
			public void mouseClicked(MouseEvent event)
			{
				
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
			}

			@Override
			public void mouseReleased(MouseEvent event)
			{
				label.setLocation(label.getX()+event.getX()-X, label.getY()+event.getY()-Y);
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
