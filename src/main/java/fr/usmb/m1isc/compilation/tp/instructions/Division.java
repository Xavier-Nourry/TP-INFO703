package fr.usmb.m1isc.compilation.tp.instructions;

public class Division extends Instruction{
    private int[] arguments;

    public Division(int nb1, int nb2){
        arguments = new int[] {nb1, nb2};
    }

    @Override
    public String genererCodeAssembleur() {
        return null; //TODO
    }
}
