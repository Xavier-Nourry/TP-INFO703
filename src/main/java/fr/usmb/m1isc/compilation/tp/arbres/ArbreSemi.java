package fr.usmb.m1isc.compilation.tp.arbres;

import fr.usmb.m1isc.compilation.tp.ArbreAbstrait;
import fr.usmb.m1isc.compilation.tp.CodeSegment;
import fr.usmb.m1isc.compilation.tp.DataSegment;

public class ArbreSemi extends ArbreAbstrait {
    public ArbreSemi(ArbreAbstrait f1, ArbreAbstrait f2) { super(f1, f2); }

    @Override
    public void genereInstructions(CodeSegment codeSegment) {
        fils1.genereInstructions(codeSegment);
        codeSegment.add(CodeSegment.Operateur.pop, "eax");
        fils2.genereInstructions(codeSegment);
    }

    @Override
    public void genereDeclarations(DataSegment dataSegment) {
        fils1.genereDeclarations(dataSegment);
        fils2.genereDeclarations(dataSegment);
    }


    @Override
    public String valeurToString() {
        return ";";
    }
}
