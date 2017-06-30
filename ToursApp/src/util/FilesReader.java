package util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import model.data.Admin;
import model.data.IzvedbaTure;
import model.data.Korisnik;
import model.data.Lokacija;
import model.data.Osoba.Pol;
import model.data.Tura;
import model.data.Turista;
import model.data.Vodic;

public class FilesReader {

	public static ArrayList<Tura> procitajTure() throws IOException, ParseException{
		ArrayList<Tura> ture = new ArrayList<Tura>();
		
		DateFormat sdf = new SimpleDateFormat("dd.mm.yyyy");
		
		BufferedReader br = new BufferedReader(new FileReader("ture.txt"));
		try {
		    String line = br.readLine();

		    String turaId = "";
		    int brojac = 0;
		    while (line != null) {
		    	Tura t = new Tura();
		    	String[] delovi = line.split("\\|");
		    	
		    	if (brojac == 0){
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
		    			
		    			ArrayList<Lokacija> lokacije = new ArrayList<Lokacija>();
		    			String[] lokDelovi = delovi[4].split("\\;");
		    			for (int i = 0; i < lokDelovi.length; i++){
		    				Lokacija lk = new Lokacija(lokDelovi[i]);
		    				lokacije.add(lk);
		    			}
		    			
		    			IzvedbaTure it = new IzvedbaTure(pocetak,kraj,cena,lokacije);
		    		}else{
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
		    	ture.add(t);
		    	
		        line = br.readLine();
		    }
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
		    	Korisnik k = new Korisnik();
		    	String[] delovi = line.split("\\|");
		    	
		    	if (delovi[0].equalsIgnoreCase("v")){
		    		
		    		String ki = delovi[1];
		    		String l = delovi[2];
		    		String ime = delovi[3];
		    		String prz = delovi[4];
		    		String pol = delovi[5];
		    		if (pol.equalsIgnoreCase("0")){
			    		k = new Vodic(ki,l,ime,prz,Pol.Muski);

		    		}else{
			    		k = new Vodic(ki,l,ime,prz,Pol.Zenski);

		    		}
		    	}else if (delovi[0].equalsIgnoreCase("t")){
		    		String ki = delovi[1];
		    		String l = delovi[2];
		    		String ime = delovi[3];
		    		String prz = delovi[4];
		    		String pol = delovi[5];
		    		if (pol.equalsIgnoreCase("0")){
			    		k = new Turista(ki,l,ime,prz,Pol.Muski);

		    		}else{
			    		k = new Turista(ki,l,ime,prz,Pol.Zenski);

		    		}
		    		
		    	}else{
		    		String ki = delovi[1];
		    		String l = delovi[2];
		    		k = new Admin(ki,l);
		    	}
		    	
		    	
		    	korisnici.add(k);
		    	
		        line = br.readLine();
		    }
		} finally {
		    br.close();
		}
		
		return korisnici;
	}
}
