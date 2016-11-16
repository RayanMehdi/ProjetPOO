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
public class Jeu {
    private ArrayList<Groupe> tabL;
    private ArrayList<Groupe> tabC;
    private ArrayList<ArrayList<Groupe>> tabCa;

    public Jeu(String data) {
        init(data);
        
    }
    
    public void init(String data){
        
        
        for(int i=0; i<9; i++){
            tabL.set(i, new Groupe());
            tabC.set(i, new Groupe());
        }
        
        String[]tabData = data.split(" ");
        
        int numL,numC;
        
	for(int i = 0; i<tabData.length; i++){
            
            // VOIR POUR LA CLASSE CASE
            caseBloquee c = new caseBloquee(tabData[i]);
            numL = i/9;
            numC = i%9;
            tabL.get(numL).add(c);
            tabC.get(numC).add(c);
            tabCa.get(numL/3).get(numC/3).add(c);
        }
    }
    
    public void affiche(){
        
        System.out.println("");
    }
    
}
