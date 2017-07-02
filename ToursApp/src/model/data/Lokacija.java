package model.data;

public class Lokacija {
	private String naziv;
	

	public Lokacija(String naziv) {
		super();
		this.naziv = naziv;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	
	@Override
	public String toString(){
		return naziv;
	}
}
