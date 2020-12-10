package fr.usmb.m1isc.compilation.tp;

public class ArbreAbstrait {
    // Fils de l'arbre
    private ArbreAbstrait fils1;
    private ArbreAbstrait fils2;
    private ArbreAbstrait fils3;
    // Valeur du noeud
    private String valeur;
    // Indique si au le noeud est une feuille (utilisé pour l'affichage)
    private boolean estFeuille;

    // On fait différents constructeurs selon le nombre de fils
    public ArbreAbstrait(String valeur){
        this(valeur, null, null, null);
        estFeuille = true; // Vient corriger l'affectation faire par le constructeur appelé avant
    }

    public ArbreAbstrait(String valeur, ArbreAbstrait fils1) {this(valeur, fils1, null, null);}

    public ArbreAbstrait(String valeur, ArbreAbstrait fils1, ArbreAbstrait fils2) {this(valeur, fils1, fils2, null);}

    public ArbreAbstrait(String valeur, ArbreAbstrait fils1, ArbreAbstrait fils2, ArbreAbstrait fils3) {
        this.valeur = valeur;
        this.fils1 = fils1;
        this.fils2 = fils2;
        this.fils3 = fils3;
        estFeuille = false;
    }

    // Affiche l'arbre sous la forme d'une expression préfixée parenthésée
    public String toString(){
        String res = valeur + " ";
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

    public String toAsm(){
        String dataSegment = "DATA SEGMENT\n";
        String codeSegment = "CODE SEGMENT\n";

        //Génération des instructions
        codeSegment += genereInstructions();

        dataSegment += "DATA ENDS\n";
        codeSegment += "CODE ENDS";
        return dataSegment + codeSegment;
    }

    private String genereInstructions() {
        switch(valeur) {
            case ";":
                return InstructionsPointVirgule();
            case "LET":
                return InstructionsLet();
            case "200":
            case "119":
            case "100":
                return InstructionsInt();
            case "/":
                return InstructionsDivison();
            case "*":
                return InstructionsMultiplication();
            default:
                return InstructionVariable();
        }
    }

    private String InstructionVariable() {
        String res = "mov eax, " + valeur + "\n";
        res += "push eax\n";
        return res;
    }

    private String InstructionsMultiplication() {
        String res = fils1.genereInstructions();
        res += fils2.genereInstructions();
        res += "pop ebx\n";
        res += "pop eax\n";
        res += "mul eax, ebx\n";
        res += "push eax\n";
        return res;
    }

    private String InstructionsDivison() {
        String res = fils1.genereInstructions();
        res += fils2.genereInstructions();
        res += "pop ebx\n";
        res += "pop eax\n";
        res += "div eax, ebx\n";
        res += "push eax\n";
        return res;
    }

    private String InstructionsInt() {
        String res = "mov eax, " + valeur + "\n";
        res += "push eax\n";
        return res;
    }

    private String InstructionsLet() {
        String res = fils2.genereInstructions();
        res += "pop eax\n";
        res += "mov " + fils1.valeur + ", eax\n";
        res += "push eax\n";
        return res;
    }

    private String InstructionsPointVirgule() {
        String res = fils1.genereInstructions();
        res += "pop eax\n";
        res += fils2.genereInstructions();
        return res;
    }
}
