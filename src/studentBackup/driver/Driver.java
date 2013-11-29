package studentBackup.driver;
//---------------------------------------------------------------------
import studentBackup.util.Debug;
import studentBackup.bst.BST;
import studentBackup.util.BSTBuilder;
//---------------------------------------------------------------------
public class Driver
{
	private static final int errorVal = 1;

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

		//Initalize the debug class
		debug = new Debug();

		//Parse the input and set the class variables
		parseCommandLineInput(args);
		
		//Initialize the treeBuilder
		treeBuilder = new BSTBuilder(debug, inputFilename);
		//Create three trees 
		treeBuilder.createTree("tree1");
		treeBuilder.createTree("tree2");
		treeBuilder.createTree("tree3");

		//Populate all of the trees from the input file
		treeBuilder.populateAllTrees();

		//treeBuilder.printSingleTree("tree1", IN);
		//treeBuilder.printSingleTree("tree1", POST);
		//treeBuilder.printSingleTree("tree1", PRE);

		//Prints all tree names in the treeBuilder instance
		//treeBuilder.printTreeNames();

		//Call inorder traversal to print the values from the three trees
		//Call the visitor to print the sum of all the B-Numbers in the three trees
		//Call the visitor to update all the nodes with UPDATE_VALUE
		//Call the inorder traversal to print the values from the three trees
		//Call the visitor to print the sume of all the B-Numbers in the three trees
	}

	/**
	*	This method parses all command line arguments 
	*	 and sets the private class variables appropriately
	**/
	private static final void parseCommandLineInput(String[] args)
	{
		//Checks that the number of arguments passed is correct
		if(args.length != 3)
		{
			System.out.println("ERROR: Invalid number of"
				+ " arguments!");
			System.exit(errorVal);
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
			System.exit(errorVal);
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
			System.exit(errorVal);
		}
	}
}//End of Driver class
//---------------------------------------------------------------------
