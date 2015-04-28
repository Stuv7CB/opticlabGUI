package stuv7cb.gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Line2D;

import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

class LabelMirror extends LabelDisplay
{
	LabelMirror(Point p, double l, double a)
	{
		super(p, l, a);
		ID=3;
		length=l;
		angle=a;
		setSize((int)(length*Math.sin(angle))+10, (int)(length*Math.cos(angle))+10);
	}
	public void paint(Graphics g)
	{
		Graphics2D g2=(Graphics2D) g;
		g2.setPaint(Color.black);
		Point p=new Point();
		p.setLocation(center.getX()-getLocation().getX(), center.getY()-getLocation().getY());
		g2.rotate(angle, p.getX(), p.getY());
		g2.draw(new Line2D.Double(p.getX(), p.getY()-0.5*length, p.getX(), p.getY()+0.5*length));
		for (int i=(int)(0.5*length); i>=(int)(-0.5*length); i-=4)
		{
			g2.draw(new Line2D.Double(p.getX(), p.getY()+i, p.getX()+5, p.getY()+i));
		}
	}
}
