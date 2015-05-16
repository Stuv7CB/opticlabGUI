package stuv7cb.gui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;

class LabelLaser extends LabelObject
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7342766801550239655L;
	private double angle;
	private Point center;
	/**
	 * @param p Координаты центра
	 * @param a Угол наклона, отсчитывающийся от вертикали (в радианах)
	 */
	LabelLaser(Point p, double a)//Координаты x, y и угол в градусах от горизонтали
	{
		center=p;
		ID=5;
		angle=a;
		setDimension();
	}
	void changeAngle(double a)
	{
		angle=a;
	}
	void changeCenter(double x, double y)
	{
		center.setLocation(x, y);
	}
	double getAngle()
	{
		return angle;
	}
	Point getCenter()
	{
		return center;
	}
	@Override
	String getParams() 
	{
		String line="";
		line=line+center.getX()+" "+center.getY()+" "+angle;
		return line;
	}
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.fillOval(3, 3, 6, 6);
	}
	void setDimension()
	{
		double x=center.getX()-6;
		double y=center.getY()-6;
		Point p=new Point();
		p.setLocation(x, y);
		setLocation(p);
		Dimension d=new Dimension();
		d.setSize(12,12);
		setSize(d);
	}
}
