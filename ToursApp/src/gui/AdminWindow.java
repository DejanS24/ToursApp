package gui;

import model.data.Korisnik;

@SuppressWarnings("serial")
public class AdminWindow extends Window{

	Korisnik admin;
	
	public AdminWindow(Korisnik korisnik){
		super(600,500);
		admin = korisnik;
		setTitle("ToursApp - " + admin.getKorisnickoIme());
	}
}
