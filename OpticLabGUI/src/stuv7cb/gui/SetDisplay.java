package stuv7cb.gui;

import java.awt.GridLayout;
import java.awt.Point;

import javax.swing.JLabel;
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
		LabelDisplay label;
		if(Double.valueOf(length.getText())>0)
		{
			label=new LabelDisplay(p, Double.valueOf(length.getText()), Math.PI*Double.valueOf(angle.getText())/180);
			label.addMouseControl();
			frame.mainPaneladd(label);
			label.addPopup();
			label.updateUI();
		}
		else
		{
			System.err.println("Wrong params");
		}
	}

}
