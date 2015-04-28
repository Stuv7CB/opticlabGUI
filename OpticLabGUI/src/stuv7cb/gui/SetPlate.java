package stuv7cb.gui;

import java.awt.GridLayout;
import java.awt.Point;

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
		Point p=new Point();
		p.setLocation(Double.valueOf(xcord.getText()), Double.valueOf(ycord.getText()));
		LabelPlate label=new LabelPlate(p, Double.valueOf(length.getText()), Double.valueOf(width.getText()),Double.valueOf(angle.getText()),Double.valueOf(n.getText()));
		label.addMouseControl();
		frame.mainPaneladd(label);
		label.addPopup();
		label.updateUI();
	}

}
