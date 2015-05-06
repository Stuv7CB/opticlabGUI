package stuv7cb.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.geom.Line2D;

class LabelPrism extends LabelObject
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4197113709182642607L;
	private double a;
	private double b;
	private double c;
	private double angle;
	private Point center;
	private double n;
	private double x1;
	private double x2;
	private double x3;
	private double y1;
	private double y2;
	private double y3;
	private final boolean CONSTRUCTOR2;
	LabelPrism(Point p, double a, double b, double c, double angle, double n)
	{
		ID=6;
		this.a=a;
		this.b=b;
		this.c=c;
		this.angle=angle;
		this.n=n;
		center=p;
		CONSTRUCTOR2=false;
		setDimension();
	}
	LabelPrism(Point p, double x1, double y1, double x2, double y2, double x3, double y3, double n)
	{
		ID=6;
		this.x1=x1;
		this.y1=y1;
		this.x2=x2;
		this.y2=y2;
		this.x3=x3;
		this.y3=y3;
		this.n=n;
		center=p;
		CONSTRUCTOR2=true;
		setDimension();
	}
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2=(Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setPaint(Color.black);
		Point p=new Point();
		p.setLocation(center.getX()-getLocation().getX(), center.getY()-getLocation().getY());
		if(!CONSTRUCTOR2)
		{
			g2.rotate(-angle, p.getX(), p.getY());
			double ma=Math.sqrt(2*b*b+2*c*c-a*a)*0.5;
			double cosalpha=(b*b-0.25*a*a-ma*ma)/(-1.0*a*ma);
			x1=p.getX()-0.5*a-(1.0/3.0)*ma*cosalpha;
			x2=p.getX()+0.5*a-(1.0/3.0)*ma*cosalpha;
			x3=p.getX()+(2.0/3.0)*ma*cosalpha;
			y1=p.getY()+(1.0/3.0)*ma*Math.sin(Math.acos(cosalpha));
			y2=y1;
			y3=p.getY()-(2.0/3.0)*ma*Math.sin(Math.acos(cosalpha));
			g2.rotate(angle, p.getX(), p.getY());
		}
		g2.draw(new Line2D.Double(x1,y1,x2,y2));
		g2.draw(new Line2D.Double(x2,y2,x3,y3));
		g2.draw(new Line2D.Double(x3,y3,x1,y1));
	}
	String getParams() 
	{
		String line=""+x1+" "+y1+" "+x2+" "+y2+" "+x3+" "+y3+" "+n;
		return line;
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
		angle=a*Math.PI/180;
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
