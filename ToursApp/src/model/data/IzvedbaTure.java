package model.data;

import java.text.SimpleDateFormat;
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
		for (int i = 0; i < lokIzvedbe.size(); i++) {
			str = str + lokIzvedbe.get(i).getNaziv() + ";";
		}
		str = str.substring(0, str.length() - 1);
		return str;
	}
	
	
}
