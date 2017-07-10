package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.LineBorder;

import model.data.Admin;
import model.data.Korisnik;

@SuppressWarnings("serial")
public class AdminWindow extends Window{

	JPanel content = new JPanel();
	
	Korisnik admin;
	ArrayList<String> korisnici;
	
	Korisnik trenutni;
	
	public AdminWindow(Admin korisnik){
		//ArrayList<String> kor = korisnik.getListaZahteva();
		super(600,100+korisnik.getListaZahteva().size()*100);
		admin = korisnik;
		korisnici = korisnik.getListaZahteva();
		setTitle("ToursApp - " + admin.getKorisnickoIme());
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(193, 216, 230));
		panel.setPreferredSize(new Dimension(550, korisnici.size()*100));
		
		JPanel optionsPan = new JPanel();
		optionsPan.setBackground(new Color(193, 216, 230));

		//JButton btnMojProfil = new JButton("MOJ PROFIL");
		//optionsPan.add(btnMojProfil);
		
		JButton btnOdlogujSe = new JButton("Odloguj se");
		optionsPan.add(btnOdlogujSe);
		
		for(int i=0 ; i<korisnici.size() ; i++){
		    
			String tk = korisnici.get(i);
			//trenutni = korisnici.getKorisnici().get(i);
			
		    JPanel turaPanel = new JPanel();
		    turaPanel.setBackground(new Color(60, 179, 113));
		    turaPanel.setBorder(new LineBorder(new Color(64, 224, 208), 4));
		    turaPanel.setPreferredSize(new Dimension(450, 90));
			turaPanel.setLayout(new BorderLayout(0, 0));
		    
			JButton openTura = new JButton("Prihvati Zahtev");
			openTura.putClientProperty("id", tk);
		    openTura.setPreferredSize(new Dimension(100,20));
		    turaPanel.add(openTura, BorderLayout.EAST);
		    openTura.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {
					MyApp.prihvatiVodica(tk, korisnik);
					openTura.setEnabled(false);
				}
			});
			
		    JTextField titleTure = new JTextField();
			titleTure.setText(tk); //trenutni.getKorisnickoIme()
			titleTure.setEditable(false);
			turaPanel.add(titleTure, BorderLayout.NORTH);
			titleTure.setColumns(10);
			
			JTextPane txtpnOvdeIdeOpis = new JTextPane();
			txtpnOvdeIdeOpis.setText(tk); //trenutni.getKorisnickoIme()
			txtpnOvdeIdeOpis.setEditable(false);
			txtpnOvdeIdeOpis.setBackground(new Color(175, 206, 200));
			turaPanel.add(txtpnOvdeIdeOpis, BorderLayout.CENTER);
			
			panel.add(turaPanel);
			
		}

		JScrollPane scrollPane = new JScrollPane(panel,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT,
				scrollPane,
				optionsPan);
		scrollPane.setPreferredSize(new Dimension(600, korisnici.size()*100));
		splitPane.setBackground(new Color(176, 196, 222));
		splitPane.setResizeWeight(1.0);
		panel.revalidate();
		content.add(splitPane,BorderLayout.CENTER);
		
		
		add(content);
		
	}
}
