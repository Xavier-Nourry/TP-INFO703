package fr.usmb.m1isc.compilation.tp.outils_fichier;

import java.io.FileWriter;
import java.io.IOException;

public class FileTools { //TODO : cette classe devrait être static mais l'IDE ne veut pas ¯\_('_')_/¯
    public static void writeStringIntoFile(String fileName, String toWrite){
        try {
            FileWriter myWriter = new FileWriter("./" + fileName);
            myWriter.write(toWrite);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
