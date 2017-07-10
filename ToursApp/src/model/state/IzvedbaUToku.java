package model.state;

import model.data.IzvedbaTure;

public class IzvedbaUToku extends StanjeIzvedbe{

	private static IzvedbaUToku instance = new IzvedbaUToku();
	
	public static IzvedbaUToku instance(){
		return instance;
	}

	@Override
	public void zavrsiIzvedbu(IzvedbaTure it){
		it.setStanje(IzvedbaZavrsena.instance());
	}
}
