package fr.usmb.m1isc.compilation.tp.arbres;

import fr.usmb.m1isc.compilation.tp.ArbreAbstrait;

public class ArbreIdent extends ArbreAbstrait {
    public String valeur;
    public ArbreIdent(String valeur){
        super();
        this.valeur = valeur;
    }

    @Override
    public void genererCodeAssembleur(String fileToGenerate) {

    }
}