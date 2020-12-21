package fr.usmb.m1isc.compilation.tp.arbres;

import fr.usmb.m1isc.compilation.tp.ArbreAbstrait;
import fr.usmb.m1isc.compilation.tp.CodeSegment;

public class ArbreNot extends ArbreAbstrait {
    public ArbreNot(ArbreAbstrait f1){ //TODO : constructeur à vérifier
        super(f1);
    }

    @Override
    public void genereInstructions(CodeSegment codeSegment) {
        int numero = codeSegment.nouveauNot();
        fils1.genereInstructions(codeSegment);
        codeSegment.add(CodeSegment.Operateur.jnz, CodeSegment.Operateur.faux_not.name() + "_" + numero);
        codeSegment.add(CodeSegment.Operateur.mov, "eax, 1");
        codeSegment.add(CodeSegment.Operateur.jmp, CodeSegment.Operateur.sortie_not.name() + "_" + numero);
        codeSegment.add(CodeSegment.Operateur.faux_not, String.valueOf(numero));
        codeSegment.add(CodeSegment.Operateur.mov, "eax, 0");
        codeSegment.add(CodeSegment.Operateur.sortie_not, String.valueOf(numero));
    }

    @Override
    protected String valeurToString() {
        return "NOT";
    }
}