package fr.usmb.m1isc.compilation.tp.arbres;

import fr.usmb.m1isc.compilation.tp.ArbreAbstrait;
import fr.usmb.m1isc.compilation.tp.CodeSegment;

public class ArbreOutput extends ArbreAbstrait {
    public ArbreOutput(ArbreAbstrait f1){
        super(f1);
    }

    @Override
    public void genereInstructions(CodeSegment codeSegment) {
        fils1.genereInstructions(codeSegment);
        codeSegment.add(CodeSegment.Operateur.pop, "eax");
        codeSegment.add(CodeSegment.Operateur.out, "eax");
    }

    @Override
    protected String valeurToString() {
        return "OUTPUT";
    }
}