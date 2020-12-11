package fr.usmb.m1isc.compilation.tp.arbres;

import fr.usmb.m1isc.compilation.tp.ArbreAbstrait;
import fr.usmb.m1isc.compilation.tp.CodeSegment;
import fr.usmb.m1isc.compilation.tp.DataSegment;

public class ArbreSemi extends ArbreAbstrait {
    public ArbreSemi(ArbreAbstrait f1, ArbreAbstrait f2) { super(f1, f2); }

    @Override
    public void genereInstructions(CodeSegment codeSegment) {
        String res = fils1.genereInstructions(codeSegment);
        res += "\tpop eax\n";
        res += fils2.genereInstructions(codeSegment);
        return res;
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
