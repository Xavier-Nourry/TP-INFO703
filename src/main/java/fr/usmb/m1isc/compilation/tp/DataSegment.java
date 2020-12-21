package fr.usmb.m1isc.compilation.tp;

import java.util.ArrayList;

public class DataSegment {
    ArrayList <String> declarations;
    public DataSegment() {
        declarations = new ArrayList<>();
    }

    public void add(String declaration){
        if (!declarations.contains(declaration))
            declarations.add(declaration);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder("DATA SEGMENT\n");
        for (String declaration : declarations)
            res.append("\t").append(declaration).append(" DD\n");
        res.append("DATA ENDS\n");
        return res.toString();
    }
}
