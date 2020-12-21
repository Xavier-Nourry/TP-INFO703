package fr.usmb.m1isc.compilation.tp;

import fr.usmb.m1isc.compilation.tp.outils_fichier.FileTools;

import java.io.FileReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception  {
		 LexicalAnalyzer yy;
		 if (args.length > 0)
		        yy = new LexicalAnalyzer(new FileReader(args[0])) ;
		    else
		        yy = new LexicalAnalyzer(new InputStreamReader(System.in)) ;
		@SuppressWarnings("deprecation")
		parser p = new parser (yy);
		ArbreAbstrait res = (ArbreAbstrait) p.parse().value;

		System.out.println("Arbre genere : \n");
		System.out.println(res.toString());
		System.out.println("\n Code assembleur genere : \n");
		FileTools.writeStringIntoFile(args[1], res.genererAssembleur());
	}
}
