package studentBackup.driver;

public class Driver
{
<<<<<<< HEAD
	private static final int errorVal = 1;
	
	private static String inputFilename;
	private static int UPDATE_VALUE;

	public static void main(String[] args)
	{
		parseCommandLineInput(args);
	
		//Use BSTBuilder to build 3 trees

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
		int dVal;

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
			dVal = Integer.parseInt(args[2]);
		}
		catch(Exception e)
		{
			System.out.println("ERROR: debug value is" +
			" not a valid integer!");
			System.exit(errorVal);
		}
=======
	private String inputFilename;
	private int UPDATE_VALUE;

	private int errorVal = 1;

	//Input parameters: 
	//	String inputFilename, int UPDATE_VALUE
	public static void main(String[] args)
	{
		
	}

	public Boolean parseCommandLineArgs(String args[])
	{
		if(args.length() != 2)
		{
			System.out.println("ERROR: Inproper number"
				+ " of arguments passed!");
			System.exit(errorVal);	
		}
		/*try
		{
			
		}
		catch(Exception e)
		{

		}*/
>>>>>>> d1675f392180703435b0bd39ad0ef9d250583b7a
	}
}
