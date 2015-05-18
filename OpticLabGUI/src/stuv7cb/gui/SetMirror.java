package stuv7cb.gui;

import java.awt.GridLayout;
import java.awt.Point;

import javax.swing.JLabel;
import javax.swing.JTextField;

class SetMirror extends SetPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5589381610502371215L;
	protected JTextField length=new JTextField("Длина");
	SetMirror(MainFrame f) 
	{
		super(f);
	}

	@Override
	void addFields()
	{
		setLayout(new GridLayout(8,1));
		add(new JLabel("Экран"));
		add(new JLabel("Координаты"));
		add(xcord);
		add(ycord);
		add(new JLabel("Длина"));
		add(length);
		add(new JLabel("Угол"));
		add(angle);
	}
	@Override
	void addObject()
	{
		Point p=new Point();
		p.setLocation(Double.valueOf(xcord.getText()), Double.valueOf(ycord.getText()));
		LabelMirror label=new LabelMirror(p, Double.valueOf(length.getText()), Math.PI*Double.valueOf(angle.getText())/180);
		label.addMouseControl();
		frame.mainPaneladd(label);
		label.addPopup();
		label.updateUI();
	}

}
