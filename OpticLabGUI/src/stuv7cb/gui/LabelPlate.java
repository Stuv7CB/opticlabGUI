package stuv7cb.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.geom.Rectangle2D;

class LabelPlate extends LabelObject
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4722310494349835255L;
	private double angle;
	private Point center;
	private double length;
	private double n;
	private double span;
	/**
	 * @param p Координаты центра
	 * @param l Длина
	 * @param w Ширина
	 * @param a Угол наклона, отсчитывающийся от вертикали (в радианах)
	 * @param n Показатель преломления
	 */
	LabelPlate(Point p,double l, double w, double a, double n)
	{
		center=p;
		ID=4;
		length=l;
		angle=a;
		span=w;
		this.n=n;
		setDimension();
	}
	void changeAngle(double a)
	{
		angle=a*Math.PI/180;
	}
	void changeCenter(double x, double y)
	{
		center.setLocation(x, y);
	}
	void changeLength(double l)
	{
		length=l;
	}
	void changeN(double n)
	{
		this.n=n;
	}
	void changeWidth(double w)
	{
		span=w;
	}
	double getAngle()
	{
		return angle*180/Math.PI;
	}
	Point getCenter()
	{
		return center;
	}
	double getLength()
	{
		return length;
	}
	double getN()
	{
		return n;
	}
	String getParams()
	{
		String line="";
		line+=line+center.getX()+" "+center.getY()+" "+length+" "+span+" "/*+angle*(180/Math.PI)+" "*/+n;
		return line;
	}
	double getSpan()
	{
		return span;
	}
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2=(Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setPaint(Color.black);
		Point p=new Point();
		p.setLocation(center.getX()-getLocation().getX(), center.getY()-getLocation().getY());
		g2.rotate(-angle, p.getX(), p.getY());
		g2.draw(new Rectangle2D.Double(p.getX()-0.5*span, p.getY()-0.5*length, span, length));
		g2.rotate(angle, p.getX(), p.getY());
	}
	void setDimension()
	{
		Dimension d=new Dimension();
		Point end=new Point();
		d.setSize(Math.abs(length*Math.sin(Math.PI/2.0-angle))+Math.abs(span*Math.sin(angle))+10, Math.abs(length*Math.cos(Math.PI/2.0-angle))+Math.abs(span*Math.cos(angle))+10);
		end.setLocation(center.getX()-d.getWidth()/2.0-5, center.getY()-d.getHeight()/2.0-5);
		setSize(d);
		setLocation(end);
	}
}
