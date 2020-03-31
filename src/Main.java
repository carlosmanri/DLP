import ast.program.Program;
import codegeneration.OffsetVisitor;
import error.ErrorHandler;
import introspector.model.IntrospectorModel;
import introspector.view.IntrospectorTree;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import parser.CmmLexer;
import parser.CmmParser;
import semantic.IdentificationVisitor;
import semantic.TypeCheckingVisitor;

public class Main {
	
	public static void main(String... args) throws Exception {
		   if (args.length<1) {
		        System.err.println("Please, pass me the input file.");
		        return;
		    }
		   		 			
		 // create a lexer that feeds off of input CharStream
		CharStream input = CharStreams.fromFileName(args[0]);
		CmmLexer lexer = new CmmLexer(input);

		// create a parser that feeds off the tokens buffer
		CommonTokenStream tokens = new CommonTokenStream(lexer); 
		CmmParser parser = new CmmParser(tokens);	
		Program ast = parser.program().ast;

		IdentificationVisitor identificationVisitor = new IdentificationVisitor();
		identificationVisitor.visit(ast, null);

		TypeCheckingVisitor typeCheckingVisitor = new TypeCheckingVisitor();
		typeCheckingVisitor.visit(ast, null);

		OffsetVisitor offsetVisitor = new OffsetVisitor();
		offsetVisitor.visit(ast, null);

		if(ErrorHandler.getInstance().anyError())
			ErrorHandler.getInstance().showErrors(System.err);

		IntrospectorModel model = new IntrospectorModel("Program", ast);
		new IntrospectorTree("Program", model);

	}



}
