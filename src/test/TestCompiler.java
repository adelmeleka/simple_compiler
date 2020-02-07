package test;

import java.io.FileNotFoundException;
import java.util.Arrays;
import lexicalAnalysis.LexicalAnalyser;
import lexicalAnalysis.Token;
import CodeGenerator.CodeGenerator;
import parser.Parser;

public class TestCompiler {
	public static String fileName;
	 
	public static void main(String[] args) throws FileNotFoundException {
		
		 fileName = args[0].substring(0, args[0].length()-4);
		 
		
		//1. Lexical Analysis
		
		Token.readTokenCoding();
		
		
		long start = System.currentTimeMillis();
		
		LexicalAnalyser.readInputProg(args[0]);
		
		LexicalAnalyser.tokenStreams();
		//Print Lexical table
		System.out.println("\n >LEXICAL TABLE<");
		int count =0;
		 for (String[] row : LexicalAnalyser.tokenStreams) {
		        System.out.println(count+" Row = " + Arrays.toString(row));
		        count ++;
		 }
		 
		
		 //2. Parsing
		 //el moshkela fe EXP class fe parser package
		Parser.tokensStreamLoop();
		
		
		//3. Code Generation
		
		CodeGenerator.generateCode();
		
		long finish = System.currentTimeMillis();

		
		//Print Time taken
		int time = (int)(finish - start);
		System.out.println("\n >TIME TAKEN<\n" +String.valueOf(time) +"ms");
		
			
		
	}

}
