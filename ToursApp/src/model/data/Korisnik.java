package model.data;

public class Korisnik {

	public enum TipKorisnika {Turista, Vodic, Administrator}
	public enum Pol {Ženski, Muški}

	
	private String korisnickoIme;
	private String lozinka;
	private String prezime;
	private String ime;
	private Pol pol;
	
	public Korisnik() {}

	public Korisnik(String korisnickoIme, String lozinka, String prezime, String ime, Pol pol) {
		super();
		this.korisnickoIme = korisnickoIme;
		this.lozinka = lozinka;
		this.prezime = prezime;
		this.ime = ime;
		this.pol = pol;
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

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public Pol getPol() {
		return pol;
	}

	public void setPol(Pol pol) {
		this.pol = pol;
	}
	
	

}
