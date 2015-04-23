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
	LabelWall(double l)
	{
		ID=2;
		length=l;
		setSize(30, (int)l);
	}
	public void paint(Graphics g)
	{
		Graphics2D g2=(Graphics2D) g;
		g2.setPaint(Color.black);
		g2.draw(new Line2D.Double(15d,0d,15d,length));
		for (int i=0; i<length; i+=4)
		{
			g2.draw(new Line2D.Double(15d, (double)i,20d, (double)i+15d));
		}
	}
}
