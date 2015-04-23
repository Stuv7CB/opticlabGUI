package stuv7cb.gui;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

class SetWall extends SetPanel
{
	protected JTextField length=new JTextField("Длина");
	SetWall(MainFrame f) 
	{
		super(f);
	}

	@Override
	void addFields()
	{
		setLayout(new GridLayout(4,1));
		add(xcord);
		add(ycord);
		add(length);
		add(angle);
	}
	@Override
	void addObject()
	{
		LabelWall label=new LabelWall(Double.valueOf(length.getText()), Double.valueOf(angle.getText()));
		label.setLocation(Integer.valueOf(xcord.getText()), Integer.valueOf(ycord.getText()));
		label.addMouseControl();
		frame.mainPaneladd(label);
		label.addPopup();
		label.updateUI();
	}

}
