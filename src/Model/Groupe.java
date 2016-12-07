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

    public ArrayList<Case> getTab() {
        return tab;
    }
    
    public boolean estEnConflit(Case c){
		boolean ret = false, present = false;
                
		for(Case c2 : tab){
                    //System.out.print(" val :"+c2.getVal());
			if(/*c2 instanceof caseBloquee &&*/ c.val == c2.getVal()){
                            //System.out.println(c2.getVal());
                            if(present)
                                ret = true;
                            present=true;
                            
                        }
		}
		return ret;
    }
    
    
    public void add(Case c){
        this.tab.add(c);
    }
    
    public Case getCase(int i) {
        return tab.get(i);
    }
    public Groupe clone() {   
        Groupe grp=null;
        try {
	    grp = (Groupe) super.clone();
	    
            for(int i=0;i<grp.tab.size();i++)
                grp.tab.add((Case) this.tab.get(i).clone());
	   
            } catch(CloneNotSupportedException cnse) {
                cnse.printStackTrace(System.err);   
            }
            
	    return grp;
  	}
}
