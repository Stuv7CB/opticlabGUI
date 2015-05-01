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
	private double startAngle;
	private double endAngle;
	private double r;
	private Point center;
	LabelSphereMirror(Point p, double sa, double ea, double r)
	{
		ID=7;
		center=p;
		startAngle=sa;
		endAngle=ea;
		this.r=r;
		setDimension();
	}
	String getParams()
	{
		String line=""+center.getX()+" "+center.getY()+" "+r+" "+startAngle+" "+endAngle;
		return line;
	}
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2=(Graphics2D)g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setPaint(Color.black);
		Point p=new Point();
		p.setLocation(center.getX()-getLocation().getX(), center.getY()-getLocation().getY());
		g2.draw(new Arc2D.Double(0, 0, 2*r, 2*r, startAngle*(180/Math.PI), (endAngle-startAngle)*(180/Math.PI), Arc2D.OPEN));
	}
	void changeCenter(double x, double y)
	{
		center.setLocation(x, y);
	}
	Point getCenter()
	{
		return center;
	}
	void changeStartAngle(double sa)
	{
		startAngle=sa;
	}
	void changeEndAngle(double ea)
	{
		endAngle=ea;
	}
	void changeR(double r)
	{
		this.r=r;
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
