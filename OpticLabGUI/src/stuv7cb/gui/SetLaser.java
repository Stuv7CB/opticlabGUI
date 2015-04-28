package stuv7cb.gui;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

class SetLaser extends SetPanel {

	SetLaser(MainFrame f)
	{
		super(f);
	}

	@Override
	void addFields() 
	{
		setLayout(new GridLayout(2,1));
		add(xcord);
		add(ycord);
	}

	@Override
	void addObject() 
	{
		LabelLaser label=new LabelLaser(Double.valueOf(angle.getText()));
		label.setLocation(Integer.valueOf(xcord.getText()), Integer.valueOf(ycord.getText()));
		label.addMouseControl();
		frame.mainPaneladd(label);
		label.addPopup();
		label.updateUI();
	}

}