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
	protected JTextField x2=new JTextField("x2");
	protected JTextField y2=new JTextField("y2");
	protected JTextField x3=new JTextField("x3");
	protected JTextField y3=new JTextField("y3");
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
		add(x2);
		add(y2);
		add(x3);
		add(y3);
		add(n);
	}

	void addObject()
	{
		Point A=new Point();
		Point B=new Point();
		Point C=new Point();
		A.setLocation(Double.valueOf(xcord.getText()),Double.valueOf(ycord.getText()));
		B.setLocation(Double.valueOf(x2.getText()),Double.valueOf(y2.getText()));
		C.setLocation(Double.valueOf(x3.getText()),Double.valueOf(y3.getText()));
		LabelPrism label=new LabelPrism(A, B, C, Double.valueOf(n.getText()));
		label.addMouseControl();
		frame.mainPaneladd(label);
		label.addPopup();
		label.updateUI();
	}

}
