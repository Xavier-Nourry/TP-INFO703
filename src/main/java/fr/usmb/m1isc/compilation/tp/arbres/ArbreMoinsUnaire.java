package fr.usmb.m1isc.compilation.tp.arbres;

import fr.usmb.m1isc.compilation.tp.ArbreAbstrait;
import fr.usmb.m1isc.compilation.tp.CodeSegment;

public class ArbreMoinsUnaire extends ArbreAbstrait {
    public ArbreMoinsUnaire(ArbreAbstrait fils1){
        super(fils1);
    }

    @Override
    public void genereInstructions(CodeSegment codeSegment) {
        fils1.genereInstructions(codeSegment);
        codeSegment.add(CodeSegment.Operateur.pop, "ebx");
        codeSegment.add(CodeSegment.Operateur.mov, "eax, 0");
        codeSegment.add(CodeSegment.Operateur.sub, "eax, ebx");
        codeSegment.add(CodeSegment.Operateur.push, "eax");
    }

    @Override
    protected String valeurToString() {
        return "-";
    }
}