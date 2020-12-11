package fr.usmb.m1isc.compilation.tp.arbres;

import fr.usmb.m1isc.compilation.tp.ArbreAbstrait;
import fr.usmb.m1isc.compilation.tp.CodeSegment;

public class ArbreEntier extends ArbreAbstrait{
    public int valeur;

    public ArbreEntier(int valeur) {
        super();
        this.valeur = valeur;
    }

    @Override
    public void genereInstructions(CodeSegment codeSegment) {
        codeSegment.add(CodeSegment.Operateur.mov, "eax, " + valeur);
        codeSegment.add(CodeSegment.Operateur.push, "eax");
    }

    @Override
    protected String valeurToString() {
        return String.valueOf(valeur);
    }
}
