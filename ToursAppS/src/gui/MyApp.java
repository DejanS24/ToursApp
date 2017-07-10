package gui;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

import model.collections.Korisnici;
import model.collections.Ture;
import model.data.Admin;
import model.data.Korisnik;
import model.data.Tura;
import model.data.Turista;
import model.data.Vodic;
import util.FilesReader;
import util.FilesWriter;

public class MyApp {
	
	static ArrayList<Tura> t;
	static ArrayList<Korisnik> k;

	@SuppressWarnings({ "static-access" })
	public static void main(String[] args) throws IOException, ParseException, InterruptedException {
		FilesReader fr = new FilesReader();
		
		t = fr.procitajTure();
		k = fr.procitajKorisnike();
		
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
		
		if (korisnik instanceof Vodic){
			VodicWindow vodicWin = new VodicWindow(korisnik, tur);
			vodicWin.setVisible(true);
		}else if (korisnik instanceof Turista){
			TuristaWindow turistaWin = new TuristaWindow(korisnik, tur);
			turistaWin.setVisible(true);
		}else{
			Admin a = new Admin();
			a.setKorisnickoIme(korisnik.getKorisnickoIme());
			a.setLozinka(korisnik.getLozinka());
			a.setListaZahteva(fr.procitajZahteve());
			AdminWindow adminWin = new AdminWindow(a);
			adminWin.setVisible(true);
		}
	}
	
	static void prihvatiVodica(String turistaKorisnickoIme, Admin admin){
		ArrayList<String> zahtevi = admin.getListaZahteva();
		for (Korisnik korisnik : k){
			if (korisnik.getKorisnickoIme().equals(turistaKorisnickoIme)){
				k.remove(korisnik);
				Turista turista = (Turista) korisnik;
				
				Vodic v = new Vodic(turista.getKorisnickoIme(), turista.getLozinka(), turista.getPrezime(), turista.getIme(), turista.getPol(), turista.getKontakt(), true);
				k.add(v);
				
				zahtevi.remove(turistaKorisnickoIme);
				admin.setListaZahteva(zahtevi);
				FilesWriter fw = new FilesWriter();
				fw.upisiZahteve(zahtevi);
				Korisnici kors = new Korisnici(k);
				fw.writeUsers(kors);
				return;
			}
		}
	}
	
	static void waitForButton(LogInWindow login) throws InterruptedException{
		while (login.isVisible()){
			Thread.sleep(100);
		}
	}

}
