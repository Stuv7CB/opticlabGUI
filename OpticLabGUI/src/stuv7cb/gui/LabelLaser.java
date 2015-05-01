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
	private Point center;
	LabelLaser(Point p, double a)
	{
		center=p;
		ID=5;
		setDimension();
	}
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.fillOval(3, 3, 6, 6);
	}
	@Override
	String getParams() 
	{
		String line="";
		line=line+center.getX()+" "+center.getY();
		return line;
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
	}
}
