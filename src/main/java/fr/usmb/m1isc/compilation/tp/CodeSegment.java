package fr.usmb.m1isc.compilation.tp;

import java.util.ArrayList;

public class CodeSegment {
    private class Instruction{
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

    public enum Operateur{div, push, mov, mul, sub, pop}

    ArrayList<Instruction> instructions;
    public CodeSegment() {
        instructions = new ArrayList<Instruction>();
    }

    public void add(Operateur op, String operandes){
        //TODO ajouter de quoi optimiser
        instructions.add(new Instruction(op, operandes));
    }

    @Override
    public String toString() {
        String res = "CODE SEGMENT\n";
        for (int i = 0; i < instructions.size(); i++)
            res += "\t" + instructions.get(i).toString() + "\n";
        res += "CODE ENDS\n";
        return res;
    }
}
