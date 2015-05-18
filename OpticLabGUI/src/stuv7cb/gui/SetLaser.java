package stuv7cb.gui;

import java.awt.GridLayout;
import java.awt.Point;

import javax.swing.JLabel;

class SetLaser extends SetPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 566356238368590914L;

	SetLaser(MainFrame f)
	{
		super(f);
	}

	@Override
	void addFields() 
	{
		setLayout(new GridLayout(6,1));
		add(new JLabel("Лазер"));
		add(new JLabel("Координаты"));
		add(xcord);
		add(ycord);
		add(new JLabel("Угол"));
		add(angle);
	}

	@Override
	void addObject() 
	{
		Point p=new Point();
		p.setLocation(Double.valueOf(xcord.getText()), Double.valueOf(ycord.getText()));
		LabelLaser label=new LabelLaser(p, Double.valueOf(angle.getText()));
		label.addMouseControl();
		frame.mainPaneladd(label);
		label.addPopup();
		label.updateUI();
	}

}
