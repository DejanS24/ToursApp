package model.data;

public abstract class Osoba extends Korisnik{

	public enum Pol {Zenski, Muski}
	
	protected String prezime;
	protected String ime;
	protected Pol pol;
	protected String kontakt;
	
	public String getKontakt() {
		return kontakt;
	}

	public void setKontakt(String kontakt) {
		this.kontakt = kontakt;
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

	public Osoba(String korisnickoIme, String lozinka, String prezime, String ime, Pol pol, String kontakt) {
		super(korisnickoIme, lozinka);
		this.prezime = prezime;
		this.ime = ime;
		this.pol = pol;
		this.kontakt = kontakt;
	}

	@Override
	public String toString() {
		return korisnickoIme + "|" + lozinka + "|" + ime + "|" + prezime + "|" + pol + "|" +
	kontakt;
	}
	
	
}
