package model.data;

public class LokacijaIzvedbe {
	private String naziv;
	private String opis;
	private String cena;
	
	public LokacijaIzvedbe() {
		super();
	}
	public LokacijaIzvedbe(String naziv) {
		super();
		this.naziv = naziv;
	}
	public LokacijaIzvedbe(String naziv, String opis, String cena) {
		super();
		this.naziv = naziv;
		this.opis = opis;
		this.cena = cena;
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public String getOpis() {
		return opis;
	}
	public void setOpis(String opis) {
		this.opis = opis;
	}
	public String getCena() {
		return cena;
	}
	public void setCena(String cena) {
		this.cena = cena;
	}
	
	@Override
	public String toString(){
		return naziv;
	}
}
