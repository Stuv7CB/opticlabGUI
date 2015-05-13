package stuv7cb.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.geom.Arc2D;
import java.awt.geom.Line2D;

class LabelRealLense extends LabelObject
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4205626896439938682L;
	private double angle;
	private Point center;
	private double d;
	private double length;
	private double n;
	private double R1;
	private double R2;
	/**
	 * @param p Координата центра
	 * @param R1 Длина линзы
	 * @param R2 Фокусное расстояние
	 * @param a Угол наклона, отсчитываемый от вертикали (в радианах)
	 * @param n Показатель преломления
	 * @param l Длина линзы
	 * @param d Толщина
	 */
	LabelRealLense(Point p, double R1, double R2, double a, double n, double l, double d)
	{
		center=p;
		ID=8;
		this.R1=R1;
		angle=a;
		this.R2=R2;
		this.n=n;
		this.d=d;
		length=l;
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
	void changeD(double d)
	{
		this.d=d;
	}
	void changeLength(double l)
	{
		length=l;
	}
	void changeN(double n)
	{
		this.n=n;
	}
	void changeR1(double R1)
	{
		this.R1=R1;
	}
	void changeR2(double R2)
	{
		this.R2=R2;
	}
	double getAngle()
	{
		return angle*180/Math.PI;
	}
	Point getCenter()
	{
		return center;
	}
	double getD()
	{
		return d;
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
		line+=line+center.getX()+" "+center.getY()+" "+R1+" "+R2+" "+angle*(180/Math.PI)+" "+n+" "+length+" "+d;
		return line;
	}
	double getR1()
	{
		return R1;
	}
	double getR2()
	{
		return R2;
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
		if(R1<0)
		{
			double th=Math.asin(length/(2*Math.abs(R1)))*180/Math.PI;
			g2.draw(new Arc2D.Double(p.getX()-0.5*d+2*R1, p.getY()+R1, -2.0*R1, -2.0*R1, -th, 2*th, Arc2D.OPEN));
			g2.draw(new Line2D.Double(p.getX()-0.5*d-Math.abs(R1)*(1-Math.cos(th)), p.getY()-0.5*length, p.getX(), p.getY()-0.5*length));
			g2.draw(new Line2D.Double(p.getX()-0.5*d-Math.abs(R1)*(1-Math.cos(th)), p.getY()+0.5*length, p.getX(), p.getY()+0.5*length));
		}
		else
		{
			double th=Math.asin(length/(2*Math.abs(R1)))*180/Math.PI;
			g2.draw(new Arc2D.Double(p.getX()-0.5*d, p.getY()-R1, 2.0*R1, 2.0*R1, 180-th, 2*th, Arc2D.OPEN));
			g2.draw(new Line2D.Double(p.getX()-0.5*d, p.getY()-0.5*length, p.getX(), p.getY()-0.5*length));
			g2.draw(new Line2D.Double(p.getX()-0.5*d, p.getY()+0.5*length, p.getX(), p.getY()+0.5*length));
		}
		if(R2<0)
		{
			double th=Math.asin(length/(2*Math.abs(R2)))*180/Math.PI;
			g2.draw(new Arc2D.Double(p.getX()+0.5*d, p.getY()+R2, -2.0*R2, -2.0*R2, 180-th, 2*th, Arc2D.OPEN));
			g2.draw(new Line2D.Double(p.getX()+0.5*d+Math.abs(R1)*(1-Math.cos(th)), p.getY()-0.5*length, p.getX(), p.getY()-0.5*length));
			g2.draw(new Line2D.Double(p.getX()+0.5*d+Math.abs(R1)*(1-Math.cos(th)), p.getY()+0.5*length, p.getX(), p.getY()+0.5*length));
		}
		else
		{
			double th=Math.asin(length/(2*Math.abs(R2)))*180/Math.PI;
			g2.draw(new Arc2D.Double(p.getX()+0.5*d-2*R2, p.getY()-R2, 2.0*R2, 2.0*R2, -th, 2*th, Arc2D.OPEN));
			g2.draw(new Line2D.Double(p.getX()+0.5*d, p.getY()-0.5*length, p.getX(), p.getY()-0.5*length));
			g2.draw(new Line2D.Double(p.getX()+0.5*d, p.getY()+0.5*length, p.getX(), p.getY()+0.5*length));
		}
		g2.rotate(angle, p.getX(), p.getY());
	}
	void setDimension()
	{
		Dimension dim=new Dimension();
		dim.setSize(2*length, 2*length);
		Point p=new Point();
		p.setLocation(center.getX()-dim.getWidth()/2.0, center.getY()-dim.getHeight()/2.0);
		setLocation(p);
		setSize(dim);
	}
}