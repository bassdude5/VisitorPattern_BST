package studentBackup.util;

import studentBackup.util.Debug;
import studentBackup.bst.Node;

public class BSTBuilder
{
	private Debug debug;
	private String inputFilename;
	//private vector of trees
	//private BufferedReader	

	/**
	*	Basic constructor
	**/
	public BSTBuilder(Debug debug)
	{
		this.debug = debug;
		this.inputFilename = null;
	}

	/**
	*	Constructor with filename passed to object
	**/
	public BSTBuilder(Debug debug, String inputFilename)
	{
		this.debug = debug;
		this.inputFilename = inputFilename;
	}

	/**
	*	This method adds a tree to the tree builder
	**/
	public void addTree()
	{
		//Add a new tree to the vector of trees
	}

	/**
	*	Populates all the current trees in the vector 
	**/
	public void populateAllTrees()
	{
		//Readline from file
		//Parse to integer
		//call insert on all trees
		//read next line
	}

	/**
	*	Populates the single tree at the index given
	**/
	public void populateSingleTree(int index)
	{

	}

	/**
	*	This method prints all of the trees in the class vector
	**/
	public void printAllTrees()
	{

	}

	/**
	*	This method prints a single tree at the index
	**/
	public void printSingleTree(int index)
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
