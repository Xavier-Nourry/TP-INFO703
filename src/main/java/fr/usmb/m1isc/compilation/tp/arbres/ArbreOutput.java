package fr.usmb.m1isc.compilation.tp.arbres;

import fr.usmb.m1isc.compilation.tp.ArbreAbstrait;

public class ArbreOutput extends ArbreAbstrait {
    public String valeur;

    public ArbreOutput(String valeur){
        super();
        this.valeur = valeur;
    }

    @Override
    public void genererCodeAssembleur(String fileToGenerate) {

    }
}