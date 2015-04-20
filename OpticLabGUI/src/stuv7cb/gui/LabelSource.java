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

class LabelSource extends LabelObject
{
	private int clickX;
	private int clickY;
	private JPopupMenu popup=new JPopupMenu();
	LabelSource()
	{
		ID=1;
		setSize(26,26);
		JLabel label=this;
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
				if (e.getButton()==e.BUTTON3)
				{
			        popup.show(e.getComponent(), e.getX(), e.getY());
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
				q.updateUI();
			}
			
		});
		popup.add(delete);
		popup.updateUI();
	}
	public void paint(Graphics g)
	{
		g.fillOval(13, 13, 3, 3);
	}

}
