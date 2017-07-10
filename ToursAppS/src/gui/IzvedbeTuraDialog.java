package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
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
import model.data.Vodic;

@SuppressWarnings("serial")
public class IzvedbeTuraDialog extends JDialog{
	

	JPanel content = new JPanel();
	
	Korisnik turista;
	Ture ture;
	Tura trenutna;
	
	public IzvedbeTuraDialog(Korisnik korisnik, Ture t, String idTure){
		super();
		turista = korisnik;
		ture = t;
		
		for (int j = 0; j < ture.getTure().size(); j++){
			if (idTure.equalsIgnoreCase(ture.getTure().get(j).getIdTure())){
				trenutna = ture.getTure().get(j);
				break;
			}
		}
		int visina = trenutna.getListaIzvedbi().getIzvedbeTure().size();
		if (visina > 7){
			setSize(new Dimension(600,800));
		}else{
			setSize(new Dimension(600,100+trenutna.getListaIzvedbi().getIzvedbeTure().size()*100));
		}

		setTitle("Tura: " + trenutna.getGrad());
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(173, 216, 230));
		panel.setPreferredSize(new Dimension(550, trenutna.getListaIzvedbi().getIzvedbeTure().size()*100));
		
		JPanel optionsPan = new JPanel();
		optionsPan.setBackground(new Color(173, 216, 230));
		
		JButton btnNewButton_3 = new JButton("Zatvori");
		btnNewButton_3.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				dispose();
			}
		});
		optionsPan.add(btnNewButton_3, BorderLayout.WEST);
		
		if (korisnik instanceof Vodic)
		{
		JButton brnKreirajIzv = new JButton("Kreiraj izvedbu");
		optionsPan.add(brnKreirajIzv);	//TODO 
		}
		
		    
		for (int i = 0; i<trenutna.getListaIzvedbi().getIzvedbeTure().size(); i++){
			JPanel izvedbaPanel = new JPanel();
		    izvedbaPanel.setBackground(new Color(211, 211, 211));
		    izvedbaPanel.setBorder(new LineBorder(new Color(64, 224, 208), 4));
		    izvedbaPanel.setPreferredSize(new Dimension(450, 90));
			izvedbaPanel.setLayout(new BorderLayout(0, 0));
		    
			if (moguceRezervisati()){
				JButton rezervisiIzvedbu = new JButton("Rezervisi izvedbu");
			    rezervisiIzvedbu.setPreferredSize(new Dimension(100,20));
			    izvedbaPanel.add(rezervisiIzvedbu, BorderLayout.EAST);
			    rezervisiIzvedbu.addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
			}else{
				JLabel nemoguceRez = new JLabel("Nije moguce rezervisati");
				nemoguceRez.setForeground(new Color(255, 0, 0));
				izvedbaPanel.add(nemoguceRez, BorderLayout.EAST);
			}
			
		    JTextField titleTure = new JTextField();
			titleTure.setText(trenutna.getListaIzvedbi().getIzvedbeTure().get(i).getLokIzvedbe().toString());
			izvedbaPanel.add(titleTure, BorderLayout.NORTH);
			titleTure.setColumns(10);
			
			
			JTextPane txtpnOvdeIdeOpis = new JTextPane();
			txtpnOvdeIdeOpis.setText(trenutna.getListaIzvedbi().getIzvedbeTure().get(i).getVodic());
			izvedbaPanel.add(txtpnOvdeIdeOpis, BorderLayout.CENTER);
			
			panel.add(izvedbaPanel);
		}

		JScrollPane scrollPane = new JScrollPane(panel,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT,
				scrollPane,
				optionsPan);
		scrollPane.setPreferredSize(new Dimension(580, visina*100));
		splitPane.setBackground(new Color(176, 196, 222));
		splitPane.setResizeWeight(1.0);
		panel.revalidate();
		content.add(splitPane,BorderLayout.CENTER);
		
		
		add(content);
	}
	
	public static boolean moguceRezervisati(){
		return false;
	}

}
