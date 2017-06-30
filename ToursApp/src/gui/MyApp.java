package gui;

import java.io.IOException;
import java.util.ArrayList;

import model.data.Korisnik;
import util.FilesReader;

public class MyApp {

	@SuppressWarnings({ "static-access" })
	public static void main(String[] args) throws IOException {
		FilesReader fr = new FilesReader();
		ArrayList<Korisnik> k = fr.procitajKorisnike();
		LogInWindow login = new LogInWindow();
		login.setVisible(true);
		
		
		
	}

}
