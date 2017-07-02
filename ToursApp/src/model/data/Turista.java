package model.data;
import model.collections.Ture;
public class Turista extends Osoba{
	
	Ture t = new Ture();

	public Turista(String korisnickoIme, String lozinka, String prezime, String ime, Pol pol) {
		super(korisnickoIme, lozinka,prezime, ime, pol);
	}
	
	
	public void ListTours(){
		for (int i = 0; i < t.getTure().size(); i++) {
			
		}
	}
	
	
	public void ReserveTour(){
		
	}
	
	public void CancelTour(){
		
	}
	
	
	

}
