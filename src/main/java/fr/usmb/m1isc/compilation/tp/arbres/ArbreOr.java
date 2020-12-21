package fr.usmb.m1isc.compilation.tp.arbres;

import fr.usmb.m1isc.compilation.tp.ArbreAbstrait;
import fr.usmb.m1isc.compilation.tp.CodeSegment;

public class ArbreOr extends ArbreAbstrait {
    public ArbreOr(ArbreAbstrait fils1, ArbreAbstrait fils2){
        super(fils1, fils2);
    }

    @Override
    public void genereInstructions(CodeSegment codeSegment) {
    }

    @Override
    protected String valeurToString() {
        return null;
    }
}