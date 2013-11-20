package studentBackup.driver;
//---------------------------------------------------------------------
import studentBackup.util.Debug;
import studentBackup.bst.BST;
import studentBackup.util.BSTBuilder;
//---------------------------------------------------------------------
public class Driver
{
	private static final int errorVal = 1;
	private static Debug debug;
	
	private static String inputFilename;
	private static int UPDATE_VALUE;

	public static void main(String[] args)
	{
		BST tree1;
		BST tree2;
		BST tree3;
		
		BSTBuilder treeBuilder;

		//Initalize the debug class
		debug = new Debug();

		//Parse the input and set the class variables
		parseCommandLineInput(args);
		

		//Use BSTBuilder to build 3 trees	
		treeBuilder = new BSTBuilder(debug, inputFilename);

		/*tree1 = new BST(debug);
		tree2 = new BST(debug);
		tree3 = new BST(debug);
		*/

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
