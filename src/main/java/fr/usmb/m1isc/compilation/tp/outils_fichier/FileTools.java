package fr.usmb.m1isc.compilation.tp.outils_fichier;

import java.io.FileWriter;
import java.io.IOException;

public class FileTools {
    public static void writeStringIntoFile(String fileName, String toWrite){
        try {
            FileWriter myWriter = new FileWriter("./" + fileName);
            myWriter.write(toWrite);
            myWriter.close();
            System.out.println("L'assembleur a bien ete ecrit dans le fichier " + fileName);
        } catch (IOException e) {
            System.out.println("Une erreur est survenue lors de l'écriture du fichier");
            e.printStackTrace();
        }
    }
}
