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
import javax.swing.SwingUtilities;

class LabelLense extends JLabel 
{
	static private int number=0;
	private int id;
	private final double length;
	private final double f;
	private int clickX;
	private int clickY;
	private JPopupMenu popup=new JPopupMenu();
	LabelLense(double l, double f)
	{
		id=number;
		number++;
		length=l;
		setSize(30,(int)l);
		this.f=f;
		LabelLense label=this;
		addMouseMotionListener(new MouseMotionListener()
		{
			@Override		
			public void mouseDragged(MouseEvent e) 
			{
				label.setLocation(label.getX()+e.getX()-clickX, label.getY()+e.getY()-clickY);	
			}
			@Override
			public void mouseMoved(MouseEvent e) 
			{
				// TODO Auto-generated method stub	
			}
		});
		addMouseListener(new MouseListener()
		{

			@Override
			public void mouseClicked(MouseEvent e)
			{
				if(e.getButton()==e.BUTTON1)
				{
					popup.setVisible(true);
					System.out.println("I'm here!");
				}
			}

			@Override
			public void mouseEntered(MouseEvent e)
			{
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) 
			{
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) 
			{
				clickX=e.getX();
				clickY=e.getY();
			}

			@Override
			public void mouseReleased(MouseEvent e) 
			{
				// TODO Auto-generated method stub
				
			}
			
		});
	}
	void addPopup()
	{
		Container c = this;
		while ( c.getParent() != null)
		{
		  c = c.getParent();
		  if(c instanceof MainPanel)
		  {
			  break;
		  }
		}
		MainPanel q=(MainPanel) c;
		JMenuItem delete=new JMenuItem("Удалить.");
		JLabel label=this;
		delete.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e) 
			{
				q.remove(label);
			}
			
		});
		popup.add(delete);
		popup.updateUI();
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