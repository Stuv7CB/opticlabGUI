package stuv7cb.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Line2D;
import java.awt.geom.Line2D.Double;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

class LabelLense extends LabelObject
{
	private double length;
	private double focus;
	private double angle;
	private Point center;
	LabelLense(Point p, double l, double f, double a)
	{
		center=p;
		ID=2;
		length=l;
		angle=a;
		focus=f;
		setDimension(center);
	}
	public void paint(Graphics g)
	{
		Graphics2D g2=(Graphics2D) g;
		g2.setPaint(Color.black);
		/*
		g2.draw(new Line2D.Double(5, getSize().getHeight()-5, getSize().getWidth()-5, 5));
		g2.draw(new Line2D.Double(5, getSize().getHeight()-5, 15*Math.sin(angle+0.261799388)+5, getSize().getHeight()-15*Math.cos(angle+0.261799388)-5));
		g2.draw(new Line2D.Double(5, getSize().getHeight()-5, 15*Math.sin(angle-0.261799388)+5, getSize().getHeight()-15*Math.cos(angle-0.261799388)-5));
		g2.draw(new Line2D.Double(getSize().getWidth()-5, 5, getSize().getWidth()-5-15*Math.sin(angle+0.261799388), 5+15*Math.cos(angle+0.261799388)));
		g2.draw(new Line2D.Double(getSize().getWidth()-5, 5, getSize().getWidth()-5-15*Math.sin(angle-0.261799388), 5+15*Math.cos(angle-0.261799388)));
		*/
		Point end1=new Point();
		end1.setLocation(center.getX()+0.5*length*Math.sin(angle)-getLocation().getX(), center.getY()-0.5*length*Math.cos(angle)-getLocation().getY());
		Point end2=new Point();
		end2.setLocation(center.getX()-0.5*length*Math.sin(angle)-getLocation().getX(), center.getY()+0.5*length*Math.cos(angle)-getLocation().getY());
		g2.draw(new Line2D.Double(end1.getX(), end1.getY(), end2.getX(), end2.getY()));
	}
	void changeLength(double l)
	{
		length=l;
	}
	void changeAngle(double a)
	{
		angle=a;
	}
	String getParams()
	{
		String line="";
		line+=line+center.getX()+" "+center.getY()+" "+length+" "+0+" "+focus;
		return line;
	}
	void setDimension(Point p)
	{
		Point end1=new Point();
		end1.setLocation(p.getX()+0.5*length*Math.sin(angle), p.getY()-0.5*length*Math.cos(angle));
		Point end2=new Point();
		end2.setLocation(p.getX()-0.5*length*Math.sin(angle), p.getY()+0.5*length*Math.cos(angle));
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
	void setCenter(double x, double y)
	{
		center.setLocation(x, y);
	}
}