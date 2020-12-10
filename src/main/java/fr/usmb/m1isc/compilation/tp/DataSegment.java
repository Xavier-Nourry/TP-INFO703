package fr.usmb.m1isc.compilation.tp;

import java.util.ArrayList;

public class DataSegment {
    ArrayList <String> declarations;
    public DataSegment() {
        declarations = new ArrayList<>();
    }

    public void add(String declaration){
        //TODO ajouter de quoi vérifier que la variable a pas déjà été déclarée
        declarations.add(declaration);
    }

    @Override
    public String toString() {
        String res = "DATA SEGMENT\n";
        for (int i = 0; i < declarations.size(); i++)
            res += "\t" + declarations.get(i) + " DD\n";
        res += "DATA ENDS\n";
        return res;
    }
}
