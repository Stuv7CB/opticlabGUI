package stuv7cb.gui;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

class SetPlate extends SetPanel
{
	protected JTextField length=new JTextField("Длина");
	protected JTextField width=new JTextField("Ширина");
	protected JTextField n=new JTextField("Показатель преломления");
	SetPlate(MainFrame f) 
	{
		super(f);
	}

	@Override
	void addFields()
	{
		setLayout(new GridLayout(6,1));
		add(xcord);
		add(ycord);
		add(length);
		add(width);
		add(angle);
		add(n);
	}
	@Override
	void addObject()
	{
		LabelPlate label=new LabelPlate(Double.valueOf(length.getText()), Double.valueOf(width.getText()),Double.valueOf(angle.getText()),Double.valueOf(n.getText()));
		label.setLocation(Integer.valueOf(xcord.getText()), Integer.valueOf(ycord.getText()));
		label.addMouseControl();
		frame.mainPaneladd(label);
		label.addPopup();
		label.updateUI();
	}

}
