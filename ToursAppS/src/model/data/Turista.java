package model.data;
import model.collections.Ture;
public class Turista extends Osoba{
	
	Ture t = new Ture();

	public Turista(String korisnickoIme, String lozinka, String prezime, String ime, Pol pol, String kontakt) {
		super(korisnickoIme, lozinka,prezime, ime, pol, kontakt);
	}
	
	
	

}