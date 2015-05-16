package stuv7cb.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.geom.Line2D;
import java.util.Arrays;

class LabelPrism extends LabelObject
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4197113709182642607L;
	private double n;
	private Point center;
	private Point B;
	private Point C;
	LabelPrism(Point p, Point b, Point c, double n)
	{
		ID=6;
		center=p;
		B=b;
		C=c;
		this.n=n;
		setDimension();
	}
	void changeCenter(double x, double y)
	{
		double dx=x-center.getX();
		double dy=y-center.getY();
		center.setLocation(x, y);
		B.setLocation(B.getX()+dx, B.getY()+dy);
		C.setLocation(C.getX()+dx, C.getY()+dy);
	}
	void changeA(double x, double y)
	{
		center.setLocation(x, y);
	}
	void changeB(double x, double y)
	{
		B.setLocation(x, y);
	}
	void changeC(double x, double y)
	{
		C.setLocation(x, y);
	}
	void changeN(double n)
	{
		this.n=n;
	}
	Point getB() {
		return B;
	}
	Point getC() {
		return C;
	}
	Point getCenter()
	{
		return center;
	}
	double getN() {
		return n;
	}
	String getParams() 
	{
		String line=""+center.getX()+" "+center.getY()+" "+B.getX()+" "+B.getY()+" "+C.getX()+" "+C.getY()+" "+n;
		return line;
	}
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2=(Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setPaint(Color.black);
		Point p=new Point();
		Point r=new Point();
		Point s=new Point();
		p.setLocation(center.getX()-getLocation().getX(), center.getY()-getLocation().getY());
		r.setLocation(B.getX()-getLocation().getX(), B.getY()-getLocation().getY());
		s.setLocation(C.getX()-getLocation().getX(), C.getY()-getLocation().getY());
		g2.draw(new Line2D.Double(p, r));
		g2.draw(new Line2D.Double(r, s));
		g2.draw(new Line2D.Double(s, p));
	}
	void setDimension()
	{
		Point p=new Point();
		double[] arrX={center.getX(), B.getX(), C.getX()};
		double[] arrY={center.getY(), B.getY(), C.getY()};
		Arrays.sort(arrX);
		Arrays.sort(arrY);
		p.setLocation(arrX[0], arrY[0]);
		Dimension d=new Dimension();
		d.setSize(arrX[2]-arrX[0]+1, arrY[2]-arrY[0]+1);
		setLocation(p);
		setSize(d);
	}
}
