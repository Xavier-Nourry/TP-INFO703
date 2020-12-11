package fr.usmb.m1isc.compilation.tp.arbres;

import fr.usmb.m1isc.compilation.tp.ArbreAbstrait;
import fr.usmb.m1isc.compilation.tp.CodeSegment;

public class ArbreIf extends ArbreAbstrait {
    public ArbreIf(ArbreAbstrait cond, ArbreAbstrait a1, ArbreAbstrait a2) {
    }

    @Override
    public void genereInstructions(CodeSegment codeSegment) {
    }

    @Override
    protected String valeurToString() {
        return null;
    }
}
