package stuv7cb.gui;

import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JTextField;

class SetLense extends SetPanel 
{
	SetLense(JPanel p) 
	{
		super(p);
	}
	private JTextField length=new JTextField("Длина");
	private JTextField f=new JTextField("Фокус");
	@Override
	void addFields() 
	{
		setLayout(new GridLayout(4,1));
		add(xcord);
		add(ycord);
		add(length);
		add(f);
	}
	void addObject() 
	{
		LabelLense label=new LabelLense(Double.valueOf(length.getText()), Double.valueOf(f.getText()));
		label.setLocation(Integer.valueOf(xcord.getText()), Integer.valueOf(ycord.getText()));
		panel.add(label);
		label.addPopup();
		label.updateUI();
	}

}
