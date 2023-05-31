package br.com.arcatalog.parser.app.vb6;


import java.io.FileNotFoundException;
import java.io.IOException;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import br.com.arcatalog.parser.vb6.Vb6Lexer;
import br.com.arcatalog.parser.vb6.Vb6Parser;


public class TestaInventoryVb {

public static void main(String[] args) throws FileNotFoundException, IOException {

//	String fileName = "C:\\Users\\josez\\eclipse-workspace_2303_03\\parser-vb\\src\\test\\resources\\R1FAB001.FRM";
	parseVb();
	}

   private static void parseVb() throws IOException { 
	   CharStream codePointCharStream = CharStreams.fromFileName("C:\\Users\\josez\\eclipse-workspace_2303_03\\parser-vb\\src\\test\\resources\\R1FAB001.FRM");
	   Vb6Lexer lexer = new br.com.arcatalog.parser.vb6.Vb6Lexer(codePointCharStream);
	   Vb6Parser parser = new Vb6Parser(new CommonTokenStream(lexer));

	   // Start parsing
	   ParseTree tree = parser.startRule();
	   
//		ParseTreeWalker walker = new ParseTreeWalker();
		ParserInventory parseInventory = new ParserInventory();
       
//		if(!defCompUnit.IsValidCompUnit()) return defCompUnit.getSymbolTable();
		

	    ParseTreeWalker walker = new ParseTreeWalker();
	    walker.walk(parseInventory,tree);
   }
	
//    private static void ParseVb6(File _file) throws IOException{
//    	File f = _file;
//    	String fileName = f.getAbsolutePath();
//    	System.err.println(fileName);
//    	InputStream  is = new FileInputStream(f);
//        ANTLRInputStream input = new ANTLRInputStream(is);
//        VisualBasic6Lexer lexer = new VisualBasic6Lexer(input);
//        CommonTokenStream tokens = new CommonTokenStream(lexer);
//        VisualBasic6Parser parser = new VisualBasic6Parser(tokens);
//        
//        if ( parser.getNumberOfSyntaxErrors() > 0  ) {
//        	System.err.format("** ERROR - PARSER HAS %d  ERRORS ", parser.getNumberOfSyntaxErrors());
//        }
//        parser.removeErrorListeners();
//        parser.addErrorListener(new VerboseListener());
//
//        ParseTree tree = null;
//        parser.getInterpreter().setPredictionMode(PredictionMode.SLL); 
//        parser.setErrorHandler(new BailErrorStrategy());
//        try { 
//        	tree = parser.startRule(); 
//        } 
//        catch (Exception ex) { 
//        	try {
//                tokens.reset(); // rewind input stream 
//                parser.reset(); 
//                parser.getInterpreter().setPredictionMode(PredictionMode.LL); 
//                tree = parser.startRule(); 
//        	}
//        	catch (CancellationException e){
//        		e.printStackTrace();
//        	}
//        }       
//        
////        if(parser.getNumberOfSyntaxErrors() > 0){
//        	System.err.println("*** ERROR - " + parser.getNumberOfSyntaxErrors() + " errors during parsing process");
////        }
//    }
}
