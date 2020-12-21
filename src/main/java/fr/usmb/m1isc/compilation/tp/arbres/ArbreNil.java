package fr.usmb.m1isc.compilation.tp.arbres;

import fr.usmb.m1isc.compilation.tp.ArbreAbstrait;
import fr.usmb.m1isc.compilation.tp.CodeSegment;

public class ArbreNil extends ArbreAbstrait {
    public ArbreNil(){
        super();
    }

    @Override
    public void genereInstructions(CodeSegment codeSegment) {
    }

    @Override
    protected String valeurToString() {
        return null;
    }
}