package util;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import model.collections.Korisnici;
import model.collections.Ture;
import model.data.Turista;
import model.data.Vodic;

public class FilesWriter {

	public void writeUsers(Korisnici users){
		try {
			PrintWriter k = new PrintWriter(new FileWriter("korisnici_out.txt"));
			k.write("");
			for (int i = 0; i < users.getKorisnici().size(); i++) {
				if(users.getKorisnici().get(i) instanceof Vodic){
					k.print("v|");
				}
				else if(users.getKorisnici().get(i) instanceof Turista){
					k.print("t|");
				}
				else{
					k.print("a|");
				}
				k.print(users.getKorisnici().get(i).toString());
				k.println();
			}
			k.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	};
	public void writeTours(Ture t){
		try {
			PrintWriter tt = new PrintWriter(new FileWriter("ture_out.txt"));
			tt.write("");
			for (int i = 0; i < t.getTure().size(); i++) {
				tt.println(t.getTure().get(i).toString());
			}
			tt.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	};
	
	public void upisiIzvedbe(Ture t){
		try {
			PrintWriter tt = new PrintWriter(new FileWriter("izvedbe_out.txt"));
			tt.write("");
			for (int i = 0; i < t.getTure().size(); i++) {
				for (int j = 0; j < t.getTure().get(i).getListaIzvedbi().getIzvedbeTure().size(); j++) {
					tt.println(t.getTure().get(i).getListaIzvedbi().getIzvedbeTure().get(j).toString());
				}
				
			}
			tt.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}