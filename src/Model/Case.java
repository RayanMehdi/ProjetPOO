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
    

    public Case(Valeurs val) {
        this.val = val;
    }

    public Valeurs getVal() {
        return val;
    }

    public ArrayList<Groupe> getTabGroupe() {
        return tabGroupe;
    }

    public void setTabGroupe(ArrayList<Groupe> tabGroupe) {
        this.tabGroupe = tabGroupe;
    }
    

    

}
