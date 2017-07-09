package util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import model.collections.IzvedbeTure;
import model.collections.LokacijeIzvedbe;
import model.data.Admin;
import model.data.IzvedbaTure;
import model.data.Korisnik;
import model.data.Lokacija;
import model.data.LokacijaIzvedbe;
import model.data.Osoba.Pol;
import model.data.Tura;
import model.data.Turista;
import model.data.Vodic;

public class FilesReader {

	public static ArrayList<Tura> procitajTure() throws IOException, ParseException{
		ArrayList<Tura> ture = new ArrayList<Tura>();
		
		DateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
		
		BufferedReader br = new BufferedReader(new FileReader("ture.txt"));
		try {
		    String line = br.readLine();

		    String turaId = "";
		    int brojac = 0;
	    	Tura t = new Tura();
	    	ArrayList<IzvedbaTure> izvedbe = new ArrayList<IzvedbaTure>();
	    	
	    	while (line != null) {
		    	String[] delovi = line.split("\\|");
		    	
		    	if (brojac == 0){
		    		turaId = delovi[0];
		    		String id = delovi[0];
		    		String grad = delovi[1];
		    		String vodic = delovi[2];
		    		
		    		t.setIdTure(id);
		    		t.setGrad(new Lokacija(grad));
		    		t.setVodic(vodic);
		    		brojac++;
		    	}else{
		    		if (turaId.equalsIgnoreCase(delovi[0])){
		    			
		    			Date pocetak = sdf.parse(delovi[1]);
		    			Date kraj = sdf.parse(delovi[2]);
		    			int cena = Integer.parseInt(delovi[3]);
		    			
		    			ArrayList<LokacijaIzvedbe> lokacije = new ArrayList<LokacijaIzvedbe>();
		    			String[] lokDelovi = delovi[4].split("\\;");
		    			for (int i = 0; i < lokDelovi.length; i++){
		    				LokacijaIzvedbe lk = new LokacijaIzvedbe(lokDelovi[i]);
		    				lokacije.add(lk);
		    			}
		    			
		    			LokacijeIzvedbe lokacijeIzv = new LokacijeIzvedbe(lokacije);
		    			IzvedbaTure it = new IzvedbaTure(pocetak,kraj,cena,lokacijeIzv);
		    			it.setIdTure(turaId);
		    			izvedbe.add(it);
		    		}else{

		    			IzvedbeTure izvTure = new IzvedbeTure(izvedbe);
		    			t.setListaIzvedbi(izvTure);

				    	ture.add(t);
				    	
				    	t = new Tura();
		    			izvedbe.clear();
				    	turaId = delovi[0];
		    			String id = delovi[0];
			    		String grad = delovi[1];
			    		String vodic = delovi[2];
			    		
			    		t.setIdTure(id);
			    		t.setGrad(new Lokacija(grad));
			    		t.setVodic(vodic);
		    			brojac = 1;
		    			
		    		}
		    	}
		    	
		        line = br.readLine();
		    }
	    	
			t.setListaIzvedbi(new IzvedbeTure(izvedbe));
			
	    	ture.add(t);
	    	
		} finally {
		    br.close();
		}
		
		return ture;
	}
	
	public static ArrayList<Korisnik> procitajKorisnike() throws IOException{
		ArrayList<Korisnik> korisnici = new ArrayList<Korisnik>();
		
		BufferedReader br = new BufferedReader(new FileReader("korisnici.txt"));
		try {
		    String line = br.readLine();

		    while (line != null) {
		    	//Korisnik k = new Korisnik();
		    	String[] delovi = line.split("\\|");
		    	
		    	if (delovi[0].equalsIgnoreCase("v")){
		    		
		    		String ki = delovi[1];
		    		String l = delovi[2];
		    		String ime = delovi[3];
		    		String prz = delovi[4];
		    		String pol = delovi[5];
		    		if (pol.equalsIgnoreCase("Muski")){
			    		Korisnik k = new Vodic(ki,l,prz,ime,Pol.Muski);
			    		korisnici.add(k);

		    		}else{
			    		Korisnik k = new Vodic(ki,l,prz,ime,Pol.Zenski);
			    		korisnici.add(k);

		    		}
		    	}else if (delovi[0].equalsIgnoreCase("t")){
		    		String ki = delovi[1];
		    		String l = delovi[2];
		    		String ime = delovi[3];
		    		String prz = delovi[4];
		    		String pol = delovi[5];
		    		if (pol.equalsIgnoreCase("0")){
			    		Korisnik k = new Turista(ki,l,prz,ime,Pol.Muski);
			    		korisnici.add(k);

		    		}else{
			    		Korisnik k = new Turista(ki,l,prz,ime,Pol.Zenski);
			    		korisnici.add(k);

		    		}
		    		
		    	}else{
		    		String ki = delovi[1];
		    		String l = delovi[2];
		    		Korisnik k = new Admin(ki,l);
		    		korisnici.add(k);

		    	}
		    	
		        line = br.readLine();
		    }
		} finally {
		    br.close();
		}
		
		return korisnici;
	}
}
