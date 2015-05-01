package stuv7cb.gui;

import java.awt.GridLayout;
import java.awt.Point;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class SetPrism extends SetPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -9218521815993285182L;
	protected JTextField a=new JTextField("a");
	protected JTextField b=new JTextField("b");
	protected JTextField c=new JTextField("c");
	protected JTextField n=new JTextField("Показатель преломления");
	SetPrism(MainFrame f)
	{
		super(f);
	}

	void addFields()
	{
		setLayout(new GridLayout(7,1));
		add(xcord);
		add(ycord);
		add(a);
		add(b);
		add(c);
		add(angle);
		add(n);
	}

	void addObject()
	{
		Point p=new Point();
		p.setLocation(Double.valueOf(xcord.getText()), Double.valueOf(ycord.getText()));
		double A=Double.valueOf(a.getText());
		double B=Double.valueOf(b.getText());
		double C=Double.valueOf(c.getText());
		if(A+B>C&&A+C>=B&&C+B>=A)
		{
			LabelPrism label=new LabelPrism(p, A, B, C, Double.valueOf(angle.getText()),Double.valueOf(n.getText()));
			label.addMouseControl();
			frame.mainPaneladd(label);
			label.addPopup();
			label.updateUI();
		}
		else
		{
			System.err.println("This isn't triangle!");
			JOptionPane.showMessageDialog(frame, "Ihis isn't triangle!");
		}
	}

}
