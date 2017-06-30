package gui;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

import model.collections.Korisnici;
import model.collections.Ture;
import model.data.Korisnik;
import model.data.Tura;
import util.FilesReader;
import util.FilesWriter;

public class MyApp {

	@SuppressWarnings({ "static-access" })
	public static void main(String[] args) throws IOException, ParseException {
		FilesReader fr = new FilesReader();
		
		ArrayList<Tura> t = fr.procitajTure();
		ArrayList<Korisnik> k = fr.procitajKorisnike();
		
		Korisnici kor = new Korisnici(k);
		Ture tur = new Ture(t);
		
		FilesWriter fw = new FilesWriter();
		fw.writeUsers(kor);
		fw.writeTours(tur);
		
		LogInWindow login = new LogInWindow();
		login.setVisible(true);
		
		
		
	}

}
