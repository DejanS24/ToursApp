package model.state;

import model.data.IzvedbaTure;

public class IzvedbaSpremna extends StanjeIzvedbe{

	private static IzvedbaSpremna instance = new IzvedbaSpremna();
	
	public static IzvedbaSpremna instance(){
		return instance;
	}
	
	@Override
	public void otpocniIzvedbu(IzvedbaTure it){
		it.setStanje(IzvedbaUToku.instance());
	}
	
	@Override
	public void otkaziIzvedbu(IzvedbaTure it){
		it.setStanje(IzvedbaOtkazana.instance());
	}
}
