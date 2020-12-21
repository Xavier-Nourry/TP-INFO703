package fr.usmb.m1isc.compilation.tp.arbres;

import fr.usmb.m1isc.compilation.tp.ArbreAbstrait;
import fr.usmb.m1isc.compilation.tp.CodeSegment;

public class ArbreMod extends ArbreAbstrait {
    public ArbreMod(ArbreAbstrait fils1, ArbreAbstrait fils2){
        super(fils1, fils2);
    }

    @Override
    public void genereInstructions(CodeSegment codeSegment) {
        fils1.genereInstructions(codeSegment);
        fils2.genereInstructions(codeSegment);
        codeSegment.add(CodeSegment.Operateur.pop, "ebx");
        codeSegment.add(CodeSegment.Operateur.pop, "eax");
        codeSegment.add(CodeSegment.Operateur.mov, "ecx, eax");
        codeSegment.add(CodeSegment.Operateur.div, "ecx, ebx");
        codeSegment.add(CodeSegment.Operateur.mul, "ecx, ebx");
        codeSegment.add(CodeSegment.Operateur.sub, "eax, ecx");
        codeSegment.add(CodeSegment.Operateur.push, "eax");
    }

    @Override
    protected String valeurToString() {
        return "MOD";
    }
}