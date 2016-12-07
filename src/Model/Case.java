/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author rayanmehdi1
 */
public abstract class Case {

    protected Valeurs val;
    ArrayList<Groupe> tabGroupe;
    private boolean conflit;

    public Case(Valeurs val) {
        this.val = val;
    }

    public Valeurs getVal() {
        return val;
    }
    /*
    public void setVal(Valeurs val) {
        boolean ChangeVal=true;
        for (int i = 0; i < 3; i++) {
            if(tabGroupe.get(i).estEnConflit(val)){
                ChangeVal=false;
            }
        }
        
        if(ChangeVal)
            this.val=val;
    }
    */
    public boolean isConflit() {
        return conflit;
    }

    public void setConflit(boolean conflit) {
        this.conflit = conflit;
    }
    public boolean getConflit(){
        return this.conflit;
    }
    
    
    public ArrayList<Groupe> getTabGroupe() {
        return tabGroupe;
    }

    public void setTabGroupe(ArrayList<Groupe> tabGroupe) {
        this.tabGroupe= new ArrayList<>();
        for (int i = 0; i < tabGroupe.size(); i++) {
            this.tabGroupe.add(tabGroupe.get(i));
        }
    }
    
    public abstract void update(Valeurs val);
        
     public Object clone() {    
	    Object o = null;
    	try {
      		// On récupère l'instance à renvoyer par l'appel de la 
      		// méthode super.clone()
      		o = super.clone();
    	} catch(CloneNotSupportedException cnse) {
      		// Ne devrait jamais arriver car nous implémentons 
      		// l'interface Cloneable
      		cnse.printStackTrace(System.err);
	    }
	    // on renvoie le clone
	    return o;
  	}
    

}
