package model.data;

import model.collections.IzvedbeTure;

public class Tura {

	String idTure;
	Lokacija grad;
	IzvedbeTure listaIzvedbi;
	String slika;
	
	public String getSlika() {
		return slika;
	}
	public void setSlika(String slika) {
		this.slika = slika;
	}
	public String getIdTure() {
		return idTure;
	}
	public void setIdTure(String idTure) {
		this.idTure = idTure;
	}
	public Lokacija getGrad() {
		return grad;
	}
	public void setGrad(Lokacija lokacijaIzvedbe) {
		this.grad = lokacijaIzvedbe;
	}
	public IzvedbeTure getListaIzvedbi() {
		return listaIzvedbi;
	}
	public void setListaIzvedbi(IzvedbeTure listaIzvedbi) {
		this.listaIzvedbi = listaIzvedbi;
	}
	@Override
	public String toString() {
		return idTure + "|" + grad.getDrzava() + "|" + grad.getGrad() + "|" + grad.getOpis() +
				"|" + slika;
	}
	public Tura(String idTure, Lokacija grad, IzvedbeTure listaIzvedbi) {
		super();
		this.idTure = idTure;
		this.grad = grad;
		this.listaIzvedbi = listaIzvedbi;
	}
	public Tura() {
		super();
	}
	
	
	
}
