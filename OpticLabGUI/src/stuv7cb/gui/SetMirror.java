package stuv7cb.gui;

import java.awt.GridLayout;
import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

class SetMirror extends SetPanel
{
	protected JTextField length=new JTextField("Длина");
	SetMirror(MainFrame f) 
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
		Point p=new Point();
		p.setLocation(Double.valueOf(xcord.getText()), Double.valueOf(ycord.getText()));
		LabelMirror label=new LabelMirror(p, Double.valueOf(length.getText()), Double.valueOf(angle.getText()));
		label.addMouseControl();
		frame.mainPaneladd(label);
		label.addPopup();
		label.updateUI();
	}

}
