package gui;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class LogInWindow extends JFrame{
		
	
	JPanel jp = new JPanel();
	JButton jb = new JButton("Log in");
	public LogInWindow(){
		
		
		super("Log In");
		setSize(400,200);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		JTextField username = new JTextField(20);
		JTextField pass = new JTextField(20);
		
		JLabel tekst1 = new JLabel("Unesite korisnicko ime:");
		JLabel tekst2 = new JLabel("Unesite sifru: ");
		tekst2.setHorizontalAlignment(0);
		
		jp.add(tekst1);
		jp.add(username);
		
		jp.add(tekst2);
		jp.add(pass);
		
		jp.add(jb,BorderLayout.SOUTH);
		
		add(jp);
		
		
	}

}
