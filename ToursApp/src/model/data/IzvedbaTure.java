package model.data;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import model.collections.Komentari;
import model.collections.LokacijeIzvedbe;
import model.collections.Ocene;
import model.state.IzvedbaSpremna;
import model.state.StanjeIzvedbe;

public class IzvedbaTure extends Tura{
	
	String idIzvedbe;
	Date pocetak;
	Date kraj;
	Ocene ocene;
	Komentari komentari;
	LokacijeIzvedbe lokIzvedbe;
	int minTurista;
	int maxTurista;
	ArrayList<String> turisti;
	String vodic;
	
	StanjeIzvedbe stanje;
	
	Timer timer;
	
	private void pokreniTimer(){
		timer.scheduleAtFixedRate(new TimerTask() {
			  @Override
			  public void run() {
				  Date danasnjiDatum = new Date();
				  if (danasnjiDatum.after(pocetak)){
					  if (turisti.size() < minTurista){
						  otkaziIzvedbu();
					  }else{
						  otpocniIzvedbu();
					  }
				  }
				  if (danasnjiDatum.after(kraj)){
					  zavrsiIzvedbu();
				  }
			  }
			}, 1, 2*60*1000);
	}
	
	@SuppressWarnings("unused")
	private void promeniStanje(StanjeIzvedbe s){
		stanje = s;
	}
	
	public void otpocniIzvedbu(){
		stanje.otpocniIzvedbu(this);
	}
	
	public void zavrsiIzvedbu(){
		stanje.zavrsiIzvedbu(this);
	}
	
	public void otkaziIzvedbu(){
		stanje.otkaziIzvedbu(this);
	}
	
	public IzvedbaTure(Date pocetak, Date kraj, LokacijeIzvedbe lokIzvedbe) {
		super();
		this.pocetak = pocetak;
		this.kraj = kraj;
		this.lokIzvedbe = lokIzvedbe;
		this.stanje = IzvedbaSpremna.instance();
		this.setTimer(new Timer());
		pokreniTimer();
	}
	
	public IzvedbaTure() {
		super();
		this.setTimer(new Timer());
		pokreniTimer();
	}
	
	public ArrayList<String> getTuristi() {
		return turisti;
	}
	public void setTuristi(ArrayList<String> turisti) {
		this.turisti = turisti;
	}
	public String getVodic() {
		return vodic;
	}
	public void setVodic(String vodic) {
		this.vodic = vodic;
	}
	public String getIdIzvedbe() {
		return idIzvedbe;
	}
	public void setIdIzvedbe(String idIzvedbe) {
		this.idIzvedbe = idIzvedbe;
	}
	public int getMinTurista() {
		return minTurista;
	}
	public void setMinTurista(int minTurista) {
		this.minTurista = minTurista;
	}
	public int getMaxTurista() {
		return maxTurista;
	}
	public void setMaxTurista(int maxTurista) {
		this.maxTurista = maxTurista;
	}
	
	public Date getPocetak() {
		return pocetak;
	}
	public void setPocetak(Date pocetak) {
		this.pocetak = pocetak;
	}
	public Date getKraj() {
		return kraj;
	}
	public void setKraj(Date kraj) {
		this.kraj = kraj;
	}
	public LokacijeIzvedbe getLokIzvedbe() {
		return lokIzvedbe;
	}
	public void setLokIzvedbe(LokacijeIzvedbe lokIzvedbe) {
		this.lokIzvedbe = lokIzvedbe;
	}
	
	public String toString() {
		String p;
		String k;
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm");
		p = sdf.format(pocetak);
		k = sdf.format(kraj);

		return idTure + "|" + idIzvedbe + "|" + p + "|" + k + "|" + minTurista + 
				"|" + maxTurista + "|" + ceneToString() + "|" + LocToString() + "|" +
		opisToString() + "|" + vodic + "|" + komentariToString() + "|" + oceneToString() +
		"|" + turistaToString();
	}
	
	public Ocene getOcene() {
		return ocene;
	}
	public void setOcene(Ocene ocene) {
		this.ocene = ocene;
	}
	public Komentari getKomentari() {
		return komentari;
	}
	public void setKomentari(Komentari komentari) {
		this.komentari = komentari;
	}
	
	public StanjeIzvedbe getStanje() {
		return stanje;
	}

	public void setStanje(StanjeIzvedbe stanje) {
		this.stanje = stanje;
	}

	public Timer getTimer() {
		return timer;
	}

	public void setTimer(Timer timer) {
		this.timer = timer;
	}

	public String turistaToString(){
		String str = "";
		for (int i = 0; i < turisti.size(); i++) {
			str = str + turisti.get(i) + ";";
		}
		if(!(turisti.size()==0)){
			str = str.substring(0, str.length() - 1);
		}
		else{
			str = " ";
		}
		return str;
	}
	
	public String oceneToString(){
		String str = "";
		for (int i = 0; i < ocene.getOcene().size(); i++) {
			str = str + ocene.getOcene().get(i).getVrednost() + ";";
		}
		if(!(ocene.getOcene().size() == 0)){
			str = str.substring(0, str.length() - 1);
		}
		else{
			str = " ";
		}
		return str;
	}
	
	public String komentariToString(){
		String str = "";
		for (int i = 0; i < komentari.getKomentari().size(); i++) {
			str = str + komentari.getKomentari().get(i).getNaziv() + ":";
			str = str + komentari.getKomentari().get(i).getTelo() + ";";
		}
		if(!(komentari.getKomentari().size() == 0)){
			str = str.substring(0, str.length() - 1);
		}
		else{
			str = " ";
		}
		return str;
	}
	
	public String ceneToString(){
		String str = "";
		for (int i = 0; i < lokIzvedbe.getLokacijeIzvedbe().size(); i++) {
			str = str + lokIzvedbe.getLokacijeIzvedbe().get(i).getCena() + ";";
		}
		str = str.substring(0, str.length() - 1);
		return str;
	}
	
	public String opisToString(){
		String str = "";
		for (int i = 0; i < lokIzvedbe.getLokacijeIzvedbe().size(); i++) {
			str = str + lokIzvedbe.getLokacijeIzvedbe().get(i).getOpis() + ";";
		}
		str = str.substring(0, str.length() - 1);
		return str;
	}
	
	public String LocToString(){
		String str = "";
		for (int i = 0; i < lokIzvedbe.getLokacijeIzvedbe().size(); i++) {
			str = str + lokIzvedbe.getLokacijeIzvedbe().get(i).getNaziv() + ";";
		}
		str = str.substring(0, str.length() - 1);
		return str;
	}
	
	
	
}
