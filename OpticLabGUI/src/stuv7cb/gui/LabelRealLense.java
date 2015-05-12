package stuv7cb.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.geom.Arc2D;

class LabelRealLense extends LabelObject
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4205626896439938682L;
	private double R1;
	private double R2;
	private double angle;
	private Point center;
	private double n;
	private double d;
	private double length;
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
			double th=Math.asin(2*length/R1);
			g2.draw(new Arc2D.Double(p.getX()-R1*(1-Math.cos(th))-2*R1-d/2.0, p.getY()-R1, 2*R1, 2*R1,-th*180/Math.PI, 2*th*180/Math.PI, Arc2D.OPEN));
		}
		else
		{
			double th=Math.asin(2*length/R1);
			g2.draw(new Arc2D.Double(p.getX()-R1*(1-Math.cos(th))+d/2.0, p.getY()-R1, 2*R1, 2*R1, 180+180*th/Math.PI, -2*th*180/Math.PI, Arc2D.OPEN));
		}
		if(R2<0)
		{
			double th=Math.asin(2*length/R1);
			g2.draw(new Arc2D.Double(p.getX()+R2*(1-Math.cos(th))+d/2.0, p.getY()-R2, 2*R2, 2*R2,180+th*180/Math.PI, -2*th*180/Math.PI, Arc2D.OPEN));
		}
		else
		{
			double th=Math.asin(2*length/R1);
			g2.draw(new Arc2D.Double(p.getX()-R2*Math.cos(th)-R2-d/2.0, p.getY()-R2, 2*R2, 2*R2, -180*th/Math.PI, 2*th, Arc2D.OPEN));
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
	void changeR1(double R1)
	{
		this.R1=R1;
	}
	void changeR2(double R2)
	{
		this.R2=R2;
	}
	void changeD(double d)
	{
		this.d=d;
	}
	void changeN(double n)
	{
		this.n=n;
	}
	String getParams()
	{
		String line="";
		line+=line+center.getX()+" "+center.getY()+" "+length+" "+angle*(180/Math.PI)+" "+d+" "+R1+" "+R2+" "+n;
		return line;
	}
	void setDimension()
	{
		Dimension dim=new Dimension();
		dim.setSize(Math.abs(R1)+Math.abs(R2)+d, Math.abs(R1)+Math.abs(R2)+d);
		Point p=new Point();
		p.setLocation(center.getX()-dim.getWidth()/2.0, center.getY()-dim.getHeight()/2.0);
		setLocation(p);
		setSize(dim);
	}
	void changeCenter(double x, double y)
	{
		center.setLocation(x, y);
	}
	Point getCenter()
	{
		return center;
	}
}