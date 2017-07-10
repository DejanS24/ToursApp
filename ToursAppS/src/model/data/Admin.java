package model.data;

import java.util.ArrayList;

public class Admin extends Korisnik{
	private ArrayList<String> listaZahteva;

	public Admin() {
		super();
	}

	public ArrayList<String> getListaZahteva() {
		return listaZahteva;
	}

	public void setListaZahteva(ArrayList<String> listaZahteva) {
		this.listaZahteva = listaZahteva;
	}

	public Admin(String korisnickoIme, String lozinka) {
		super(korisnickoIme, lozinka);
	}

	@Override
	public String toString() {
		return korisnickoIme + "|" + lozinka;
	}
	
	public String zahteviToString(){
		
		String str = "";
		for (int i = 0; i < listaZahteva.size(); i++) {
			str = str + listaZahteva.get(i) + "|";
		}
		if (!(str.length()==0)){
			str = str.substring(0, str.length() - 1);
		}
		
		return str;
	}
	
	
	
	
	
}
