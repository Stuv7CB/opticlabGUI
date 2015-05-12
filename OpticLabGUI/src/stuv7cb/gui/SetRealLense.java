package stuv7cb.gui;

import java.awt.GridLayout;
import java.awt.Point;

import javax.swing.JTextField;

class SetRealLense extends SetPanel 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1981505352249759178L;
	SetRealLense(MainFrame f) 
	{
		super(f);
	}
	protected JTextField length=new JTextField("Длина");
	protected JTextField d=new JTextField("Толщина");
	protected JTextField n=new JTextField("Показатель преломления");
	protected JTextField R1=new JTextField("R1");
	protected JTextField R2=new JTextField("R2");
	@Override
	void addFields() 
	{
		setLayout(new GridLayout(8,1));
		add(xcord);
		add(ycord);
		add(R1);
		add(R2);
		add(angle);
		add(n);
		add(length);
		add(d);
	}
	void addObject() 
	{
		Point p=new Point();
		p.setLocation(Double.valueOf(xcord.getText()), Double.valueOf(ycord.getText()));
		LabelRealLense label=new LabelRealLense(p, Double.valueOf(R1.getText()), Double.valueOf(R2.getText()), Math.PI*Double.valueOf(angle.getText())/180, Double.valueOf(n.getText()), Double.valueOf(length.getText()), Double.valueOf(d.getText()));
		label.addMouseControl();
		frame.mainPaneladd(label);
		label.addPopup();
		label.updateUI();
	}
}
