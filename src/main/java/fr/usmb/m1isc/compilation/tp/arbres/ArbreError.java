package fr.usmb.m1isc.compilation.tp.arbres;

import fr.usmb.m1isc.compilation.tp.ArbreAbstrait;
import fr.usmb.m1isc.compilation.tp.CodeSegment;

public class ArbreError extends ArbreAbstrait {
    public ArbreError(){
        super();
        contientErreurs = true;
    }

    @Override
    public void genereInstructions(CodeSegment codeSegment) {}

    @Override
    protected String valeurToString() {
        return "ERREUR";
    }
}
