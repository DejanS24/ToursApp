package model.data;

import java.text.SimpleDateFormat;
import java.util.Date;

import model.collections.Korisnici;
import model.collections.LokacijeIzvedbe;

public class IzvedbaTure extends Tura{

	Date pocetak;
	Date kraj;
	int cena;
	LokacijeIzvedbe lokIzvedbe;
	int minTurista;
	int maxTurista;
	Korisnici turisti;
	
	public Date getPocetak() {
		return pocetak;
	}
	public void setPocetak(Date pocetak) {
		this.pocetak = pocetak;
	}
	public Date getKraj() {
		return kraj;
	}
	public void setKraj(Date kraj) {
		this.kraj = kraj;
	}
	public int getCena() {
		return cena;
	}
	public void setCena(int cena) {
		this.cena = cena;
	}
	public LokacijeIzvedbe getLokIzvedbe() {
		return lokIzvedbe;
	}
	public void setLokIzvedbe(LokacijeIzvedbe lokIzvedbe) {
		this.lokIzvedbe = lokIzvedbe;
	}
	
	public IzvedbaTure(Date pocetak, Date kraj, int cena, LokacijeIzvedbe lokIzvedbe) {
		super();
		this.pocetak = pocetak;
		this.kraj = kraj;
		this.cena = cena;
		this.lokIzvedbe = lokIzvedbe;
	}
	
	public IzvedbaTure() {
		super();
	}
	
	public String toString() {
		String p;
		String k;
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
		p = sdf.format(pocetak);
		k = sdf.format(kraj);

		return idTure + "|" + p + "|" + k + "|" + cena + "|" + LocToString();
	}
	
	public String LocToString(){
		String str = "";
		for (int i = 0; i < lokIzvedbe.getLokacijeIzvedbe().size(); i++) {
			str = str + lokIzvedbe.getLokacijeIzvedbe().get(i).getNaziv() + ";";
		}
		str = str.substring(0, str.length() - 1);
		return str;
	}
	
	
}
