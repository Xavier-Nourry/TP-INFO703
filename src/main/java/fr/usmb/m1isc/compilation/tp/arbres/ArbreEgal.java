package fr.usmb.m1isc.compilation.tp.arbres;

import fr.usmb.m1isc.compilation.tp.ArbreAbstrait;
import fr.usmb.m1isc.compilation.tp.CodeSegment;

public class ArbreEgal extends ArbreAbstrait {
    public ArbreEgal(ArbreAbstrait f1, ArbreAbstrait f2) {
        super(f1, f2);
    }

    @Override
    public void genereInstructions(CodeSegment codeSegment) {
        int numero = codeSegment.nouveauEgal();
        new ArbreMoins(fils2, fils1).genereInstructions(codeSegment);
        codeSegment.add(CodeSegment.Operateur.pop, "eax");
        codeSegment.add(CodeSegment.Operateur.jnz, CodeSegment.Operateur.faux_egal.name() + "_" + numero);
        codeSegment.add(CodeSegment.Operateur.mov, "eax, 1");
        codeSegment.add(CodeSegment.Operateur.jmp, CodeSegment.Operateur.sortie_egal.name() + "_" + numero);
        codeSegment.add(CodeSegment.Operateur.faux_egal, String.valueOf(numero));
        codeSegment.add(CodeSegment.Operateur.mov, "eax, 0");
        codeSegment.add(CodeSegment.Operateur.sortie_egal, String.valueOf(numero));
    }

    @Override
    protected String valeurToString() {
        return null;
    }
}
