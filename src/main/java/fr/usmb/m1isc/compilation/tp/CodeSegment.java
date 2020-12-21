package fr.usmb.m1isc.compilation.tp;

import java.util.ArrayList;

public class CodeSegment {
    private static class Instruction{
        private final Operateur operateur;
        private final String operandes; //TODO faudra peut-être changer ça si on veut optimiser

        public Instruction(Operateur operateur, String operandes) {
            this.operateur = operateur;
            this.operandes = operandes;
        }

        @Override
        public String toString() {
            return operateur.name() + " " + operandes;
        }
    }

    public enum Operateur{div, push, mov, mul, sub, add, pop}

    ArrayList<Instruction> instructions;
    public CodeSegment() {
        instructions = new ArrayList<>();
    }

    public void add(Operateur op, String operandes){
        //TODO ajouter de quoi optimiser
        instructions.add(new Instruction(op, operandes));
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder("CODE SEGMENT\n");
        for (Instruction instruction : instructions)
            res.append("\t").append(instruction.toString()).append("\n");
        res.append("CODE ENDS\n");
        return res.toString();
    }
}
