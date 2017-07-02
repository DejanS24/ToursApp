package gui;

import javax.swing.JFrame;

public abstract class Window extends JFrame{
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
