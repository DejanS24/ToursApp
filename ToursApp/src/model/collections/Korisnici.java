package model.collections;

import java.util.ArrayList;

import model.data.Korisnik;

public class Korisnici extends Kolekcija{

	ArrayList<Korisnik> korisnici;

	public ArrayList<Korisnik> getKorisnici() {
		return korisnici;
	}

	public void setKorisnici(ArrayList<Korisnik> korisnici) {
		this.korisnici = korisnici;
	}

	public Korisnici(ArrayList<Korisnik> korisnici) {
		super();
		this.korisnici = korisnici;
	}

	public Korisnici() {
		super();
	}	
	
	
	
}
