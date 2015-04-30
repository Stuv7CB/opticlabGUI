package stuv7cb.gui;

import java.awt.GridLayout;
import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

class SetSphereMirror extends SetPanel
{
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
		LabelSphereMirror label=new LabelSphereMirror(p, Double.valueOf(angle.getText()), Double.valueOf(endAngle.getText()), Double.valueOf(r.getText()));
		label.addMouseControl();
		frame.mainPaneladd(label);
		label.addPopup();
		label.updateUI();
	}

}
