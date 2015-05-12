package stuv7cb.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.geom.Line2D;

class LabelLense extends LabelObject
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4205626896439938682L;
	private double length;
	private double focus;
	private double angle;
	private Point center;
	/**
	 * @param p Координата центра
	 * @param l Длина линзы
	 * @param f Фокусное расстояние
	 * @param a Угол наклона, отсчитываемый от вертикали (в радианах)
	 */
	LabelLense(Point p, double l, double f, double a)
	{
		center=p;
		ID=2;
		length=l;
		angle=a;
		focus=f;
		setDimension();
	}
	double getLength()
	{
		return length;
	}
	double getFocus()
	{
		return focus;
	}
	double getAngle()
	{
		return angle*180/Math.PI;
	}
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2=(Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setPaint(Color.black);
		g2.setBackground(Color.WHITE);
		Point p=new Point();
		p.setLocation(center.getX()-getLocation().getX(), center.getY()-getLocation().getY());
		g2.rotate(-angle, p.getX(), p.getY());
		g2.draw(new Line2D.Double(p.getX(), p.getY()-0.5*length, p.getX(), p.getY()+0.5*length));
		if(focus>0.0)
		{
			g2.draw(new Line2D.Double(p.getX(), p.getY()-0.5*length, p.getX()+5, p.getY()-0.5*length+5));
			g2.draw(new Line2D.Double(p.getX(), p.getY()-0.5*length, p.getX()-5, p.getY()-0.5*length+5));
			g2.draw(new Line2D.Double(p.getX(), p.getY()+0.5*length, p.getX()+5, p.getY()+0.5*length-5));
			g2.draw(new Line2D.Double(p.getX(), p.getY()+0.5*length, p.getX()-5, p.getY()+0.5*length-5));
		}
		else
		{
			g2.draw(new Line2D.Double(p.getX(), p.getY()-0.5*length, p.getX()+5, p.getY()-0.5*length-5));
			g2.draw(new Line2D.Double(p.getX(), p.getY()-0.5*length, p.getX()-5, p.getY()-0.5*length-5));
			g2.draw(new Line2D.Double(p.getX(), p.getY()+0.5*length, p.getX()+5, p.getY()+0.5*length+5));
			g2.draw(new Line2D.Double(p.getX(), p.getY()+0.5*length, p.getX()-5, p.getY()+0.5*length+5));
		}
		g2.rotate(angle, p.getX(), p.getY());
	}
	void changeLength(double l)
	{
		length=l;
	}
	void changeAngle(double a)
	{
		angle=a*Math.PI/180;
	}
	String getParams()
	{
		String line="";
		line+=line+center.getX()+" "+center.getY()+" "+length+" "+angle*(180/Math.PI)+" "+focus;
		return line;
	}
	void setDimension()
	{
		Point end1=new Point();
		end1.setLocation(center.getX()+0.5*length*Math.sin(angle), center.getY()-0.5*length*Math.cos(angle));
		Point end2=new Point();
		end2.setLocation(center.getX()-0.5*length*Math.sin(angle), center.getY()+0.5*length*Math.cos(angle));
		double x;
		double width;
		double y;
		double height;
		if(end2.getX()<end1.getX())
		{
			x=end2.getX();
			width=end1.getX()-end2.getX()+10;
		}
		else
		{
			x=end1.getX();
			width=end2.getX()-end1.getX()+10;
		}
		if(end2.getY()<end1.getY())
		{
			y=end2.getY();
			height=end1.getY()-end2.getY()+10;
		}
		else
		{
			y=end1.getY();
			height=end2.getY()-end1.getY()+10;
		}
		end1.setLocation(x-5,y-5);
		setLocation(end1);
		Dimension d=new Dimension();
		d.setSize(width, height);
		setSize(d);
	}
	void changeCenter(double x, double y)
	{
		center.setLocation(x, y);
	}
	Point getCenter()
	{
		return center;
	}
	void changeFocus(double f)
	{
		focus=f;
	}
}