package stuv7cb.gui;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

class LabelLaser extends LabelObject
{
	private double angle;
	private Point center;
	LabelLaser(Point p, double a)
	{
		center=p;
		angle=a;
		ID=5;
		setDimension();
	}
	public void paint(Graphics g)
	{
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
		angle=a;
	}
}
