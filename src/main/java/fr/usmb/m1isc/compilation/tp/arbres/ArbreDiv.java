package fr.usmb.m1isc.compilation.tp.arbres;

import fr.usmb.m1isc.compilation.tp.ArbreAbstrait;
import fr.usmb.m1isc.compilation.tp.CodeSegment;

public class ArbreDiv extends ArbreAbstrait {
    public ArbreDiv(ArbreAbstrait f1, ArbreAbstrait f2){
        super(f1, f2);
    }

    @Override
    public void genereInstructions(CodeSegment codeSegment) {
        fils1.genereInstructions(codeSegment);
        fils2.genereInstructions(codeSegment);
        codeSegment.add(CodeSegment.Operateur.pop, "ebx");
        codeSegment.add(CodeSegment.Operateur.pop, "eax");
        codeSegment.add(CodeSegment.Operateur.div, "eax, ebx");
        codeSegment.add(CodeSegment.Operateur.push, "eax");
    }

    @Override
    protected String valeurToString() {
        return "/";
    }

}
