package stuv7cb.gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Line2D;

import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

class LabelWall extends LabelObject
{
	private double length;
	private double angle;
	LabelWall(double l, double a)
	{
		ID=1;
		length=l;
		angle=a;
		setSize((int)(length*Math.sin(angle))+10, (int)(length*Math.cos(angle))+10);
	}
	public void paint(Graphics g)
	{
		Graphics2D g2=(Graphics2D) g;
		g2.setPaint(Color.black);
		g2.draw(new Line2D.Double(5, getSize().getHeight()-5, getSize().getWidth()-5, 5));
		for (int i=(int)length; i>=0; i-=4)
		{
			g2.draw(new Line2D.Double(getSize().getWidth()-i*Math.sin(angle)-5, i*Math.cos(angle)+5, getSize().getWidth()-i*Math.sin(angle), i*Math.cos(angle)+5));
		}
	}
	void changeLength(double l)
	{
		length=l;
	}
	void changeAngle(double a)
	{
		angle=a;
	}
	@Override
	String getParams() 
	{
		String line="";
		line+=line+getLocation().getX()+" "+getLocation().getY()+" "+length+" "+0;
		return line;
	}
}
