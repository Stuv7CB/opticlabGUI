package stuv7cb.gui;

import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JTextField;

class SetWall extends SetPanel
{
	private JTextField length=new JTextField("Длина");
	SetWall(JPanel p) 
	{
		super(p);
	}

	@Override
	void addFields()
	{
		setLayout(new GridLayout(3,1));
		add(xcord);
		add(ycord);
		add(length);
	}
	@Override
	void addObject()
	{
		LabelWall label=new LabelWall(Double.valueOf(length.getText()));
		label.setLocation(Integer.valueOf(xcord.getText()), Integer.valueOf(ycord.getText()));
		panel.add(label);
		label.updateUI();
	}

}
