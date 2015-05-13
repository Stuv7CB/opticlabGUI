package stuv7cb.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.geom.Arc2D;

class LabelEllepticMirror extends LabelObject
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1456719604479245937L;
	private Point center;
	private double angle;
	private double a;
	private double b;
	LabelEllepticMirror(Point p, double angle, double a, double b)
	{
		ID=9;
		center=p;
		this.angle=angle;
		this.b=b;
		this.a=a;
		setDimension();
	}
	void changeCenter(double x, double y)
	{
		center.setLocation(x, y);
	}
	void changeA(double a)
	{
		this.a=a;
	}
	void changeB(double b)
	{
		this.b=b;
	}
	void changeAngle(double a)
	{
		angle=a*Math.PI/180;
	}
	Point getCenter()
	{
		return center;
	}
	String getParams()
	{
		String line=""+center.getX()+" "+center.getY()+" "+angle*(180/Math.PI)+" "+a+" "+b;
		return line;
	}
	double getA()
	{
		return a;
	}
	double getB()
	{
		return b;
	}
	double getAngle()
	{
		return angle*180/Math.PI;
	}
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2=(Graphics2D)g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setPaint(Color.black);
		Point p=new Point();
		p.setLocation(center.getX()-getLocation().getX(), center.getY()-getLocation().getY());
		g2.rotate(-angle, p.getX(), p.getY());
		g2.draw(new Arc2D.Double(p.getX()-a, p.getY()-b, 2*a, 2*b, 0, 180, Arc2D.OPEN));
		g2.rotate(angle, p.getX(), p.getY());
	}
	void setDimension()
	{
		Dimension d=new Dimension();
		Point end=new Point();
		if(a>b)
		{
			d.setSize(2*a, 2*a);
		}
		else
		{
			d.setSize(2*b, 2*b);
		}
		end.setLocation(center.getX()-d.getWidth()/2.0, center.getY()-d.getHeight()/2.0);
		setSize(d);
		setLocation(end);
	}
}
