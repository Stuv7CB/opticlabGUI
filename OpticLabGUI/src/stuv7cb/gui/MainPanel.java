package stuv7cb.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

import javax.swing.JPanel;

class MainPanel extends JPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -9219598316468885909L;
	private ArrayList<Line2D.Double> array=new ArrayList<Line2D.Double>();
	void paintNewLine(String line)
	{
		Scanner lineScanner=new Scanner(line);
		lineScanner.useLocale(Locale.US);
		ArrayList<Double> params = new ArrayList<Double>();
		while(lineScanner.hasNext())
		{
			if(lineScanner.hasNextDouble())
			{
				params.add(lineScanner.nextDouble());
			}
			else
			{
				lineScanner.next();
			}
		}
		lineScanner.close();
		int i=0;
		array.add(new Line2D.Double(params.get(i++),params.get(i++),params.get(i++),params.get(i++)));
	}
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2=(Graphics2D)g;
		g2.setColor(Color.white);
		g2.fillRect(0, 0, getWidth(), getHeight());
		g2.setColor(Color.black);
		for(int i=0; i<array.size(); i++)
		{
			g2.draw(array.get(i));
		}
	}
	void clean()
	{
		array.clear();
	}
}
