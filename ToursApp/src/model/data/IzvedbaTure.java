package model.data;

import java.util.ArrayList;
import java.util.Date;

public class IzvedbaTure extends Tura{

	Date pocetak;
	Date kraj;
	int cena;
	ArrayList<Lokacija> lokIzvedbe;
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
	public ArrayList<Lokacija> getLokIzvedbe() {
		return lokIzvedbe;
	}
	public void setLokIzvedbe(ArrayList<Lokacija> lokIzvedbe) {
		this.lokIzvedbe = lokIzvedbe;
	}
	@Override
	public String toString() {
		return pocetak + "|" + kraj + "|" + cena + "|" + lokIzvedbe;
	}
	public IzvedbaTure(Date pocetak, Date kraj, int cena, ArrayList<Lokacija> lokIzvedbe) {
		super();
		this.pocetak = pocetak;
		this.kraj = kraj;
		this.cena = cena;
		this.lokIzvedbe = lokIzvedbe;
	}
	public IzvedbaTure() {
		super();
	}
	
	
	
	
}
