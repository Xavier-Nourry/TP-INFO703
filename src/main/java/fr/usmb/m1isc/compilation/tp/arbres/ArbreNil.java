package fr.usmb.m1isc.compilation.tp.arbres;

import fr.usmb.m1isc.compilation.tp.ArbreAbstrait;

public class ArbreNil extends ArbreAbstrait {
    public ArbreNil(){
        super();
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