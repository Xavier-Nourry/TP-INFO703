package fr.usmb.m1isc.compilation.tp.arbres;

import fr.usmb.m1isc.compilation.tp.ArbreAbstrait;
import fr.usmb.m1isc.compilation.tp.CodeSegment;

public class ArbreEgal extends ArbreAbstrait {
    private ArbreEntier e1;
    private ArbreEntier e2;

    public ArbreEgal(ArbreAbstrait e1, ArbreAbstrait e2) { //TODO : constructeur à vérifier
        this.e1 = (ArbreEntier) e1;
        this.e2 = (ArbreEntier) e2;
    }

    @Override
    public void genereInstructions(CodeSegment codeSegment) {
        String res = "\tmov eax "+ e1.valeur +"\n";
        res += "\tmov ebx "+ e2.valeur +"\n";
        res += "\tsub eax ebx\n";
        res += "\tjz egal_retourne_vrai\n";
        res += "\tmov ebx 0\n";
        res += "\tpush ebx\n";
        res += "\tegal_retourne_vrai:\n";
        res += "\t\tmov ebx 1\n";
        res += "\t\tpush ebx\n"; //TODO : voir si nécessaire de 'pop' des registres

        return res;
    }

    @Override
    protected String valeurToString() {
        return null;
    }
}
