package stuv7cb.gui;

import java.awt.GridLayout;

import javax.swing.JPanel;

class SetSource extends SetPanel {

	SetSource(JPanel p)
	{
		super(p);
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
		panel.add(label);
		label.updateUI();
	}

}
