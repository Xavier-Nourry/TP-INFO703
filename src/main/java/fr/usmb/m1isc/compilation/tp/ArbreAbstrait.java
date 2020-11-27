package fr.usmb.m1isc.compilation.tp;

public class ArbreAbstrait {
    private ArbreAbstrait filsGauche;
    private ArbreAbstrait filsDroit;
    private String valeur;

    public ArbreAbstrait(String valeur){
        this(valeur, null, null);
    }

    public ArbreAbstrait(String valeur, ArbreAbstrait filsGauche, ArbreAbstrait filsDroit) {
        this.valeur = valeur;
        this.filsGauche = filsGauche;
        this.filsDroit = filsDroit;
    }

    public String toString(){
        String res = valeur;
        if (filsGauche != null)
            res += filsGauche.toString();
        if (filsDroit != null)
            res += filsDroit.toString();
        return res;
    }
}
