package stuv7cb.gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class MainFrame extends JFrame
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7814866059557571520L;
	private Toolkit kit = Toolkit.getDefaultToolkit();
	private Dimension screenSize=kit.getScreenSize();
	final int WIDTH=screenSize.width/2;
	final int HEIGHT=screenSize.height/2;
	private final String TITLE="Оптическая лаборатория";
	private MainPanel mainPanel =new MainPanel();
	private SpringLayout springLayout;
	private JPanel panel;
	public MainFrame()
	{
		setMinimumSize(new Dimension(349, 278));
		setSize(WIDTH, HEIGHT);
		setTitle(TITLE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		springLayout = new SpringLayout();
		springLayout.putConstraint(SpringLayout.NORTH, mainPanel, 0, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, mainPanel, 0, SpringLayout.EAST, getContentPane());
		getContentPane().setLayout(springLayout);
		panel = new JPanel();
		springLayout.putConstraint(SpringLayout.WEST, mainPanel, 0, SpringLayout.WEST, panel);
		springLayout.putConstraint(SpringLayout.SOUTH, mainPanel, 0, SpringLayout.NORTH, panel);
		springLayout.putConstraint(SpringLayout.WEST, panel, 137, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, panel, 0, SpringLayout.EAST, getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, panel, -35, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, panel, 0, SpringLayout.SOUTH, getContentPane());
		ButtonRun br=new ButtonRun("Начать");
		panel.add(br);
		panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		getContentPane().add(panel);
		br.addClient();
		mainPanel.setLayout(null);
		getContentPane().add(mainPanel);
		/*
		LabelLense ll=new LabelLense(new Point(50,100),100,0,0);
		LabelLaser ls=new LabelLaser(new Point(0,100), 0.0);
		LabelDisplay lw=new LabelDisplay(new Point(100,100), 100, 0);
		mainPanel.add(ls);
		mainPanel.add(ll);
		mainPanel.add(lw);
		*/
		//addScrollBar();//Пока не работает
		addMenuBar();
		addPanelOfSelection();
		mainPanel.setOpaque(false);
	}
	private void addPanelOfSelection()
	{
		JPanel panelSelection = new JPanel();
		springLayout.putConstraint(SpringLayout.WEST, panelSelection, 0, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, panelSelection, 0, SpringLayout.WEST, mainPanel);
		springLayout.putConstraint(SpringLayout.NORTH, panelSelection, 0, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, panelSelection, 0, SpringLayout.SOUTH, getContentPane());
		final SelectionLabel[] selectionLabel = new SelectionLabel[8];
		panelSelection.setLayout(null);
		SelectionLabel.parent=this;
		for(int i=0;i<8;i++)
		{
			selectionLabel[i]=new SelectionLabel(i);
			selectionLabel[i].addMouseListener(selectionLabel[i].new MyMouseListener());
			selectionLabel[i].setLocation(0, i*20);
			panelSelection.add(selectionLabel[i]);
		}
		panelSelection.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		getContentPane().add(panelSelection);
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
	void mainPanelPaint(int x0, int y0, int x, int y)
	{
		mainPanel.paintNewLine(x0, y0, x, y);
	}
	private void addMenuBar()
	{
		JMenuBar menuBar=new JMenuBar();
		JMenu file=new JMenu("Файл");
		menuBar.add(file);
		JMenuItem newOne=new JMenuItem("Новый");
		newOne.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_MASK));
		newOne.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				Component[] component=getComponentsofMainPanel();
				for(int i=0; i<component.length; i++)
				{
					mainPanel.remove(component[i]);
				}
				mainPanel.updateUI();
			}
			
		});
		file.add(newOne);
		JMenuItem open=new JMenuItem("Открыть");
		open.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				Component[] component=getComponentsofMainPanel();
				for(int i=0; i<component.length; i++)
				{
					mainPanel.remove(component[i]);
				}
				mainPanel.updateUI();
				JFileChooser fileChooser=new JFileChooser();
				FileNameExtensionFilter fef=new FileNameExtensionFilter("Save file", "svo");
				fileChooser.setFileFilter(fef);
				int ret=fileChooser.showOpenDialog(mainPanel);
				if(ret==JFileChooser.CANCEL_OPTION||ret==JFileChooser.ERROR_OPTION)
				{
					System.out.println("File wasn't open");
				}
				else
				{
					File file=fileChooser.getSelectedFile();
					try
					{
						Scanner scanner=new Scanner(file);
						while(scanner.hasNextLine())
						{
							String line=scanner.nextLine();
							Scanner lineScanner=new Scanner(line);
							lineScanner.useLocale(Locale.US);
							int ID=lineScanner.nextInt();
							ArrayList<Double> params = new ArrayList<Double>();
							while(lineScanner.hasNext())
							{
								if(lineScanner.hasNextDouble())
								{
									params.add(lineScanner.nextDouble());
								}
								else
								{
									System.out.println(lineScanner.next());
								}
							}
							int i=0;
							switch(ID)
							{
							case 2:
							{
								Point p=new Point();
								p.setLocation(params.get(i++), params.get(i++));
								LabelLense label=new LabelLense(p, params.get(i++), params.get(i++), params.get(i++));
								label.addMouseControl();
								mainPaneladd(label);
								label.addPopup();
								label.updateUI();
								break;
							}
							case 0:
							{
								Point p=new Point();
								p.setLocation(params.get(i++),params.get(i++));
								LabelSource label=new LabelSource(p);
								label.addMouseControl();
								mainPaneladd(label);
								label.addPopup();
								label.updateUI();
								break;
							}
							case 1:
							{
								Point p=new Point();
								p.setLocation(params.get(i++),params.get(i++));
								LabelDisplay label=new LabelDisplay(p,params.get(i++),params.get(i++));
								label.addMouseControl();
								mainPaneladd(label);
								label.addPopup();
								label.updateUI();
								break;
							}
							case 3:
							{
								Point p=new Point();
								p.setLocation(params.get(i++),params.get(i++));
								LabelMirror label=new LabelMirror(p, params.get(i++),params.get(i++));
								label.addMouseControl();
								mainPaneladd(label);
								label.addPopup();
								label.updateUI();
								break;
							}
							case 4:
							{
								Point p=new Point();
								p.setLocation(params.get(i++),params.get(i++));
								LabelPlate label=new LabelPlate(p, params.get(i++),params.get(i++),params.get(i++),params.get(i++));
								label.addMouseControl();
								mainPaneladd(label);
								label.addPopup();
								label.updateUI();
								break;
							}
							case 5:
							{
								Point p=new Point();
								p.setLocation(params.get(i++),params.get(i++));
								LabelLaser label=new LabelLaser(p, params.get(i++));
								label.addMouseControl();
								mainPaneladd(label);
								label.addPopup();
								label.updateUI();
								break;
							}
							case 6:
							{
								Point p=new Point();
								p.setLocation(params.get(i++),params.get(i++));
								LabelPrism label=new LabelPrism(p, params.get(i++),params.get(i++),params.get(i++),params.get(i++),params.get(i++),params.get(i++),params.get(i++));
								label.addMouseControl();
								mainPaneladd(label);
								label.addPopup();
								label.updateUI();
								break;
							}
							case 7:
							{
								Point p=new Point();
								p.setLocation(params.get(i++),params.get(i++));
								LabelSphereMirror label=new LabelSphereMirror(p, params.get(i++),params.get(i++),params.get(i++));
								label.addMouseControl();
								mainPaneladd(label);
								label.addPopup();
								label.updateUI();
							}
							}
							lineScanner.close();
						}
						scanner.close();
					}
					catch (FileNotFoundException fnfe)
					{
						System.err.println("Couldn't find file!");
					}
				}
			}			
		});
		open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, KeyEvent.CTRL_MASK));
		file.add(open);
		JMenuItem save=new JMenuItem("Сохранить");
		save.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				JFileChooser fileChooser=new JFileChooser();
				fileChooser.setSelectedFile(new File("save.svo"));
				fileChooser.showSaveDialog(mainPanel);
				File file=fileChooser.getSelectedFile();
				if(!file.getAbsolutePath().endsWith(".svo") )
				{
	                file = new File(file.getAbsolutePath() + ".svo");
				}
				try
				{
					PrintWriter out=new PrintWriter(file.getAbsoluteFile());
					Component[] component=getComponentsofMainPanel();
					for(int i=0; i<component.length; i++)
					{
						out.println(((LabelObject)component[i]).getID()+" "+((LabelObject)component[i]).getParams());
					}
					out.close();
				}
				catch (FileNotFoundException fnfe)
				{
					System.err.println("Couldn't find file!");
				}
			}
			
		});
		save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_MASK));
		file.add(save);
		file.addSeparator();
		JMenuItem exit=new JMenuItem("Выход");
		MainFrame mf=this;
		exit.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				mf.dispose();
			}
			
		});
		file.add(exit);
		setJMenuBar(menuBar);
	}
}
