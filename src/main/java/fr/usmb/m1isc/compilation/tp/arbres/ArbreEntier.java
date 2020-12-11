package fr.usmb.m1isc.compilation.tp.arbres;

import fr.usmb.m1isc.compilation.tp.ArbreAbstrait;

public class ArbreEntier extends ArbreAbstrait{
    public int valeur;

    public ArbreEntier(int valeur) {
        super();
        this.valeur = valeur;
    }

    @Override
    public String genereInstructions() {
        String res = "\tmov eax, " + valeur + "\n";
        res += "\tpush eax\n";
        return res;
    }

    @Override
    protected String valeurToString() {
        return String.valueOf(valeur);
    }
}
