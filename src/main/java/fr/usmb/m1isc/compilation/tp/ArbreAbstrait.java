package fr.usmb.m1isc.compilation.tp;

public abstract class ArbreAbstrait {
    // Fils de l'arbre
    protected ArbreAbstrait fils1;
    protected ArbreAbstrait fils2;
    protected ArbreAbstrait fils3;

    // Indique si au le noeud est une feuille (utilisé pour l'affichage)
    private boolean estFeuille;
    protected Boolean contientErreurs;

    // On fait différents constructeurs selon le nombre de fils
    public ArbreAbstrait(){
        this(null, null, null);
        estFeuille = true; // Vient corriger l'affectation faire par le constructeur appelé avant
    }

    public ArbreAbstrait(ArbreAbstrait fils1) {this(fils1, null, null);}

    public ArbreAbstrait(ArbreAbstrait fils1, ArbreAbstrait fils2) {this(fils1, fils2, null);}

    public ArbreAbstrait(ArbreAbstrait fils1, ArbreAbstrait fils2, ArbreAbstrait fils3) {
        this.fils1 = fils1;
        this.fils2 = fils2;
        this.fils3 = fils3;
        estFeuille = false;
    }

    public String genererAssembleur(){
        if (contientErreurs()) {
            System.out.println("On ne peut pas generer le code assembleur, il y a des erreurs dans le code");
            return "";
        }
        //Génération des déclarations
        DataSegment dataSegment = new DataSegment();
        genereDeclarations(dataSegment);

        //Génération des instruction
        CodeSegment codeSegment = new CodeSegment();
        genereInstructions(codeSegment);

        return dataSegment.toString() + codeSegment.toString();
    }

    private boolean contientErreurs() {
        if (contientErreurs == null)
            contientErreurs = ((fils1 != null && fils1.contientErreurs()) || (fils2 != null && fils2.contientErreurs()) || (fils3!= null && fils3.contientErreurs()));
        return contientErreurs;
    }

    public abstract void genereInstructions(CodeSegment codeSegment);

    public void genereDeclarations(DataSegment dataSegment){}

    // Affiche l'arbre sous la forme d'une expression préfixée parenthésée
    public String toString(){
        String res = valeurToString() + " ";
        if (fils1 != null)
            res += fils1.toString();
        if (fils2 != null)
            res += fils2.toString();
        if (fils3 != null)
            res += fils3.toString();
        if (!estFeuille)
            res = "(" + res + ")";
        return res;
    }

    protected abstract String valeurToString();
}

