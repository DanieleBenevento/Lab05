package it.polito.tdp.anagrammi.model;

import java.util.*;

import it.polito.tdp.anagrammi.DAO.ParolaDAO;

public class Model {

	private List<String> sbagliate;
	private List<String> giuste;
	private ParolaDAO p;
	private int l=-1;
	private List<String> soluzioni;

	
	public Model() {
		 
		giuste= new LinkedList<String>();
		
		sbagliate=new LinkedList<String>();
		
		p=new ParolaDAO();
		
		soluzioni=new LinkedList<String>();
	}
	
	
	public List<String> getSbagliate() {
		
		return sbagliate;
	}


	public List<String> getGiuste() {
		
		return giuste;
	}
	
	
	public List<String> getSoluzioni() {
		
		return soluzioni;
	}
	
	
	public void setSoluzioni(String s) {
		if(!soluzioni.contains(s)) {
			soluzioni.add(s);
		}
	}


	public void genera(String input) {
		
		soluzioni.clear();
		
		l=input.length();
		
		Anagramma parziale = new Anagramma(input);
		
		this.recursive(parziale, 0);
	}

	
	public void recursive(Anagramma parziale,int level) {
	
		if(l==level) {
			
			this.setSoluzioni(parziale.parolaInserita());
			
			return;
		}
		else {
		
		for(int i=0;i<l;i++) {
			
			parziale.getCaratteriInseriti().add(parziale.getCaratteriPossibili().get(i).getValore());
			
			parziale.getCaratteriPossibili().get(i).setContatore(-1);
		
				if( parziale.getCaratteriPossibili().get(i).getContatore()>=0) {
					
					recursive(parziale, level+1);
				}
					
		parziale.getCaratteriPossibili().get(i).setContatore(1);
		
		parziale.getCaratteriInseriti().remove(level);
		}	
		}
		return;
	}
	
	public void controlloAnagramma(List<String> s) {
		
		for(String s1:s) {
			
			if(p.anagrammaPresente(s1)==true) {
				
				giuste.add(s1);
			}
			else {
				
				sbagliate.add(s1);
			}
		}
		return ;
	}
}
