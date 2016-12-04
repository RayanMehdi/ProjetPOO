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
        Case c;
        int numL,numC;
        
        tabL = new ArrayList();
        tabC = new ArrayList();
        tabCa = new ArrayList();
        for(int i=0; i<9; i++){
            tabL.add(i, new Groupe());
            tabC.add(i, new Groupe());
            
        }
        for (int i = 0; i < 3; i++) {
            tabCa.add(i, new ArrayList());
            for (int j = 0; j < 3; j++) {
                tabCa.get(i).add(j,new Groupe());
            }
        }
        
        String[]tabData = data.split(" ");
        
	for(int i = 0; i<tabData.length; i++){
            
            
            if(tabData[i].equals("0"))
                c = new caseNonBloquee(Valeurs.ZERO);
            else
                c = new caseBloquee((Valeurs.fromString(tabData[i])));
            numL = i/9;
            numC = i%9;
            
            // Ajout des cases dans les groupes (dans les tableau de groupe linge, colonne et carré)
            tabL.get(numL).add(c);
            tabC.get(numC).add(c);
            tabCa.get(numL/3).get(numC/3).add(c);
            

            // Ajout des groupes dans le tableau de groupe d'une case.
            ArrayList<Groupe> tabGroupe = new ArrayList();
            tabGroupe.add(tabL.get(numL));
            tabGroupe.add(tabC.get(numC));
            tabGroupe.add(tabCa.get(numL/3).get(numC/3));
            c.setTabGroupe(tabGroupe);
        }
    }
    
    public void affiche(){
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(tabL.get(i).getCase(j).getVal().getV()+" ");
            }
            System.out.println("");
        }
        
    }
    public String getValeurCase(int i, int j){
        return Integer.toString(tabL.get(i).getCase(j).getVal().getV());
    }
    
    public Case getCase(int i, int j){
        return tabL.get(i).getCase(j);
    }
    public boolean fin(){
        boolean fin = true;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                Case c = tabL.get(i).getCase(j);     
                if(c.val==Valeurs.ZERO){
                    fin = false;
                    break;
                }
                for (Groupe g : c.tabGroupe ) {
                    System.out.println("");
                    System.out.println("Groupe : ");
                    if (g.estEnConflit(c.val)) {
                        fin = false;
                        break;
                    }
                }
            }
        }
        return fin;
    }
}
