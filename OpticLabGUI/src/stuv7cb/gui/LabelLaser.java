package stuv7cb.gui;

import java.awt.Container;
import java.awt.Graphics;
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
	LabelLaser(double a)
	{
		ID=5;
		angle=a;
		setSize(26,26);
	}
	public void paint(Graphics g)
	{
		g.fillOval(13, 13, 3, 3);
	}
	@Override
	String getParams() 
	{
		String line="";
		line=line+getLocation().getX()+" "+getLocation().getY()+" "+angle;
		return line;
	}

}