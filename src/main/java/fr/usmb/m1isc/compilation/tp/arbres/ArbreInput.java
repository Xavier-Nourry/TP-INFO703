package fr.usmb.m1isc.compilation.tp.arbres;

import fr.usmb.m1isc.compilation.tp.ArbreAbstrait;
import fr.usmb.m1isc.compilation.tp.CodeSegment;

public class ArbreInput extends ArbreAbstrait {
    public ArbreInput(){
        super();
    }

    @Override
    public void genereInstructions(CodeSegment codeSegment) {
        codeSegment.add(CodeSegment.Operateur.in, "eax");
        codeSegment.add(CodeSegment.Operateur.push, "eax");
    }

    @Override
    protected String valeurToString() {
        return "INPUT";
    }

}