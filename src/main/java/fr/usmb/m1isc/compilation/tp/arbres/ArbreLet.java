package fr.usmb.m1isc.compilation.tp.arbres;

import fr.usmb.m1isc.compilation.tp.ArbreAbstrait;
import fr.usmb.m1isc.compilation.tp.DataSegment;

public class ArbreLet extends ArbreAbstrait {
    public ArbreLet(ArbreAbstrait fils1, ArbreAbstrait fils2){
        super(fils1, fils2);
    }

    @Override
    public String genereInstructions() {
        String res = fils2.genereInstructions();
        res += "\tpop eax\n";
        res += "\tmov " + ((ArbreIdent)fils1).valeur + ", eax\n";
        res += "\tpush eax\n";
        return res;
    }

    @Override
    public void genereDeclarations(DataSegment dataSegment) {
        dataSegment.add(((ArbreIdent)fils1).valeur);
    }

    @Override
    protected String valeurToString() {
        return "LET";
    }
}
