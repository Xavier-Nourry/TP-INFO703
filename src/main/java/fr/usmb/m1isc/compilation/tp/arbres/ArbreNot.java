package fr.usmb.m1isc.compilation.tp.arbres;

import fr.usmb.m1isc.compilation.tp.ArbreAbstrait;

public class ArbreNot extends ArbreAbstrait {
    public boolean valeur;
    public ArbreNot(ArbreAbstrait valeur){
        super();
        //this.valeur = valeur;
    }

    @Override
    public String genereInstructions() {
        return null;
    }

    @Override
    protected String valeurToString() {
        return null;
    }
}