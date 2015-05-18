package stuv7cb.gui;

import java.awt.GridLayout;
import java.awt.Point;

import javax.swing.JLabel;
import javax.swing.JTextField;

class SetPlate extends SetPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4885437619672643210L;
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
		setLayout(new GridLayout(12,1));
		add(new JLabel("Пластинка"));
		add(new JLabel("Координаты"));
		add(xcord);
		add(ycord);
		add(new JLabel("Длина"));
		add(length);
		add(new JLabel("Ширина"));
		add(width);
		add(new JLabel("Угол"));
		add(angle);
		add(new JLabel("Показатель преломления"));
		add(n);
	}
	@Override
	void addObject()
	{
		Point p=new Point();
		p.setLocation(Double.valueOf(xcord.getText()), Double.valueOf(ycord.getText()));
		LabelPlate label=new LabelPlate(p, Double.valueOf(length.getText()), Double.valueOf(width.getText()),Math.PI*Double.valueOf(angle.getText())/180,Double.valueOf(n.getText()));
		label.addMouseControl();
		frame.mainPaneladd(label);
		label.addPopup();
		label.updateUI();
	}

}
