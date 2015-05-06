package stuv7cb.gui;

import java.awt.GridLayout;
import java.awt.Point;

import javax.swing.JTextField;

class SetDisplay extends SetPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2556377072587116136L;
	protected JTextField length=new JTextField("Длина");
	SetDisplay(MainFrame f) 
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
		LabelDisplay label=new LabelDisplay(p, Double.valueOf(length.getText()), Math.PI*Double.valueOf(angle.getText())/180);
		label.addMouseControl();
		frame.mainPaneladd(label);
		label.addPopup();
		label.updateUI();
	}

}
