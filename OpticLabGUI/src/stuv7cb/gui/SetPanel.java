package stuv7cb.gui;

import javax.swing.JPanel;
import javax.swing.JTextField;

abstract class SetPanel extends JPanel 
{
	protected JTextField xcord = new JTextField("x");
	protected JTextField ycord = new JTextField("y");
	protected JPanel panel;
	SetPanel(JPanel p)
	{
		panel=p;
	}
	abstract void addFields();
	abstract void addObject();
}
