package fr.usmb.m1isc.compilation.tp.arbres;

import fr.usmb.m1isc.compilation.tp.ArbreAbstrait;
import fr.usmb.m1isc.compilation.tp.CodeSegment;

public class ArbreNot extends ArbreAbstrait {
    public int valeur;

    public ArbreNot(ArbreAbstrait tree){ //TODO : constructeur à vérifier
        this.valeur = ((ArbreEntier)tree).valeur;
    }

    @Override
    public void genereInstructions(CodeSegment codeSegment) {
        String res = "\tmov eax "+ valeur +"\n";
        res += "\tpush eax\n";
        res += "\tjz not_retourne_vrai\n";
        res += "\tpush 0\n";
        res += "\tnot_retourne_vrai:\n";
        res += "\t\tpush 1\n"; //TODO : voir si nécessaire de 'pop' des registres

        return res;
    }

    @Override
    protected String valeurToString() {
        return null;
    }
}