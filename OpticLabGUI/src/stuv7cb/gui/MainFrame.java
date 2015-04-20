package stuv7cb.gui;

import java.awt.*;

import javax.swing.*;

public class MainFrame extends JFrame
{
	private Toolkit kit = Toolkit.getDefaultToolkit();
	private Dimension screenSize=kit.getScreenSize();
	final int WIDTH=screenSize.width/2;
	final int HEIGHT=screenSize.height/2;
	private final String TITLE="GUI";
	private MainPanel mainPanel =new MainPanel();
	public MainFrame()
	{
		setSize(WIDTH, HEIGHT);
		setTitle(TITLE);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		panel.setSize(3*WIDTH/4, HEIGHT/8);
		ButtonRun br=new ButtonRun("Начать");
		panel.add(br);
		setLayout(null);
		panel.setLocation(WIDTH/4, 7*HEIGHT/8);
		panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		add(panel);
		br.addClient();
		mainPanel.setLayout(null);
		mainPanel.setSize(3*WIDTH/4, 7*HEIGHT/8);
		mainPanel.setLocation(WIDTH/4, 0);
		add(mainPanel);
		//addScrollBar();//Пока не работает
		addPanelOfSelection();
	}
	void addPanelOfSelection()
	{
		JPanel panelSelection = new JPanel();
		final SelectionLabel[] selectionLabel = new SelectionLabel[3];
		panelSelection.setLayout(null);
		SelectionLabel.parent=this;
		for(int i=0;i<3;i++)
		{
			selectionLabel[i]=new SelectionLabel(i);
			selectionLabel[i].addMouseListener(selectionLabel[i].new MyMouseListener());
			selectionLabel[i].setLocation(0, i*20);
			panelSelection.add(selectionLabel[i]);
		}
		panelSelection.setSize(WIDTH/4, HEIGHT);
		panelSelection.setLocation(0, 0);
		panelSelection.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		add(panelSelection);
	}
	void mainPaneladd(JComponent comp)
	{
		mainPanel.add(comp);
	}
	/*void addScrollBar()
	{
		JScrollPane scroll = new JScrollPane(mainPanel);
		scroll.setSize(mainPanel.getSize().width, 30);
		scroll.setLocation(0, getSize().height-30);
		getContentPane().add(scroll);
	}*/
	Component[] getComponentsofMainPanel()
	{
		return mainPanel.getComponents();
	}
}