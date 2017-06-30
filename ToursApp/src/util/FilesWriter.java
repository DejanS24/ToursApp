package util;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import model.collections.Korisnici;
import model.collections.Ture;

public class FilesWriter {

	void writeUsers(Korisnici users){
		try {
			PrintWriter k = new PrintWriter(new FileWriter("Korisnici.txt"));
			k.write("");
			for (int i = 0; i < users.getKorisnici().size(); i++) {
				k.print(users.getKorisnici().get(i).toString());
				k.println();
			}
			k.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	};
	void writeTours(Ture t){
		
	};
	
	
}
