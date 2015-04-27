package stuv7cb.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Line2D;

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
	LabelLense(double l, double f, double a)
	{
		ID=2;
		length=l;
		angle=a;
		focus=f;
		setSize((int)(length*Math.abs(Math.sin(angle)))+10, (int)(length*Math.abs(Math.cos(angle)))+10);
	}
	public void paint(Graphics g)
	{
		Graphics2D g2=(Graphics2D) g;
		g2.setPaint(Color.black);
		g2.draw(new Line2D.Double(5, getSize().getHeight()-5, getSize().getWidth()-5, 5));
		g2.draw(new Line2D.Double(5, getSize().getHeight()-5, 15*Math.sin(angle+0.261799388)+5, getSize().getHeight()-15*Math.cos(angle+0.261799388)-5));
		g2.draw(new Line2D.Double(5, getSize().getHeight()-5, 15*Math.sin(angle-0.261799388)+5, getSize().getHeight()-15*Math.cos(angle-0.261799388)-5));
		g2.draw(new Line2D.Double(getSize().getWidth()-5, 5, getSize().getWidth()-5-15*Math.sin(angle+0.261799388), 5+15*Math.cos(angle+0.261799388)));
		g2.draw(new Line2D.Double(getSize().getWidth()-5, 5, getSize().getWidth()-5-15*Math.sin(angle-0.261799388), 5+15*Math.cos(angle-0.261799388)));
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
		line+=line+getLocation().getX()+" "+getLocation().getY()+" "+length+" "+0+" "+focus;
		return line;
	}
}