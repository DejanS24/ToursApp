package gui;

import model.data.Korisnik;

@SuppressWarnings("serial")
public class TuristaWindow extends Window{

	Korisnik turista;
	
	public TuristaWindow(Korisnik korisnik){
		super(600,500);
		turista = korisnik;
		setTitle("ToursApp - " + turista.getKorisnickoIme());
	}
}
