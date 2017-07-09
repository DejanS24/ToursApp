package model.data;

import model.state.StanjeVodica;

public class Vodic extends Turista{

	StanjeVodica stanje;
	
	public Vodic(String korisnickoIme, String lozinka, String prezime, String ime, Pol pol) {
		super(korisnickoIme, lozinka, prezime, ime, pol);
	}

	
	
}
