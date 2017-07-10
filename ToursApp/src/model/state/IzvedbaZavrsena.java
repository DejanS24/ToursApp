package model.state;

public class IzvedbaZavrsena extends StanjeIzvedbe{

	private static IzvedbaZavrsena instance = new IzvedbaZavrsena();
	
	public static IzvedbaZavrsena instance(){
		return instance;
	}
	
}
