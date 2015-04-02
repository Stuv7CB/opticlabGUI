package stuv7cb.gui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;

class LabelWall extends JLabel 
{
	LabelWall(String type)
	{
		super(type);
		JLabel label=this;
		addMouseListener(new MouseListener()
		{
			private int X;
			private int Y;
			@Override
			public void mouseClicked(MouseEvent event)
			{
				
			}

			@Override
			public void mouseEntered(MouseEvent event)
			{

			}


			@Override

			public void mouseExited(MouseEvent event) 
			{

			}


			@Override

			public void mousePressed(MouseEvent event)
			{
				X=event.getX();
				Y=event.getY();
			}

			@Override
			public void mouseReleased(MouseEvent event)
			{
				label.setLocation(label.getX()+event.getX()-X, label.getY()+event.getY()-Y);
			}
		});
	}
}
