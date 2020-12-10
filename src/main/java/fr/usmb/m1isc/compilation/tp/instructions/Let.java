package fr.usmb.m1isc.compilation.tp.instructions;

public class Let extends Instruction{
    private String[] arguments;

    public Let(String idVariable, String valeur){
        arguments = new String[] {idVariable, valeur};
    }

    @Override
    public String genererCodeAssembleur() {
        String res = "";



        return res;
    }
}
