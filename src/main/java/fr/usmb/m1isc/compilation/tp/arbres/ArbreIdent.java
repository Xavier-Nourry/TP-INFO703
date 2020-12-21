package fr.usmb.m1isc.compilation.tp.arbres;

import fr.usmb.m1isc.compilation.tp.ArbreAbstrait;
import fr.usmb.m1isc.compilation.tp.CodeSegment;

public class ArbreIdent extends ArbreAbstrait {
    public String valeur;
    public ArbreIdent(String valeur){
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
        return valeur;
    }
}