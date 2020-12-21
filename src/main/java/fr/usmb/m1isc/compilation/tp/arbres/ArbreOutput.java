package fr.usmb.m1isc.compilation.tp.arbres;

import fr.usmb.m1isc.compilation.tp.ArbreAbstrait;
import fr.usmb.m1isc.compilation.tp.CodeSegment;

public class ArbreOutput extends ArbreAbstrait {
    public String valeur;

    public ArbreOutput(ArbreAbstrait valeur){
        super();
        //this.valeur = valeur;
    }

    @Override
    public void genereInstructions(CodeSegment codeSegment) {
    }

    @Override
    protected String valeurToString() {
        return null;
    }
}