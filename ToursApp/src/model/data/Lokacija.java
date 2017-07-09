package model.data;

public class Lokacija {
	private String drzava;
	private String grad;
	private String opis;
	
	public Lokacija() {
		super();
	}
	
	public Lokacija(String drzava, String grad, String opis) {
		super();
		this.drzava = drzava;
		this.grad = grad;
		this.opis = opis;
	}

	
	public Lokacija(String grad) {
		super();
		this.grad = grad;
	}

	public String getDrzava() {
		return drzava;
	}

	public void setDrzava(String drzava) {
		this.drzava = drzava;
	}

	public String getGrad() {
		return grad;
	}

	public void setGrad(String grad) {
		this.grad = grad;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	@Override
	public String toString(){
		return grad;
	}
}
