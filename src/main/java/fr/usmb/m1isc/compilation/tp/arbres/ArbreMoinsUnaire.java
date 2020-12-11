package fr.usmb.m1isc.compilation.tp.arbres;

import fr.usmb.m1isc.compilation.tp.ArbreAbstrait;
import fr.usmb.m1isc.compilation.tp.CodeSegment;

public class ArbreMoinsUnaire extends ArbreAbstrait {
    public ArbreMoinsUnaire(ArbreAbstrait fils1){
        super(fils1);
    }

    @Override
    public void genereInstructions(CodeSegment codeSegment) {
        String res = fils1.genereInstructions(codeSegment);
        res += "\tpop ebx\n";
        res += "\tmov eax, 0\n";
        res += "\tsub eax, ebx\n";
        res += "\tpush eax\n";
        return res;
    }

    @Override
    protected String valeurToString() {
        return "-";
    }
}