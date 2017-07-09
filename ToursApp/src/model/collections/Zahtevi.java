package model.collections;

import java.util.ArrayList;

public class Zahtevi {
	ArrayList<String> zahteviKorisnika;

	public Zahtevi(ArrayList<String> zahteviKorisnika) {
		super();
		this.zahteviKorisnika = zahteviKorisnika;
	}

	public Zahtevi() {
		super();
	}

	public ArrayList<String> getZahteviKorisnika() {
		return zahteviKorisnika;
	}

	public void setZahteviKorisnika(ArrayList<String> zahteviKorisnika) {
		this.zahteviKorisnika = zahteviKorisnika;
	}
	
}
