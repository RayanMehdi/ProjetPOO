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
public class caseNonBloquee extends Case{
    
    

    
    public caseNonBloquee(Valeurs val) {
        super(val);
    }

    public void setTabGroupe(ArrayList<Groupe> tabGroupe) {
        this.tabGroupe = tabGroupe;
    }

    public void setVal(Valeurs val){
        this.val=val;
    }
    
    @Override
    public void update(Valeurs val) {
        
        super.setConflit(false);
        for (Groupe g : tabGroupe ) {
            //System.out.println("");
            //System.out.println("Groupe : ");
            if (g.estEnConflit(this)) {
                super.setConflit(true);
        }
        this.val = val;
    }
    }
   }
