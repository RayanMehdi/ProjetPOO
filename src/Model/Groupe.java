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
    }
    
    public boolean estEnConflit(Case c){
		boolean ret = false;
		for(Case c2 : tab){
			if(c.getVal()!=c2.getVal())
				ret = true;
			
		}
		return ret;
	}
}
