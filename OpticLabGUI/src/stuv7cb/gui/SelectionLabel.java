package stuv7cb.gui;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JLabel;

class SelectionLabel extends JLabel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7255951589130964243L;
	static MainFrame parent;
	protected final static String[] NAME={"Источник","Экран","Линза", "Зеркало", "Плоскопараллельная пластиика", "Лазер", "Призма", "Сферическое зеркало", "Толстая линза", "Эллептическое зеркало"};
	private int ID;
	SelectionLabel(int i)
	{
		super(NAME[i]);
		ID=i;
		setSize(100, 20);
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
		setToolTipText(getText());
	}
	class MyMouseListener implements MouseListener
	{

		@Override
		public void mouseClicked(MouseEvent e)
		{
			@SuppressWarnings("unused")
			SetFrame setFrame = new SetFrame(parent, ID);
			
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
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e)
		{
			// TODO Auto-generated method stub
			
		}
		
	}
}
