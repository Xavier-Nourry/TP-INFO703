package fr.usmb.m1isc.compilation.tp.arbres;

import fr.usmb.m1isc.compilation.tp.ArbreAbstrait;
import fr.usmb.m1isc.compilation.tp.CodeSegment;

public class ArbreMul extends ArbreAbstrait {
    public ArbreMul(ArbreAbstrait f1, ArbreAbstrait f2){
        super(f1, f2);
    }

    @Override
    public void genereInstructions(CodeSegment codeSegment) {
        String res = fils1.genereInstructions(codeSegment);
        res += fils2.genereInstructions(codeSegment);
        res += "\tpop ebx\n";
        res += "\tpop eax\n";
        res += "\tmul eax, ebx\n";
        res += "\tpush eax\n";
        return res;
    }

    @Override
    protected String valeurToString() {
        return "*";
    }
}
