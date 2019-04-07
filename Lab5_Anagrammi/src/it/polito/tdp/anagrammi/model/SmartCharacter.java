package it.polito.tdp.anagrammi.model;

public class SmartCharacter {

	private int contatore;
	private char valore;
	
	

	public SmartCharacter( char valore) {
		
		this.contatore = 1;
		this.valore = valore;
	}

	public int getContatore() {
		return contatore;
	}
	public void setContatore(int i) {
		this.contatore+=i;
		return;
	}
	
	public char getValore() {
		return valore;
	}

	
	
	
}
