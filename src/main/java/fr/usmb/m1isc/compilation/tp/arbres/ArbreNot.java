package fr.usmb.m1isc.compilation.tp.arbres;

import fr.usmb.m1isc.compilation.tp.ArbreAbstrait;

public class ArbreNot extends ArbreAbstrait {
    public boolean valeur;
    public ArbreNot(boolean valeur){
        super();
        this.valeur = valeur;
    }

    @Override
    public void genererCodeAssembleur(String fileToGenerate) {

    }
}