package stuv7cb.gui;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

class SetLense extends SetPanel 
{
	SetLense(MainFrame f) 
	{
		super(f);
	}
	protected JTextField length=new JTextField("Длина");
	protected JTextField f=new JTextField("Фокус");
	@Override
	void addFields() 
	{
		setLayout(new GridLayout(5,1));
		add(xcord);
		add(ycord);
		add(length);
		add(angle);
		add(f);
	}
	void addObject() 
	{
		LabelLense label=new LabelLense(Double.valueOf(length.getText()), Double.valueOf(f.getText()), Double.valueOf(angle.getText()));
		label.setLocation(Integer.valueOf(xcord.getText()), Integer.valueOf(ycord.getText()));
		label.addMouseControl();
		frame.mainPaneladd(label);
		label.addPopup();
		label.updateUI();
	}
}
