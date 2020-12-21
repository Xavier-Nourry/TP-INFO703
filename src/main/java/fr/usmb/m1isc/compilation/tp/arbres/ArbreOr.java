package fr.usmb.m1isc.compilation.tp.arbres;

import fr.usmb.m1isc.compilation.tp.ArbreAbstrait;

public class ArbreOr extends ArbreAbstrait {
    private ArbreEntier fils1;
    private ArbreEntier fils2;

    public ArbreOr(ArbreAbstrait fils1, ArbreAbstrait fils2){ //TODO : constructeur à vérifier
        this.fils1 = (ArbreEntier) fils1;
        this.fils2 = (ArbreEntier) fils2;
    }

    @Override
    public String genereInstructions() {
        String res = "\tmov eax "+ fils1.valeur +"\n";
        res += "\tpush eax\n";
        res += "\tjnz or_retourne_vrai\n";
        res += "\tmov ebx "+ fils2.valeur +"\n";
        res += "\tpush ebx\n";
        res += "\tjnz or_retourne_vrai\n";
        res += "\tpush 0\n";
        res += "\tor_retourne_vrai:\n";
        res += "\t\tpush 1\n"; //TODO : voir si nécessaire de 'pop ebx'

        return res;
    }

    @Override
    protected String valeurToString() {
        return null;
    }
}