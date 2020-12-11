package fr.usmb.m1isc.compilation.tp.arbres;

import fr.usmb.m1isc.compilation.tp.ArbreAbstrait;

public class ArbreMod extends ArbreAbstrait {
    public ArbreMod(ArbreAbstrait fils1, ArbreAbstrait fils2){
        super(fils1, fils2);
    }

    @Override
    public String genereInstructions() {
        String res = fils1.genereInstructions();
        res += fils2.genereInstructions();
        res += "\tpop ebx\n";
        res += "\tpop eax\n";
        res += "\tmov ecx, eax\n";
        res += "\tdiv ecx, ebx\n";
        res += "\tmul ecx, ebx\n";
        res += "\tsub eax, ecx\n";
        res += "\tpush eax\n";
        return res;
    }

    @Override
    protected String valeurToString() {
        return "MOD";
    }
}