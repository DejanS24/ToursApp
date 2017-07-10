package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.event.ListSelectionListener;

@SuppressWarnings("serial")
public abstract class Window extends JFrame{
	
	protected JFrame parent;
	protected JTable table;
	protected String[] columns;
	protected ListSelectionListener tableSelectionListener;
	protected JPanel panDetail;
	
	public Window(){		
		super();
		setSize(400,200);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public Window(int w,int h){
		super();
		setSize(w,h);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
}
