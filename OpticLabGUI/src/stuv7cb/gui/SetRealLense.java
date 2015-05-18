package stuv7cb.gui;

import java.awt.GridLayout;
import java.awt.Point;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
		setLayout(new GridLayout(16,1));
		add(new JLabel("Толстая линза"));
		add(new JLabel("Координаты"));
		add(xcord);
		add(ycord);
		add(new JLabel("Радиус одной поверхности"));
		add(R1);
		add(new JLabel("Радиус второй поверхности"));
		add(R2);
		add(new JLabel("Угол"));
		add(angle);
		add(new JLabel("Показатель преломления"));
		add(n);
		add(new JLabel("Длина"));
		add(length);
		add(new JLabel("Толщина"));
		add(d);
	}
	void addObject() 
	{
		Point p=new Point();
		p.setLocation(Double.valueOf(xcord.getText()), Double.valueOf(ycord.getText()));
		double r1=Double.valueOf(R1.getText());
		double r2=Double.valueOf(R2.getText());
		double l=Double.valueOf(length.getText());
		if(Math.abs(r1)>0.5*l&&Math.abs(r2)>0.5*l)
		{
			LabelRealLense label=new LabelRealLense(p, r1, r2, Math.PI*Double.valueOf(angle.getText())/180, Double.valueOf(n.getText()), l, Double.valueOf(d.getText()));
			label.addMouseControl();
			frame.mainPaneladd(label);
			label.addPopup();
			label.updateUI();
		}
		else
		{
			System.err.println("This isn't lense!");
			JOptionPane.showMessageDialog(frame, "Ihis isn't lense!");
		}
	}
}
