package stuv7cb.gui;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

class SetSource extends SetPanel {

	SetSource(MainFrame f)
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
		LabelSource label=new LabelSource();
		label.setLocation(Integer.valueOf(xcord.getText()), Integer.valueOf(ycord.getText()));
		frame.mainPaneladd(label);
		label.updateUI();
	}

}
