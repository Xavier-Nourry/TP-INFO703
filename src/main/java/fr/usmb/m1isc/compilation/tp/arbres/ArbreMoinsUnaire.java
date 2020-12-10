package fr.usmb.m1isc.compilation.tp.arbres;

import fr.usmb.m1isc.compilation.tp.ArbreAbstrait;

public class ArbreMoinsUnaire extends ArbreAbstrait {
    public int valeur;
    public ArbreMoinsUnaire(int valeur){
        super();
        this.valeur = valeur;
    }

    @Override
    public void genererCodeAssembleur(String fileToGenerate) {

    }
}