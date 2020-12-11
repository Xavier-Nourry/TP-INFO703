package fr.usmb.m1isc.compilation.tp.arbres;

import fr.usmb.m1isc.compilation.tp.ArbreAbstrait;

public class ArbreOutput extends ArbreAbstrait {
    public String valeur;

    public ArbreOutput(ArbreAbstrait valeur){
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