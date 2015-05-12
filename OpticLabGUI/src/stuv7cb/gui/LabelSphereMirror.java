package stuv7cb.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.geom.Arc2D;

class LabelSphereMirror extends LabelObject
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1456719604479245937L;
	private Point center;
	private double endAngle;
	private double r;
	private double startAngle;
	LabelSphereMirror(Point p, double sa, double ea, double r)
	{
		ID=7;
		center=p;
		startAngle=sa;
		endAngle=ea;
		this.r=r;
		setDimension();
	}
	void changeCenter(double x, double y)
	{
		center.setLocation(x, y);
	}
	void changeEndAngle(double ea)
	{
		endAngle=ea*Math.PI/180;
	}
	void changeR(double r)
	{
		this.r=r;
	}
	void changeStartAngle(double sa)
	{
		startAngle=sa*Math.PI/180;
	}
	Point getCenter()
	{
		return center;
	}
	double getEndAngle()
	{
		return endAngle*180/Math.PI;
	}
	String getParams()
	{
		String line=""+center.getX()+" "+center.getY()+" "+r+" "+startAngle*(180/Math.PI)+" "+endAngle*(180/Math.PI);
		return line;
	}
	double getR()
	{
		return r;
	}
	double getStartAngle()
	{
		return startAngle*180/Math.PI;
	}
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2=(Graphics2D)g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setPaint(Color.black);
		Point p=new Point();
		p.setLocation(center.getX()-getLocation().getX(), center.getY()-getLocation().getY());
		g2.draw(new Arc2D.Double(0, 0, 2*r, 2*r, 180*startAngle/Math.PI, 180*(endAngle-startAngle)/Math.PI, Arc2D.OPEN));
	}
	void setDimension()
	{
		Dimension d=new Dimension();
		Point end=new Point();
		d.setSize(2*r, 2*r);
		end.setLocation(center.getX()-r, center.getY()-r);
		setLocation(end);
		setSize(d);
	}
}
