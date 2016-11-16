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
        Valeurs val = new Valeurs(0);
        for(int i=0; i<9; i++)
            tab[i] = new Case(val));
    }
    
    
}
