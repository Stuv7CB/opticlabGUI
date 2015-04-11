package stuv7cb.gui;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import javax.swing.JPanel;

class MainPanel extends JPanel
{
	void paintNewLine(double x0, double y0, double x, double y)
	{
		Graphics2D g2 = (Graphics2D) getGraphics();
		g2.setColor(Color.black);
		g2.draw(new Line2D.Double(x0,y0,x,y));
	}
}
