package fr.usmb.m1isc.compilation.tp.arbres;

import fr.usmb.m1isc.compilation.tp.ArbreAbstrait;

public class ArbreOr extends ArbreAbstrait {
    public ArbreOr(ArbreAbstrait fils1, ArbreAbstrait fils2){
        super(fils1, fils2);
    }

    @Override
    public void genererCodeAssembleur(String fileToGenerate) {

    }
}