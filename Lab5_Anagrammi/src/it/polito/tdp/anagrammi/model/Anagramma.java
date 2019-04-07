package it.polito.tdp.anagrammi.model;

import java.util.ArrayList;
import java.util.List;

public class Anagramma {

	private List<SmartCharacter> caratteriPossibili;
	private List<Character> caratteriInseriti;

	
	public Anagramma(String input) {
		
		caratteriInseriti=new ArrayList<Character>();
		caratteriPossibili = new ArrayList<SmartCharacter>();
		this.setCaratteriPossibili(input.trim());
		}
	
	public void setCaratteriPossibili(String input){
		int count;
		char[] array=input.trim().toCharArray();
		for(int i=0;i<array.length;i++) {
			count=0;
			SmartCharacter s =new SmartCharacter(array[i]);
		    for(int j=0;j<array.length && j!=i;j++) {
		    	if(array[i]==array[j]) {
		    		count++;
		    	}
		    }
		    s.setContatore(count);
			this.caratteriPossibili.add(s);
		}
		for(int k=0;k<array.length;k++) {
			for(int l=0;l<array.length && l!=k;l++) {
				if(array[k]==array[l]) {
		    		caratteriPossibili.add(l, caratteriPossibili.get(k));
		    		caratteriPossibili.remove(l+1);
		    	}
			}
			}
	}
	
	public int getSize() {
		return caratteriInseriti.size();
	}

	public String parolaInserita() {
		String ris="";
		for(Character c : caratteriInseriti) {
			ris += c;
		}
		return ris;
	}

	public List<SmartCharacter> getCaratteriPossibili() {
		return caratteriPossibili;
	}

	public List<Character> getCaratteriInseriti() {
		return caratteriInseriti;
	}
}
