/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author Jo'
 */
public class Groupe {
    private ArrayList<Case> tab;

    public Groupe() {
        
        tab = new ArrayList<Case>();
        //for(int i=0; i<9; i++)
        //    tab.add(new caseNonBloquee(Valeurs.ZERO));
        
    }
    
    public boolean estEnConflit(Case c){
		boolean ret = false;
		for(Case c2 : tab){
			if(c.getVal()!=c2.getVal())
				ret = true;
		}
		return ret;
	}
    public void add(Case c){
        this.tab.add(c);
    }
    
    public Case getCase(int i) {
        return tab.get(i);
    }
    
}
