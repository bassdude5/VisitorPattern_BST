package studentBackup.util;
//---------------------------------------------------------------------
import studentBackup.util.Debug;
import studentBackup.bst.Node;
import studentBackup.bst.BST;
//---------------------------------------------------------------------
import java.util.HashMap;
import java.util.Map;
//---------------------------------------------------------------------
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
//---------------------------------------------------------------------
public class BSTBuilder
{
	private final int errorVal = 2;

	private Debug debug;
	private String inputFilename;
	private Map<String, BST> trees = null;
	private BufferedReader inputFile;

	/**
	*	Basic constructor
	**/
	public BSTBuilder(Debug debug)
	{
		this.debug = debug;
		this.inputFilename = null;
		trees = new HashMap<String, BST>();
	}

	/**
	*	Constructor with filename passed to object
	**/
	public BSTBuilder(Debug debug, String inputFilename)
	{
		this.debug = debug;
		this.inputFilename = inputFilename;
		trees = new HashMap<String, BST>();
	}

	/**
	*	This method creates a tree in the tree
	*	 builder instance
	**/
	public void createTree(String key)
	{
		trees.put(key, new BST(debug));	
	}

	/**
	*	Populates all the current trees in the hash map
	**/
	public void populateAllTrees() throws IOException
	{
		BST temp;
		int value = 0;
		String lineIn;

		try
		{
			inputFile = new BufferedReader(new FileReader(inputFilename));

			lineIn = inputFile.readLine();

			while(lineIn != null)
			{	
				try
				{
					System.out.println(Integer.parseInt(lineIn));
				}
				catch(NumberFormatException e)
				{
					//Catch for integer parsing
					System.out.println("ERROR: invalid line: \""
					 + lineIn + "\" in input file: " + inputFilename);

					System.exit(errorVal);
				}
			
			//Iterate through all trees in the Hash,
			// calling insert on each tree
			for (String key : trees.keySet()) 
			{
				temp = trees.get(key);
				//Inserts 
				temp.insert(temp.getRoot(), value);
			}

				lineIn = inputFile.readLine();
			}	

		}
		catch(IOException e)
		{
			//Catch for no file or problem opening file
			System.out.println("ERROR: file not found!");
			System.exit(errorVal);
		}
		finally
		{
			//Closes the input file
			inputFile.close();	
		}
	}

	/**
	*	Populates the single tree at the key given
	**/
	public void populateSingleTree(String key)
	{

	}

	/**
	*	This method prints all of the trees contained 
	*	 in the class hash map
	**/
	public void printAllTrees()
	{
		//Iterates through all trees in the hashmap
		for (String key : trees.keySet()) 
		{
			
		}
	}

	/**
	*	This method prints a single tree at the key given
	**/
	public void printSingleTree(String key)
	{

	}

	/**
	*	This method prints the names of all trees
	*	 that this class currently contains
	**/
	public void printTreeNames()
	{
		//Iterates through all trees in the hashmap
		for (String key : trees.keySet()) 
		{
			System.out.println(key);	
		}	
	}

	/**
	*	This method clears all trees
	**/
	public void clearAllTrees()
	{

	}

	/**
	*	This method clears the tree at the key given
	**/
	public void clearTreeAt(String key)
	{
		//(trees.get(key)) = null;
	}

	/**
	*	This is the setter for the filename
	**/
	public void setInputFilename(String inputFilename)
	{
		this.inputFilename = inputFilename;
	}

	/**
	*	This is the getter for the filename
	**/
	public String getInputFilename()
	{
		return inputFilename;
	}

}//End of BSTBuilder class
//---------------------------------------------------------------------
