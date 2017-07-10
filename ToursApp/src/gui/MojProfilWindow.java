package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.data.Turista;

@SuppressWarnings("serial")
public class MojProfilWindow extends JDialog {

	private final JPanel contentPanel = new JPanel();

	public MojProfilWindow(Turista t) {
		setBounds(100, 100, 450, 460);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblKorisnickoIme = new JLabel("Korisnicko ime: ");
			GridBagConstraints gbc_lblKorisnickoIme = new GridBagConstraints();
			gbc_lblKorisnickoIme.insets = new Insets(0, 0, 5, 5);
			gbc_lblKorisnickoIme.gridx = 1;
			gbc_lblKorisnickoIme.gridy = 2;
			contentPanel.add(lblKorisnickoIme, gbc_lblKorisnickoIme);
		}
		{
			JLabel labelKime = new JLabel(t.getKorisnickoIme());
			GridBagConstraints gbc_labelKime = new GridBagConstraints();
			gbc_labelKime.insets = new Insets(0, 0, 5, 5);
			gbc_labelKime.gridx = 4;
			gbc_labelKime.gridy = 2;
			contentPanel.add(labelKime, gbc_labelKime);
		}
		{
			JLabel lblLozinka = new JLabel("Lozinka: ");
			GridBagConstraints gbc_lblLozinka = new GridBagConstraints();
			gbc_lblLozinka.insets = new Insets(0, 0, 5, 5);
			gbc_lblLozinka.gridx = 1;
			gbc_lblLozinka.gridy = 4;
			contentPanel.add(lblLozinka, gbc_lblLozinka);
		}
		{
			JLabel labelaLozinka = new JLabel(t.getLozinka());
			GridBagConstraints gbc_labelaLozinka = new GridBagConstraints();
			gbc_labelaLozinka.insets = new Insets(0, 0, 5, 5);
			gbc_labelaLozinka.gridx = 4;
			gbc_labelaLozinka.gridy = 4;
			contentPanel.add(labelaLozinka, gbc_labelaLozinka);
		}
		{
			JLabel lblIme = new JLabel("Ime: ");
			GridBagConstraints gbc_lblIme = new GridBagConstraints();
			gbc_lblIme.insets = new Insets(0, 0, 5, 5);
			gbc_lblIme.gridx = 1;
			gbc_lblIme.gridy = 6;
			contentPanel.add(lblIme, gbc_lblIme);
		}
		{
			JLabel labelaIme = new JLabel(t.getIme());
			GridBagConstraints gbc_labelaIme = new GridBagConstraints();
			gbc_labelaIme.insets = new Insets(0, 0, 5, 5);
			gbc_labelaIme.gridx = 4;
			gbc_labelaIme.gridy = 6;
			contentPanel.add(labelaIme, gbc_labelaIme);
		}
		{
			JLabel lblPrezime = new JLabel("Prezime: ");
			GridBagConstraints gbc_lblPrezime = new GridBagConstraints();
			gbc_lblPrezime.insets = new Insets(0, 0, 5, 5);
			gbc_lblPrezime.gridx = 1;
			gbc_lblPrezime.gridy = 8;
			contentPanel.add(lblPrezime, gbc_lblPrezime);
		}
		{
			JLabel labelaPrezime = new JLabel(t.getPrezime());
			GridBagConstraints gbc_labelaPrezime = new GridBagConstraints();
			gbc_labelaPrezime.insets = new Insets(0, 0, 5, 5);
			gbc_labelaPrezime.gridx = 4;
			gbc_labelaPrezime.gridy = 8;
			contentPanel.add(labelaPrezime, gbc_labelaPrezime);
		}
		{
			JLabel lblPol = new JLabel("Pol: ");
			GridBagConstraints gbc_lblPol = new GridBagConstraints();
			gbc_lblPol.insets = new Insets(0, 0, 5, 5);
			gbc_lblPol.gridx = 1;
			gbc_lblPol.gridy = 10;
			contentPanel.add(lblPol, gbc_lblPol);
		}
		{
			JLabel labelaPol = new JLabel(t.getPol().toString());
			GridBagConstraints gbc_labelaPol = new GridBagConstraints();
			gbc_labelaPol.insets = new Insets(0, 0, 5, 5);
			gbc_labelaPol.gridx = 4;
			gbc_labelaPol.gridy = 10;
			contentPanel.add(labelaPol, gbc_labelaPol);
		}
		{
			JLabel lblKontakt = new JLabel("Kontakt telefon: ");
			GridBagConstraints gbc_lblKontakt = new GridBagConstraints();
			gbc_lblKontakt.insets = new Insets(0, 0, 5, 5);
			gbc_lblKontakt.gridx = 1;
			gbc_lblKontakt.gridy = 12;
			contentPanel.add(lblKontakt, gbc_lblKontakt);
		}
		{
			JLabel labelaKontakt = new JLabel(t.getKontakt());
			GridBagConstraints gbc_labelaKontakt = new GridBagConstraints();
			gbc_labelaKontakt.insets = new Insets(0, 0, 5, 5);
			gbc_labelaKontakt.gridx = 4;
			gbc_labelaKontakt.gridy = 12;
			contentPanel.add(labelaKontakt, gbc_labelaKontakt);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}

}
