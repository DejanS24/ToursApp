package gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import model.collections.Korisnici;
import model.data.Korisnik;


@SuppressWarnings("serial")
public class LogInWindow extends Window{
		
	JPanel jPanLeft = new JPanel(new GridLayout(2,1));
	JPanel jPanRight = new JPanel(new GridLayout(2,1));
	JPanel jPanBottom = new JPanel();
	JButton jb = new JButton("Prijavi se");
	JButton jbRegistracija=new JButton("Registruj se");
	JTextField username = new JTextField(20);
	JPasswordField pass = new JPasswordField(20);
	
	JLabel tekst1 = new JLabel("Unesite korisnicko ime:");
	JLabel tekst2 = new JLabel("Unesite sifru: ");
	
	Korisnik k;
	
	Korisnici korisnici;
	
	public LogInWindow(){
		
		super(350,120);
		setTitle("Log in");
		
		jPanLeft.add(tekst1);
		jPanRight.add(username);
		
		jPanLeft.add(tekst2);
		jPanRight.add(pass);
		
		jb.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				checkLogIn();
				if (k == null){
					username.setText("");
					pass.setText("");
				}else{
					dispose();
				}
			}
		});
		jPanBottom.add(jb);
		jPanBottom.add(jbRegistracija);
		add(jPanLeft,BorderLayout.WEST);
		add(jPanRight);
		add(jPanBottom,BorderLayout.SOUTH);
		
		
		
	}

	public void checkLogIn(){
		String user = username.getText();
		String password = String.copyValueOf(pass.getPassword());
		
		for (Korisnik kor : korisnici.getKorisnici()){
			if (kor.getKorisnickoIme().equalsIgnoreCase(user) &&
					kor.getLozinka().equalsIgnoreCase(password)){
				k = kor;
			}
		}
	}

	public Korisnik getK() {
		return k;
	}

	public void setK(Korisnik k) {
		this.k = k;
	}

	public Korisnici getKorisnici() {
		return korisnici;
	}

	public void setKorisnici(Korisnici korisnici) {
		this.korisnici = korisnici;
	}
	
}
