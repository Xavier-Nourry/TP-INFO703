package fr.usmb.m1isc.compilation.tp.arbres;

import fr.usmb.m1isc.compilation.tp.ArbreAbstrait;
import fr.usmb.m1isc.compilation.tp.CodeSegment;

public class ArbreGTE extends ArbreAbstrait {
    public ArbreGTE(ArbreAbstrait f1, ArbreAbstrait f2) {
        super(f1, f2);
    }

    @Override
    public void genereInstructions(CodeSegment codeSegment) {
        int numero = codeSegment.nouveaugte();
        new ArbreMoins(fils2, fils1).genereInstructions(codeSegment);
        codeSegment.add(CodeSegment.Operateur.pop, "eax");
        codeSegment.add(CodeSegment.Operateur.jl, CodeSegment.Operateur.faux_gte.name() + "_" + numero);
        codeSegment.add(CodeSegment.Operateur.mov, "eax, 1");
        codeSegment.add(CodeSegment.Operateur.jmp, CodeSegment.Operateur.sortie_gte.name() + "_" + numero);
        codeSegment.add(CodeSegment.Operateur.faux_gte, String.valueOf(numero));
        codeSegment.add(CodeSegment.Operateur.mov, "eax, 0");
        codeSegment.add(CodeSegment.Operateur.sortie_gte, String.valueOf(numero));
    }

    @Override
    protected String valeurToString() {
        return "<=";
    }
}
