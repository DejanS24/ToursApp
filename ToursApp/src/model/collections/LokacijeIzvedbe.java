package model.collections;

import java.util.ArrayList;

import model.data.LokacijaIzvedbe;

public class LokacijeIzvedbe {
	ArrayList<LokacijaIzvedbe> lokacijeIzvedbe;

	public ArrayList<LokacijaIzvedbe> getLokacijeIzvedbe() {
		return lokacijeIzvedbe;
	}

	public void setLokacijeIzvedbe(ArrayList<LokacijaIzvedbe> lokacijeIzvedbe) {
		this.lokacijeIzvedbe = lokacijeIzvedbe;
	}

	public LokacijeIzvedbe(ArrayList<LokacijaIzvedbe> lokacijeIzvedbe) {
		super();
		this.lokacijeIzvedbe = lokacijeIzvedbe;
	}

	public LokacijeIzvedbe() {
		super();
	}
	
	@Override
	public String toString(){
		String ispis = "";
		for (int i = 0; i < lokacijeIzvedbe.size(); i++){
			ispis += lokacijeIzvedbe.get(i) + ", ";
		}
		return ispis;
	}
}
