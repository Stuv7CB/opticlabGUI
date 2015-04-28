package stuv7cb.gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

class LabelPlate extends LabelObject
{
	private double length;
	private double width;
	private double angle;
	private double n;
	private Point center;
	LabelPlate(Point p,double l, double w, double a, double n)
	{
		center=p;
		ID=4;
		length=l;
		angle=a;
		width=w;
		this.n=n;
		setDimension();
	}
	public void paint(Graphics g)
	{
		Graphics2D g2=(Graphics2D) g;
		g2.setPaint(Color.black);
		Point p=new Point();
		p.setLocation(center.getX()-getLocation().getX(), center.getY()-getLocation().getY());
		g2.rotate(angle, p.getX(), p.getY());
		g2.draw(new Rectangle2D.Double(p.getX()-0.5*width, p.getY()-0.5*length, width, length));
	}
	void changeLength(double l)
	{
		length=l;
	}
	void changeAngle(double a)
	{
		angle=a;
	}
	void changeWidth(double w)
	{
		width=w;
	}
	void changeN(double n)
	{
		this.n=n;
	}
	void changeCenter(double x, double y)
	{
		center.setLocation(x, y);
	}
	Point getCenter()
	{
		return center;
	}
	String getParams()
	{
		String line="";
		line+=line+center.getX()+" "+center.getY()+" "+length+" "+width+" "+0+" "+n;
		return line;
	}
	void setDimension()
	{
		Dimension d=new Dimension();
		Point end=new Point();
		if(length>width)
		{
			d.setSize(2*length, 2*length);
			end.setLocation(center.getX()-length, center.getY()-length);
			setLocation(end);
		}
		else
		{
			d.setSize(2*width, 2*width);
			end.setLocation(center.getX()-width, center.getY()-width);
			setLocation(end);
		}
		setSize(d);
	}
}
