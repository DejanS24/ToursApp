package gui;

import model.data.Korisnik;

@SuppressWarnings("serial")
public class VodicWindow extends Window{

	Korisnik vodic;
	
	public VodicWindow(Korisnik korisnik){
		super(600,500);
		vodic = korisnik;
		setTitle("ToursApp - " + vodic.getKorisnickoIme());
	}
}
