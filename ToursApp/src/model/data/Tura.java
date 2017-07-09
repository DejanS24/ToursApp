package model.data;

import model.collections.IzvedbeTure;

public class Tura {

	String idTure;
	String vodic;
	Lokacija grad;
	IzvedbeTure listaIzvedbi;
	
	public String getIdTure() {
		return idTure;
	}
	public void setIdTure(String idTure) {
		this.idTure = idTure;
	}
	public String getVodic() {
		return vodic;
	}
	public void setVodic(String vodic) {
		this.vodic = vodic;
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
		return idTure + "|" + grad + "|" + vodic;
	}
	public Tura(String idTure, String vodic, Lokacija grad, IzvedbeTure listaIzvedbi) {
		super();
		this.idTure = idTure;
		this.vodic = vodic;
		this.grad = grad;
		this.listaIzvedbi = listaIzvedbi;
	}
	public Tura() {
		super();
	}
	
	
	
}
