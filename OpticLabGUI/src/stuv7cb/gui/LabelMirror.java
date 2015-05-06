package stuv7cb.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.geom.Line2D;

class LabelMirror extends LabelDisplay
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6920621717725167293L;
	/**
	 * @param p Координаты центра
	 * @param l Длина зеркала
	 * @param a Угол наклона, отсчитывающийся от вертикали (в радианах)
	 */
	LabelMirror(Point p, double l, double a)
	{
		super(p, l, a);
		ID=3;
		length=l;
		angle=a;
		setSize((int)(length*Math.sin(angle))+10, (int)(length*Math.cos(angle))+10);
	}
	public void paintComponent(Graphics g)
	{
		Graphics2D g2=(Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setPaint(Color.black);
		Point p=new Point();
		p.setLocation(center.getX()-getLocation().getX(), center.getY()-getLocation().getY());
		g2.rotate(angle, p.getX(), p.getY());
		g2.draw(new Line2D.Double(p.getX(), p.getY()-0.5*length, p.getX(), p.getY()+0.5*length));
		for (int i=(int)(0.5*length); i>=(int)(-0.5*length); i-=4)
		{
			g2.draw(new Line2D.Double(p.getX(), p.getY()+i, p.getX()+5, p.getY()+i));
		}
		g2.rotate(-angle, p.getX(), p.getY());
	}
}
