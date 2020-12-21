package fr.usmb.m1isc.compilation.tp.arbres;

import fr.usmb.m1isc.compilation.tp.ArbreAbstrait;
import fr.usmb.m1isc.compilation.tp.CodeSegment;
import fr.usmb.m1isc.compilation.tp.DataSegment;

public class ArbreWhile extends ArbreAbstrait {
    public ArbreWhile(ArbreAbstrait f1, ArbreAbstrait f2) {
        super(f1, f2);
    }

    @Override
    public void genereInstructions(CodeSegment codeSegment) {
        int numero = codeSegment.nouveauWhile();
        codeSegment.add(CodeSegment.Operateur.debut_while, String.valueOf(numero));
        fils1.genereInstructions(codeSegment);
        codeSegment.add(CodeSegment.Operateur.jz, CodeSegment.Operateur.sortie_while.name() + "_" + numero);
        fils2.genereInstructions(codeSegment);
        codeSegment.add(CodeSegment.Operateur.jmp, CodeSegment.Operateur.debut_while.name() + "_" + numero);
        codeSegment.add(CodeSegment.Operateur.sortie_while, String.valueOf(numero));
    }

    @Override
    public void genereDeclarations(DataSegment dataSegment) {
        fils2.genereDeclarations(dataSegment);
    }


    @Override
    protected String valeurToString() {
        return "WHILE";
    }
}
