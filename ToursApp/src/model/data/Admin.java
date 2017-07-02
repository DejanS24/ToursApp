package model.data;

public class Admin extends Korisnik{

	public Admin() {
		super();
	}

	public Admin(String korisnickoIme, String lozinka) {
		super(korisnickoIme, lozinka);
	}

	@Override
	public String toString() {
		return korisnickoIme + "|" + lozinka;
	}
	
	
	
}
