package stuv7cb.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.Line2D;

import javax.swing.JPanel;

class MainPanel extends JPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -9219598316468885909L;

	private Image backup;
	void paintNewLine(double x0, double y0, double x, double y)
	{
		Graphics2D saved = (Graphics2D)(backup.getGraphics());
		saved.setColor(Color.black);
		saved.draw(new Line2D.Double(x0,y0,x,y));
	}
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2=(Graphics2D)g;
		g2.setColor(Color.white);
		g2.fillRect(0, 0, getWidth(), getHeight());
	}
	void clean()
	{
		
	}
}
