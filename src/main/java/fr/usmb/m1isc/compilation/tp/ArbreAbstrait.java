package fr.usmb.m1isc.compilation.tp;

import fr.usmb.m1isc.compilation.tp.outils_fichier.FileTools;

public abstract class ArbreAbstrait {
    // Fils de l'arbre
    protected ArbreAbstrait fils1;
    protected ArbreAbstrait fils2;
    protected ArbreAbstrait fils3;

    // Indique si le noeud est une feuille (utilisé pour l'affichage)
    private boolean estFeuille;

    // Indique si l'arbre contient des erreurs (si c'est le cas on empêche la génération de l'assembleur)
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

    public void genererAssembleur(String nomFichier){
        if (contientErreurs())  // Si il y a des erreurs inutile de générer l'assembleur
            System.out.println("On ne peut pas generer le code assembleur, il y a des erreurs dans le code");

        //Génération des déclarations
        DataSegment dataSegment = new DataSegment();
        genereDeclarations(dataSegment);

        //Génération des instruction
        CodeSegment codeSegment = new CodeSegment();
        genereInstructions(codeSegment);

        // Ecriture du code dans un fichier
        String code = dataSegment.toString() + codeSegment.toString();
        FileTools.writeStringIntoFile(nomFichier, code);
    }

    // Indique si l'arbre contient des erreurs
    private boolean contientErreurs() {
        if (contientErreurs == null) // Si on a jamais cherché s'il contenait des erreurs, on regarde si les fils en contiennent
            contientErreurs = ((fils1 != null && fils1.contientErreurs()) || (fils2 != null && fils2.contientErreurs()) || (fils3!= null && fils3.contientErreurs()));
        return contientErreurs;
    }

    // Génère les instruction pour le noeud courant de l'arbre (la génération des fils sera appelée dans cette fonction, à différents endroit selon le type de noeud
    public abstract void genereInstructions(CodeSegment codeSegment);

    // Génère les déclaration pour le noeud courant de l'arbre (la génération des fils sera éventuellement appelée dans cette fonction, à différents endroit selon le type de noeud
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

    // Retourne sous forme de String la valeur à afficher pour le noeud courant
    protected abstract String valeurToString();
}

