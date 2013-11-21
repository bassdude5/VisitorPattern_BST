package studentBackup.util;
//---------------------------------------------------------------------
import studentBackup.util.Debug;
import studentBackup.bst.Node;
import studentBackup.bst.BST;
//---------------------------------------------------------------------
import java.util.HashMap;
import java.util.Map;
import java.io.BufferedReader;
//---------------------------------------------------------------------
public class BSTBuilder
{
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
	public void populateAllTrees()
	{
		//Readline from file
		//Parse to integer
		//call insert on all trees
		//read next line
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

	}

	/**
	*	This method prints a single tree at the key given
	**/
	public void printSingleTree(String key)
	{

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
