package fr.usmb.m1isc.compilation.tp.arbres;

import fr.usmb.m1isc.compilation.tp.ArbreAbstrait;
import fr.usmb.m1isc.compilation.tp.CodeSegment;

public class ArbreAnd extends ArbreAbstrait {

    public ArbreAnd(ArbreAbstrait f1, ArbreAbstrait f2) {
        super(f1, f2);
    }

    @Override
    public void genereInstructions(CodeSegment codeSegment) {
        int numero = codeSegment.nouveauAnd();
        fils1.genereInstructions(codeSegment);
        codeSegment.add(CodeSegment.Operateur.jz, CodeSegment.Operateur.faux_and.name() + "_" + numero);
        fils2.genereInstructions(codeSegment);
        codeSegment.add(CodeSegment.Operateur.jz, CodeSegment.Operateur.faux_and.name() + "_" + numero);
        codeSegment.add(CodeSegment.Operateur.mov, "eax, 1");
        codeSegment.add(CodeSegment.Operateur.jmp, CodeSegment.Operateur.sortie_and.name() + "_" + numero);
        codeSegment.add(CodeSegment.Operateur.faux_and, String.valueOf(numero));
        codeSegment.add(CodeSegment.Operateur.mov, "eax, 0");
        codeSegment.add(CodeSegment.Operateur.sortie_and, String.valueOf(numero));
    }

    @Override
    protected String valeurToString() { return "AND"; }
}
