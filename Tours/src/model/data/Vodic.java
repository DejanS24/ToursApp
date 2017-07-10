package model.data;

public class Vodic extends Turista{

	boolean aktivan;
	
	public Vodic(String korisnickoIme, String lozinka, String prezime, String ime, Pol pol, String kontakt, boolean aktivan) {
		super(korisnickoIme, lozinka, prezime, ime, pol, kontakt);
		this.aktivan = aktivan;
	}

	@Override
	public String toString() {
		return korisnickoIme + "|" + lozinka + "|" + ime + "|" + prezime + "|" + pol + "|" +
				kontakt + "|" + String.valueOf(aktivan);
	}

	
	
}
