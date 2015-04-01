package stuv7cb.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

class ButtonRun extends JButton
{
	ButtonRun(String a)
	{
		super(a);
		addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				
			}
		});
	}
}
