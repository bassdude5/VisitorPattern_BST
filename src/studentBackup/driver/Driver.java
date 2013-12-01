package studentBackup.driver;
//---------------------------------------------------------------------
import studentBackup.util.Debug;
import studentBackup.bst.BST;
import studentBackup.util.BSTBuilder;
import studentBackup.visitor.Visitor;
import studentBackup.visitor.VisitorInterface;
//---------------------------------------------------------------------
public class Driver
{
	private static final int ERRORVAL = 1;

	//Constants used for tree traversal
	private static final String PRE = "pre";
	private static final String POST = "post";
	private static final String IN = "in";	

	private static Debug debug;
	
	private static String inputFilename;
	private static int UPDATE_VALUE;

	public static void main(String[] args)
	{
		BSTBuilder treeBuilder;
		VisitorInterface visitNodes;

		//Initalize the debug class
		debug = new Debug();

		//Parse the input and set the class variables
		//NOTE: This includes the initialization of the debug class
		parseCommandLineInput(args);
		
		//Initialize the treeBuilder
		treeBuilder = new BSTBuilder(debug, inputFilename);

		//Initialize the visitor class
		visitNodes = new Visitor(debug);

		printLine(50, '=');

		//Create three trees 
		treeBuilder.createTree("tree1");
		treeBuilder.createTree("backup1");
		treeBuilder.createTree("backup2");

		//Populate all of the trees from the input file
		treeBuilder.populateAllTrees();

		//Sets the parent tree to be tree1
		//(registers the observers)
		treeBuilder.setParentTree("tree1");

		//Prints all tree names in the treeBuilder instance
		System.out.println("Trees in BSTBuilder:");
		treeBuilder.printTreeNames();
		printLine(50, '-');

		//Call inorder traversal to print the values from the three trees
		treeBuilder.printAllTrees(IN);
		printLine(50, '-');

		//Call the visitor to print the sum of all the B-Numbers in the three trees
		sumTrees(treeBuilder, visitNodes);
		printLine(50, '-');

		//Call the visitor to update all the nodes with UPDATE_VALUE
		treeBuilder.getTree(treeBuilder.getParentTreeName()).accept(visitNodes, UPDATE_VALUE);		

		//Call the inorder traversal to print the values from the three trees
		treeBuilder.printAllTrees(IN);
		printLine(50, '-');

		//Call the visitor to print the sum of all the B-Numbers in the three trees
		sumTrees(treeBuilder, visitNodes);
		printLine(50, '=');

	}

	/**
	*	This method parses all command line arguments 
	*	 and sets the private class variables appropriately
	**/
	private static void parseCommandLineInput(String[] args)
	{
		//Checks that the number of arguments passed is correct
		if(args.length != 3)
		{
			System.out.println("ERROR: Invalid number of"
				+ " arguments!");
			System.exit(ERRORVAL);
		}
		//Sets the input filename to the first arg passed
		inputFilename = args[0];
		
		//Parse the UPDATE_VALUE
		try
		{
			UPDATE_VALUE = Integer.parseInt(args[1]);
		}
		catch(Exception e)
		{
			System.out.println("ERROR: UPDATE_VALUE is" +
			" not a valid integer!");
			System.exit(ERRORVAL);
		}

		//Parse the debug value
		try
		{
			debug.setDebugVal(Integer.parseInt(args[2]));
		}
		catch(Exception e)
		{
			System.out.println("ERROR: debug value is" +
			" not a valid integer!");
			System.exit(ERRORVAL);
		}
	}

	private static void sumTrees(BSTBuilder treeBuilder, VisitorInterface visitNodes)
	{
		System.out.println("Sum of tree \"tree1\" is: " + 
			treeBuilder.getTree("tree1").accept(visitNodes));

		System.out.println("Sum of tree \"backup1\" is: " + 
			treeBuilder.getTree("backup1").accept(visitNodes));

		System.out.println("Sum of tree \"backup2\" is: " + 
			treeBuilder.getTree("backup2").accept(visitNodes) + "\n");

	}

	private static void printLine(int length, char c)
	{
		for(int i = 0; i < length; i++)
		{	
			System.out.print(c);
		}
		System.out.println();		
	}

}//End of Driver class
//---------------------------------------------------------------------
