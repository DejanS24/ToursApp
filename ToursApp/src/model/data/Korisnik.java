package model.data;

public class Korisnik {

	public enum TipKorisnika {Turista, Vodic, Administrator}
	
	protected String korisnickoIme;
	protected String lozinka;
	

	public Korisnik() {}

	public Korisnik(String korisnickoIme, String lozinka) {
		this.korisnickoIme = korisnickoIme;
		this.lozinka = lozinka;
	}

	public String getKorisnickoIme() {
		return korisnickoIme;
	}

	public void setKorisnickoIme(String korisnickoIme) {
		this.korisnickoIme = korisnickoIme;
	}

	public String getLozinka() {
		return lozinka;
	}

	public void setLozinka(String lozinka) {
		this.lozinka = lozinka;
	}
	

}
