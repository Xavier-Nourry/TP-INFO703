package fr.usmb.m1isc.compilation.tp;
import java.util.ArrayList;

public class CodeSegment {
    public static class Instruction{
        private final Operateur operateur;
        private final String operandes; //TODO faudra peut-être changer ça si on veut optimiser

        public Instruction(Operateur operateur, String operandes) {
            this.operateur = operateur;
            this.operandes = operandes;
        }

        @Override
        public String toString() {
            switch (operateur) {
                case debut_while:
                case faux_gt:
                case sortie_gt:
                case faux_gte:
                case sortie_gte:
                case sortie_while:
                case debut_else:
                case sortie_if:
                    return operateur.name() + "_" + operandes + ":";
                default:
                    return "\t" + operateur.name() + " " + operandes;
            }
        }
    }

    public enum Operateur{div, push, mov, mul, sub, add, in, debut_while, jz, sortie_while, jmp, jle, faux_gt, sortie_gt, out, jl, faux_gte, sortie_gte, debut_else, sortie_if, pop}

    ArrayList<Instruction> instructions;
    private int nbWhile;
    private int nbGt;
    private int nbGte;
    private int nbIf;

    public CodeSegment() {
        instructions = new ArrayList<>();
        nbWhile = 0;
        nbGt = 0;
        nbGte = 0;
        nbIf = 0;
    }

    public void add(Operateur op, String operandes){
        //TODO ajouter de quoi optimiser
        instructions.add(new Instruction(op, operandes));
    }

    public int nouveauWhile() {
        return ++nbWhile;
    }

    public int nouveaugt() {
        return ++nbGt;
    }

    public int nouveaugte() {
        return ++nbGte;
    }

    public int nouveauIf() {
        return ++nbIf;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder("CODE SEGMENT\n");
        for (Instruction instruction : instructions)
            res.append(instruction.toString()).append("\n");
        res.append("CODE ENDS\n");
        return res.toString();
    }
}
