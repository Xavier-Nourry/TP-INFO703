package fr.usmb.m1isc.compilation.tp;

import java.io.File;

public class ArbreAbstrait {
    // Fils de l'arbre
    private ArbreAbstrait fils1;
    private ArbreAbstrait fils2;
    private ArbreAbstrait fils3;
    // Valeur du noeud
    private String valeur;
    // Indique si au le noeud est une feuille (utilisé pour l'affichage)
    private boolean estFeuille;

    // On fait différents constructeurs selon le nombre de fils
    public ArbreAbstrait(String valeur){
        this(valeur, null, null, null);
        estFeuille = true; // Vient corriger l'affectation faire par le constructeur appelé avant
    }

    public ArbreAbstrait(String valeur, ArbreAbstrait fils1) {this(valeur, fils1, null, null);}

    public ArbreAbstrait(String valeur, ArbreAbstrait fils1, ArbreAbstrait fils2) {this(valeur, fils1, fils2, null);}

    public ArbreAbstrait(String valeur, ArbreAbstrait fils1, ArbreAbstrait fils2, ArbreAbstrait fils3) {
        this.valeur = valeur;
        this.fils1 = fils1;
        this.fils2 = fils2;
        this.fils3 = fils3;
        estFeuille = false;
    }

    public void toAssembly(String fileToGenerate){

    }

    // Affiche l'arbre sous la forme d'une expression préfixée parenthésée
    public String toString(){
        String res = valeur + " ";
        if (fils1 != null)
            res += fils1.toString();
        if (fils2 != null)
            res += fils2.toString();
        if (fils3 != null)
            res += fils3.toString();
        if (!estFeuille)
            res = "(" + res + ")";
        return res;
    }
}
