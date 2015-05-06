package stuv7cb.gui;

import java.awt.GridLayout;
import java.awt.Point;

import javax.swing.JTextField;

class SetSphereMirror extends SetPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4498204250685127087L;
	protected JTextField r=new JTextField("Радиус");
	protected JTextField angle=new JTextField("Угол начала");
	protected JTextField endAngle=new JTextField("Угол конца");
	SetSphereMirror(MainFrame f)
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
		add(endAngle);
		add(r);
		
	}

	@Override
	void addObject() 
	{
		Point p=new Point();
		p.setLocation(Double.valueOf(xcord.getText()), Double.valueOf(ycord.getText()));
		LabelSphereMirror label=new LabelSphereMirror(p, Math.PI*Double.valueOf(angle.getText())/180, Math.PI*Double.valueOf(endAngle.getText())/180, Double.valueOf(r.getText()));
		label.addMouseControl();
		frame.mainPaneladd(label);
		label.addPopup();
		label.updateUI();
	}

}
