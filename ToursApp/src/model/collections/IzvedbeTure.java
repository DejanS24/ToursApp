package model.collections;

import java.util.ArrayList;

import model.data.IzvedbaTure;

public class IzvedbeTure{

	ArrayList<IzvedbaTure> izvedbeTure;

	public IzvedbeTure(ArrayList<IzvedbaTure> izT) {
		super();
		this.izvedbeTure = new ArrayList<IzvedbaTure>();
		for (int i = 0; i < izT.size(); i++){
			this.izvedbeTure.add(izT.get(i));
		}
	}

	public IzvedbeTure() {
		super();
	}

	public ArrayList<IzvedbaTure> getIzvedbeTure() {
		return izvedbeTure;
	}

	public void setIzvedbeTure(ArrayList<IzvedbaTure> izvedbeTure) {
		this.izvedbeTure = izvedbeTure;
	}
	
}
