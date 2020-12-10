package fr.usmb.m1isc.compilation.tp.arbres;

import fr.usmb.m1isc.compilation.tp.ArbreAbstrait;

public class ArbreLet extends ArbreAbstrait {
    public ArbreLet(ArbreAbstrait fils1, ArbreAbstrait fils2, ArbreAbstrait fils3){
        super(fils1, fils2, fils3);
    }

    @Override
    public void genererCodeAssembleur(String fileToGenerate) {

    }
}
