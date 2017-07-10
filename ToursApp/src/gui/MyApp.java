package gui;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

import model.collections.Korisnici;
import model.collections.Ture;
import model.data.Admin;
import model.data.IzvedbaTure;
import model.data.Korisnik;
import model.data.Tura;
import model.data.Turista;
import model.data.Vodic;
import model.state.IzvedbaOtkazana;
import util.FilesReader;
import util.FilesWriter;

public class MyApp {
	
	static Korisnik korisnik;
	
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
		
		korisnik = login.getK();
		
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
	
	static boolean jeZauzet(Korisnik kor, Date datP, Date datZ){
		for (Tura tura : t){
			for (IzvedbaTure it : tura.getListaIzvedbi().getIzvedbeTure()){
				for (String korIme:it.getTuristi()){
					if (korIme.equalsIgnoreCase(kor.getKorisnickoIme())){
						if (kor.getKorisnickoIme().equals(korIme)){
							
							if (datP.after(it.getPocetak()) && datP.before(it.getKraj())){
								return true;
							}
							if (datZ.after(it.getPocetak()) && datZ.before(it.getKraj())){
								return true;
							}
						}
					}
				}
			}
		}		
		return false;
	}
	
	static boolean izvedbaSeMozeRezervisati(IzvedbaTure it){
		if (it.getTuristi().size() == it.getMaxTurista() || it.getStanje() instanceof IzvedbaOtkazana){
			return false;
		}else{
			return true;
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
	
	static void rezervisiKorisnikaUIzvedbu(String korisnickoIme, IzvedbaTure it, Ture ture){
		ArrayList<String> turisti = it.getTuristi();
		turisti.add(korisnickoIme);
		it.setTuristi(turisti);
		
		for (int i = 0; i < ture.getTure().size(); i++){
			Tura t = ture.getTure().get(i);
			for (int j = 0; j < t.getListaIzvedbi().getIzvedbeTure().size(); j++){
				IzvedbaTure izv = t.getListaIzvedbi().getIzvedbeTure().get(j);
				if (izv.getIdIzvedbe().equalsIgnoreCase(it.getIdIzvedbe())){
					izv = it;
				}
			}
		}
		FilesWriter fw = new FilesWriter();
		fw.upisiIzvedbe(ture);
	}

}
