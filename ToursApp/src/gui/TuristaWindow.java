package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.LineBorder;

import model.collections.Ture;
import model.data.Korisnik;
import model.data.Tura;

@SuppressWarnings("serial")
public class TuristaWindow extends Window{

	JPanel content = new JPanel();
	
	Korisnik turista;
	Ture ture;
	Tura trenutna;
	
	public TuristaWindow(Korisnik korisnik, Ture t) throws IOException{
		super(620,545);
		turista = korisnik;
		ture = t;
		setTitle("ToursApp - " + turista.getKorisnickoIme());
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(193, 216, 230));
		panel.setPreferredSize(new Dimension(550, ture.getTure().size()*100));
		
		JPanel optionsPan = new JPanel();
		optionsPan.setBackground(new Color(193, 216, 230));
		optionsPan.setLayout(new BorderLayout(0, 0));


		JButton btnMojProfil = new JButton("MOJ PROFIL");
		optionsPan.add(btnMojProfil, BorderLayout.WEST);
		
		JButton btnPosaljiZahtev = new JButton("Posalji zahtev za vodica");
		optionsPan.add(btnPosaljiZahtev, BorderLayout.CENTER);
		
		JButton btnOdlogujSe = new JButton("Odloguj se");
		optionsPan.add(btnOdlogujSe, BorderLayout.EAST);

		
		for(int i=0 ; i<ture.getTure().size() ; i++){
		    
			trenutna = ture.getTure().get(i);
			
		    JPanel turaPanel = new JPanel();
		    turaPanel.setBackground(new Color(60, 179, 113));
		    turaPanel.setBorder(new LineBorder(new Color(64, 224, 208), 4));
		    turaPanel.setPreferredSize(new Dimension(450, 90));
			turaPanel.setLayout(new BorderLayout(0, 0));
		    
			JButton openTura = new JButton("Otvori turu");
			openTura.putClientProperty("id", trenutna.getIdTure());
		    openTura.setPreferredSize(new Dimension(100,20));
		    turaPanel.add(openTura, BorderLayout.EAST);
		    openTura.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {
					JButton source = (JButton) e.getSource();
					String idTure = (String) source.getClientProperty("id");
					System.out.println(idTure);
					IzvedbeTuraDialog izvedbeDialog = new IzvedbeTuraDialog(turista, ture,idTure);
					izvedbeDialog.setVisible(true);
				}
			});
			
		    JTextField titleTure = new JTextField();
			titleTure.setText(trenutna.getGrad().getGrad());
			titleTure.setEditable(false);
			turaPanel.add(titleTure, BorderLayout.NORTH);
			titleTure.setColumns(10);
			
			BufferedImage myPicture = ImageIO.read(new File(ture.getTure().get(i).getSlika()));
			myPicture = resize(myPicture,90,90);
			JLabel picLabel = new JLabel(new ImageIcon(myPicture));
			turaPanel.add(picLabel,BorderLayout.WEST);
			
			JTextPane txtpnOvdeIdeOpis = new JTextPane();
			txtpnOvdeIdeOpis.setText(ture.getTure().get(i).getGrad().getOpis());
			txtpnOvdeIdeOpis.setEditable(false);
			txtpnOvdeIdeOpis.setBackground(new Color(175, 206, 200));
			turaPanel.add(txtpnOvdeIdeOpis, BorderLayout.CENTER);
			
			panel.add(turaPanel);
			
		}

		JScrollPane scrollPane = new JScrollPane(panel,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT,
				scrollPane,
				optionsPan);
		scrollPane.setPreferredSize(new Dimension(600, 450));
		splitPane.setBackground(new Color(176, 196, 222));
		splitPane.setResizeWeight(1.0);
		panel.revalidate();
		content.add(splitPane,BorderLayout.CENTER);
		
		
		add(content);
				
	}
	
	public static BufferedImage resize(BufferedImage img, int newW, int newH) { 
	    Image tmp = img.getScaledInstance(newW, newH, Image.SCALE_SMOOTH);
	    BufferedImage dimg = new BufferedImage(newW, newH, BufferedImage.TYPE_INT_ARGB);

	    Graphics2D g2d = dimg.createGraphics();
	    g2d.drawImage(tmp, 0, 0, null);
	    g2d.dispose();

	    return dimg;
	}  
}
