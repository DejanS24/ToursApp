package model.data;

import model.state.StanjeVodica;

public class Vodic extends Turista{

	StanjeVodica stanje;
	boolean aktivan;
	
	public Vodic(String korisnickoIme, String lozinka, String prezime, String ime, Pol pol, String kontakt, boolean aktivan) {
		super(korisnickoIme, lozinka, prezime, ime, pol, kontakt);
		this.aktivan = aktivan;
	}
	
	
}
