package fr.usmb.m1isc.compilation.tp.arbres;

import fr.usmb.m1isc.compilation.tp.ArbreAbstrait;

public class ArbreEntier extends ArbreAbstrait{
    public int valeur;

    public ArbreEntier(int valeur, ArbreAbstrait f1, ArbreAbstrait f2) {
        super(f1, f2);
        this.valeur = valeur;
    }

    @Override
    public void genererCodeAssembleur(String fileToGenerate) {

    }
}
