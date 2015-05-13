package stuv7cb.gui;

import java.awt.GridLayout;
import java.awt.Point;

import javax.swing.JTextField;

class SetEllepticMirror extends SetPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4498204250685127087L;
	protected JTextField a=new JTextField("Большая полуось");
	protected JTextField angle=new JTextField("Угол");
	protected JTextField b=new JTextField("Малая полуось");
	SetEllepticMirror(MainFrame f)
	{
		super(f);
	}

	@Override
	void addFields() 
	{
		setLayout(new GridLayout(5,1));
		add(xcord);
		add(ycord);
		add(angle);
		add(a);
		add(b);
	}

	@Override
	void addObject() 
	{
		Point p=new Point();
		p.setLocation(Double.valueOf(xcord.getText()), Double.valueOf(ycord.getText()));
		LabelEllepticMirror label;
		if(Double.valueOf(a.getText())>0&&Double.valueOf(b.getText())>0)
		{
			label=new LabelEllepticMirror(p, Math.PI*Double.valueOf(angle.getText())/180, Double.valueOf(a.getText()), Double.valueOf(b.getText()));
			label.addMouseControl();
			frame.mainPaneladd(label);
			label.addPopup();
			label.updateUI();
		}
	}
}
