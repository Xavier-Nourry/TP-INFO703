package fr.usmb.m1isc.compilation.tp.arbres;

import fr.usmb.m1isc.compilation.tp.ArbreAbstrait;

public class ArbreDiv extends ArbreAbstrait {
    public ArbreDiv(ArbreAbstrait f1, ArbreAbstrait f2){
        super(f1, f2);
    }

    @Override
    public String genereInstructions() {
        String res = fils1.genereInstructions();
        res += fils2.genereInstructions();
        res += "\tpop ebx\n";
        res += "\tpop eax\n";
        res += "\tdiv eax, ebx\n";
        res += "\tpush eax\n";
        return res;
    }

    @Override
    protected String valeurToString() {
        return "/";
    }

}
