package fr.usmb.m1isc.compilation.tp.arbres;

import fr.usmb.m1isc.compilation.tp.ArbreAbstrait;
import fr.usmb.m1isc.compilation.tp.CodeSegment;
import fr.usmb.m1isc.compilation.tp.DataSegment;

public class ArbreLet extends ArbreAbstrait {
    public ArbreLet(ArbreAbstrait fils1, ArbreAbstrait fils2){
        super(fils1, fils2);
    }

    @Override
    public void genereInstructions(CodeSegment codeSegment) {
        fils2.genereInstructions(codeSegment);
        codeSegment.add(CodeSegment.Operateur.pop, "eax");
        codeSegment.add(CodeSegment.Operateur.mov, ((ArbreIdent)fils1).valeur + ", eax");
        codeSegment.add(CodeSegment.Operateur.push, "eax");
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
