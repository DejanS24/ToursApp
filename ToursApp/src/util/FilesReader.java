package util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import model.data.Korisnik;
import model.data.Tura;

public class FilesReader {

	public static ArrayList<Tura> procitajTure() throws IOException{
		ArrayList<Tura> ture = new ArrayList<Tura>();
		
		BufferedReader br = new BufferedReader(new FileReader("ture.txt"));
		try {
		    StringBuilder sb = new StringBuilder();
		    String line = br.readLine();

		    while (line != null) {
		    	Tura t = new Tura();
		    	String[] delovi = line.split("|");
		    	
		    	ture.add(t);
		    	
		        sb.append(line);
		        sb.append(System.lineSeparator());
		        line = br.readLine();
		    }
		    String everything = sb.toString();
		} finally {
		    br.close();
		}
		
		return ture;
	}
	
	public static ArrayList<Korisnik> procitajKorisnike() throws IOException{
		ArrayList<Korisnik> korisnici = new ArrayList<Korisnik>();
		
		BufferedReader br = new BufferedReader(new FileReader("korisnici.txt"));
		try {
		    StringBuilder sb = new StringBuilder();
		    String line = br.readLine();

		    while (line != null) {
		    	Korisnik k = new Korisnik();
		    	String[] delovi = line.split("|");
		    	
		    	korisnici.add(k);
		    	
		        sb.append(line);
		        sb.append(System.lineSeparator());
		        line = br.readLine();
		    }
		    String everything = sb.toString();
		} finally {
		    br.close();
		}
		
		return korisnici;
	}
}
