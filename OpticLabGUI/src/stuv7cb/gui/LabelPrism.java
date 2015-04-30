package stuv7cb.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.RenderingHints;
import java.awt.geom.Line2D;

class LabelPrism extends LabelObject
{
	private double a;
	private double b;
	private double c;
	private double angle;
	private Point center;
	private double n;
	LabelPrism(Point p, double a, double b, double c, double angle, double n)
	{
		ID=6;
		this.a=a;
		this.b=b;
		this.c=c;
		this.angle=angle;
		this.n=n;
		center=p;
		setDimension();
	}
	public void paint(Graphics g)
	{
		Graphics2D g2=(Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setPaint(Color.black);
		Point p=new Point();
		p.setLocation(center.getX()-getLocation().getX(), center.getY()-getLocation().getY());
		g2.rotate(angle, p.getX(), p.getY());
		double ma=Math.sqrt(2*b*b+2*c*c-a*a)*0.5;
		double cosalpha=(b*b-0.25*a*a-ma*ma)/(-1.0*a*ma);
		double x1=p.getX()-0.5*a-(1.0/3.0)*ma*cosalpha;
		double x2=p.getX()+0.5*a-(1.0/3.0)*ma*cosalpha;
		double x3=p.getX()+(2.0/3.0)*ma*cosalpha;
		double y1=p.getY()+(1.0/3.0)*ma*Math.sin(Math.acos(cosalpha));
		double y2=y1;
		double y3=p.getY()-(2.0/3.0)*ma*Math.sin(Math.acos(cosalpha));
		g2.draw(new Line2D.Double(x1,y1,x2,y2));
		g2.draw(new Line2D.Double(x2,y2,x3,y3));
		g2.draw(new Line2D.Double(x3,y3,x1,y1));
	}
	String getParams() 
	{
		// TODO Auto-generated method stub
		return null;
	}
	void setDimension()
	{
		double ma=Math.sqrt(2*b*b+2*c*c-a*a)*0.5;
		double mb=Math.sqrt(2*a*a+2*c*c-b*b)*0.5;
		double mc=Math.sqrt(2*b*b+2*a*a-c*c)*0.5;
		double length;
		if(ma>=mb)
		{
			length=ma;
		}
		else
		{
			length=mb;
		}
		if(length<mc)
		{
			length=mc;
		}
		Dimension d=new Dimension();
		Point end=new Point();
		d.setSize(2*length, 2*length);
		end.setLocation(center.getX()-length, center.getY()-length);
		setLocation(end);
		setSize(d);
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
	void changeAngle(double a)
	{
		angle=a;
	}
	void changeA(double a)
	{
		this.a=a;
	}
	void changeB(double b)
	{
		this.b=b;
	}
	void changeC(double c)
	{
		this.c=c;
	}
}
