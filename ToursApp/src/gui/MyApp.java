package gui;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

import model.collections.Korisnici;
import model.collections.Ture;
import model.data.Korisnik;
import model.data.Tura;
import model.data.Turista;
import model.data.Vodic;
import util.FilesReader;
import util.FilesWriter;

public class MyApp {

	@SuppressWarnings({ "static-access" })
	public static void main(String[] args) throws IOException, ParseException, InterruptedException {
		FilesReader fr = new FilesReader();
		
		ArrayList<Tura> t = fr.procitajTure();
		ArrayList<Korisnik> k = fr.procitajKorisnike();
		
		Korisnici kor = new Korisnici(k);
		Ture tur = new Ture(t);
		
		FilesWriter fw = new FilesWriter();
		fw.writeUsers(kor);
		fw.writeTours(tur);
		fw.upisiIzvedbe(tur);

		LogInWindow login = new LogInWindow();
		login.setKorisnici(kor);
		login.setVisible(true);
		
		waitForButton(login);
		
		Korisnik korisnik = login.getK();
		System.out.println(korisnik);
		
		if (korisnik instanceof Vodic){
			VodicWindow vodicWin = new VodicWindow(korisnik, tur);
			vodicWin.setVisible(true);
		}else if (korisnik instanceof Turista){
			TuristaWindow turistaWin = new TuristaWindow(korisnik, tur);
			turistaWin.setVisible(true);
		}else{
			AdminWindow adminWin = new AdminWindow(korisnik, kor);
			adminWin.setVisible(true);
		}
	}
	
	static void waitForButton(LogInWindow login) throws InterruptedException{
		while (login.isVisible()){
			Thread.sleep(100);
		}
	}

}
