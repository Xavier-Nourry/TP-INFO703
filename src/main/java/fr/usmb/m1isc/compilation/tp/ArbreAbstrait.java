package fr.usmb.m1isc.compilation.tp;

public class ArbreAbstrait {
    private ArbreAbstrait fils1;
    private ArbreAbstrait fils2;
    private ArbreAbstrait fils3;
    private String valeur;

    public ArbreAbstrait(String valeur){
        this(valeur, null, null, null);
    }

    public ArbreAbstrait(String valeur, ArbreAbstrait fils1) {this(valeur, fils1, null, null);}

    public ArbreAbstrait(String valeur, ArbreAbstrait fils1, ArbreAbstrait fils2) {this(valeur, fils1, fils2, null);}

    public ArbreAbstrait(String valeur, ArbreAbstrait fils1, ArbreAbstrait fils2, ArbreAbstrait fils3) {
        this.valeur = valeur;
        this.fils1 = fils1;
        this.fils2 = fils2;
        this.fils3 = fils3;
    }

    public String toString(){
        String res = valeur;
        if (fils1 != null)
            res += fils1.toString();
        if (fils2 != null)
            res += fils2.toString();
        if (fils3 != null)
            res += fils3.toString();
        return res;
    }
}
