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

class LabelPlate extends LabelObject
{
	private double length;
	private double width;
	private double angle;
	private double n;
	LabelPlate(double l, double w, double a, double n)
	{
		ID=4;
		length=l;
		angle=a;
		width=w;
		this.n=n;
		setSize((int)(length*Math.sin(angle)+width*Math.cos(angle)),(int)(length*Math.cos(angle)+width*Math.sin(angle)));
	}
	public void paint(Graphics g)
	{
		Graphics2D g2=(Graphics2D) g;
		g2.setPaint(Color.black);
		g2.draw(new Line2D.Double(0,length*Math.cos(angle), length*Math.sin(angle), 0));
		g2.draw(new Line2D.Double(length*Math.sin(angle), 0, getSize().getWidth(), width*Math.sin(angle)));
		g2.draw(new Line2D.Double(getSize().getWidth(), width*Math.sin(angle), width*Math.cos(angle), getSize().getHeight()));
		g2.draw(new Line2D.Double(width*Math.cos(angle), getSize().getHeight(), 0,length*Math.cos(angle)));
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
		// TODO Auto-generated method stub
		return null;
	}
}
