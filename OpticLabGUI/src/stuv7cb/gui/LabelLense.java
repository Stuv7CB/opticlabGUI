package stuv7cb.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

import javax.swing.JLabel;

class LabelLense extends JLabel 
{
	static private int number=0;
	private int id;
	private final double length;
	private final double f;
	LabelLense(double l, double f)
	{
		id=number;
		number++;
		length=l;
		setSize(30,(int)l);
		this.f=f;
	}
	public void paint(Graphics g)
	{
		Graphics2D g2=(Graphics2D) g;
		g2.setPaint(Color.black);
		g2.draw(new Line2D.Double(15d,0d,15d,length));
		g2.draw(new Line2D.Double(15d,0d,3d,12d));
		g2.draw(new Line2D.Double(15d,0d,27d,12d));
		g2.draw(new Line2D.Double(15d,length,3d,length-13d));
		g2.draw(new Line2D.Double(15d,length,27d,length-13d));
	}
}

class LabelSource extends JLabel
{
	
}

class LabelScreen extends JLabel
{
	
}

