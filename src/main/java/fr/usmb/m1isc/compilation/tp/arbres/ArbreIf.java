package fr.usmb.m1isc.compilation.tp.arbres;

import fr.usmb.m1isc.compilation.tp.ArbreAbstrait;
import fr.usmb.m1isc.compilation.tp.CodeSegment;
import fr.usmb.m1isc.compilation.tp.DataSegment;

public class ArbreIf extends ArbreAbstrait {
    public ArbreIf(ArbreAbstrait f1, ArbreAbstrait f2, ArbreAbstrait f3) {
        super(f1, f2, f3);
    }

    @Override
    public void genereInstructions(CodeSegment codeSegment) {
        int numero = codeSegment.nouveauIf();
        fils1.genereInstructions(codeSegment);
        codeSegment.add(CodeSegment.Operateur.jz, CodeSegment.Operateur.debut_else.name() + "_" + numero);
        fils2.genereInstructions(codeSegment);
        codeSegment.add(CodeSegment.Operateur.jmp, CodeSegment.Operateur.sortie_if.name() + "_" + numero);
        codeSegment.add(CodeSegment.Operateur.debut_else, String.valueOf(numero));
        fils3.genereInstructions(codeSegment);
        codeSegment.add(CodeSegment.Operateur.sortie_if, String.valueOf(numero));
    }

    @Override
    public void genereDeclarations(DataSegment dataSegment) {
        fils2.genereDeclarations(dataSegment);
        fils3.genereDeclarations(dataSegment);
    }

    @Override
    protected String valeurToString() {
        return "IF";
    }
}
