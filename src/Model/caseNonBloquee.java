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
    
    private boolean conflit;

    public boolean isConflit() {
        return conflit;
    }

    public void setConflit(boolean conflit) {
        this.conflit = conflit;
    }
    
    
    
    public caseNonBloquee(Valeurs val) {
        super(val);
    }

    public void setTabGroupe(ArrayList<Groupe> tabGroupe) {
        this.tabGroupe = tabGroupe;
    }

    public void setVal(Valeurs val){
        this.val=val;
    }
    
    public void update(Valeurs val) {
        this.val = val;
        conflit = false;
        for (Groupe g : tabGroupe ) {
            if (g.estEnConflit(this)) {
                conflit = true;
            }
        }
    }
}
