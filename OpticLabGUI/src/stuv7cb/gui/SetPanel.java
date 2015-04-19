package stuv7cb.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

abstract class SetPanel extends JPanel 
{
	protected JTextField xcord = new JTextField("x");
	protected JTextField ycord = new JTextField("y");
	protected JTextField angle = new JTextField("Угол");
	protected MainFrame frame;
	SetPanel(MainFrame f)
	{
		frame=f;
	}
	abstract void addFields();
	abstract void addObject();
}
