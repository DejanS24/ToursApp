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
import model.collections.Komentari;
import model.collections.LokacijeIzvedbe;
import model.collections.Ocene;
import model.data.Admin;
import model.data.IzvedbaTure;
import model.data.Komentar;
import model.data.Korisnik;
import model.data.Lokacija;
import model.data.LokacijaIzvedbe;
import model.data.Ocena;
import model.data.Osoba.Pol;
import model.data.Tura;
import model.data.Turista;
import model.data.Vodic;

public class FilesReader {

	public static ArrayList<Tura> procitajTure() throws IOException, ParseException{
		ArrayList<Tura> ture = new ArrayList<Tura>();
		
		BufferedReader br = new BufferedReader(new FileReader("ture.txt"));
		try {
		    String line = br.readLine();

		    String turaId = "";
		    String drzava;
		    String grad;
		    String opis;
		    String slika;
	    	
	    	while (line != null) {
		    	String[] delovi = line.split("\\|");
		    	Tura t = new Tura();
		    		turaId = delovi[0];
		    		drzava = delovi[1];
		    		grad = delovi[2];
		    		opis = delovi[3];
		    	    slika = delovi[4];
		    		
		    		t.setIdTure(turaId);
		    		t.setGrad(new Lokacija(drzava,grad,opis));
		    		t.setSlika(slika);
		    	
		    		ture.add(t);
		    		line = br.readLine();
	    	}

		} finally {
		    br.close();
		}
		
		ture = procitajIzvedbe(ture);
		return ture;
	}
	
	public static ArrayList<Tura> procitajIzvedbe(ArrayList<Tura> ture)  throws IOException, ParseException{
		DateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm");
		BufferedReader br = new BufferedReader(new FileReader("izvedbeTure.txt"));
		ArrayList<IzvedbaTure> listaIzvedbiTure = new ArrayList<IzvedbaTure>();
		try{
			String line = br.readLine();
			String idTure = "";
			String idIzvedbe = "";
			Date pocetak;
			Date kraj;
			int min;
			int max;
			String opis = "";
			String cene = "";
			String lokacija = "";
			String vodic = "";
			String komentari = "";
			String turisti = "";
			String ocene = "";
			
			IzvedbeTure izvedbeTure = new IzvedbeTure();
			while(line != null){
				IzvedbaTure it = new IzvedbaTure();	
				
				Ocene o = new Ocene();
				Komentari k = new Komentari();
				
				ArrayList<Ocena> listaOcena = new ArrayList<Ocena>();
				
				ArrayList<Komentar> listaKomentara = new ArrayList<Komentar>();
				LokacijeIzvedbe l = new LokacijeIzvedbe();
				
				ArrayList<LokacijaIzvedbe> listaLokacija = new ArrayList<LokacijaIzvedbe>();
				ArrayList<String> listaTurista = new ArrayList<String>();
				
				
				String [] delovi = line.split("\\|");
				
				idTure = delovi[0];
				idIzvedbe = delovi[1];
				pocetak = sdf.parse(delovi[2]);
				kraj = sdf.parse(delovi[3]);
				min = Integer.parseInt(delovi[4]);
				max = Integer.parseInt(delovi[5]);
				opis = delovi[8];
				cene = delovi[6];
				lokacija = delovi[7];
				vodic = delovi[9];
				komentari = delovi[10];
				ocene = delovi[11];
				turisti = delovi[12];
				
				it.setIdTure(idTure);
				it.setIdIzvedbe(idIzvedbe);
				it.setPocetak(pocetak);
				it.setKraj(kraj);
				it.setMinTurista(min);
				it.setMaxTurista(max);
				it.setVodic(vodic);
				
				String[] lok = lokacija.split(";");
				String[] cen = cene.split(";");
				String[] opisi = opis.split(";");
				
				
				
				for (int i = 0; i < lok.length; i++) {
					LokacijaIzvedbe lk = new LokacijaIzvedbe();
					lk.setCena(cen[i]);
					lk.setNaziv(lok[i]);
					lk.setOpis(opisi[i]);
					listaLokacija.add(lk);
					
					
				}
				
				l.setLokacijeIzvedbe(listaLokacija);
				it.setLokIzvedbe(l);
				
				String[] tur;
				if(!turisti.equals(" ")){
					tur = turisti.split(";");
				}
				else{
					tur = new String[0];
				}
				
				String[] oc;
				if(!ocene.equals(" ")){
					oc = ocene.split(";");
				}
				else{
					oc = new String[0];
				}
				
				String[] kom;
				if(!komentari.equals(" ")){
					kom = komentari.split(";");
				}
				else{
					kom = new String[0];
				}
				
				for (int i = 0; i < oc.length; i++) {
					Ocena ocena1 = new Ocena();
					ocena1.setVrednost(Integer.parseInt(oc[i]));
					listaOcena.add(ocena1);
				}
				o.setOcene(listaOcena);
				
				it.setOcene(o);
				
				for (int i = 0; i < kom.length; i++) {
					Komentar komentar1 = new Komentar();
					String[] komentari1 = kom[i].split(":");
					komentar1.setNaziv(komentari1[0]);
					komentar1.setTelo(komentari1[1]);
					listaKomentara.add(komentar1);
				}
				k.setKomentari(listaKomentara);
				it.setKomentari(k);
				
				for (int i = 0; i < tur.length; i++) {
					listaTurista.add(tur[i]);
				}
				it.setTuristi(listaTurista);
				
				line = br.readLine();
				listaIzvedbiTure.add(it);
				
				}			
		}
		finally{
			br.close();
		}
		
		for (int i = 0; i < ture.size(); i++) {
			ArrayList<IzvedbaTure> izvedbe = new ArrayList<IzvedbaTure>();
			for (int j = 0; j < listaIzvedbiTure.size(); j++) {
				if(ture.get(i).getIdTure().equals(listaIzvedbiTure.get(j).getIdTure())){
					izvedbe.add(listaIzvedbiTure.get(j));
				}
			}
			IzvedbeTure izvedbeTure = new IzvedbeTure();
			izvedbeTure.setIzvedbeTure(izvedbe);
			ture.get(i).setListaIzvedbi(izvedbeTure);
			
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
		    		String brojTelefona = delovi[6];
		    		boolean aktivan = Boolean.parseBoolean(delovi[7]);
		    		if (pol.equalsIgnoreCase("Muski")){
			    		Korisnik k = new Vodic(ki,l,prz,ime,Pol.Muski, brojTelefona, aktivan);
			    		korisnici.add(k);

		    		}else{
			    		Korisnik k = new Vodic(ki,l,prz,ime,Pol.Zenski, brojTelefona, aktivan);
			    		korisnici.add(k);

		    		}
		    		
		    	}else if (delovi[0].equalsIgnoreCase("t")){
		    		String ki = delovi[1];
		    		String l = delovi[2];
		    		String ime = delovi[3];
		    		String prz = delovi[4];
		    		String pol = delovi[5];
		    		String kontakt = delovi[6];
		    		if (pol.equalsIgnoreCase("0")){
			    		Korisnik k = new Turista(ki,l,prz,ime,Pol.Muski, kontakt);
			    		korisnici.add(k);

		    		}else{
			    		Korisnik k = new Turista(ki,l,prz,ime,Pol.Zenski, kontakt);
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
