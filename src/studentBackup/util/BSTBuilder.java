package studentBackup.util;
//---------------------------------------------------------------------
import studentBackup.util.Debug;
import studentBackup.bst.Node;
import studentBackup.bst.BST;
import studentBackup.observer.ObserverInterface;
//---------------------------------------------------------------------
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
//---------------------------------------------------------------------
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
//---------------------------------------------------------------------
public class BSTBuilder
{
	private final int ERRORVAL = 2;
	private Debug debug;
	private String inputFilename;
	private Map<String, BST> trees = null;
	private BufferedReader inputFile;
	private Boolean parentTreeRegistered = false;
	private String parentTreeName = "";

	/**
	*	Basic constructor
	**/
	public BSTBuilder(Debug debug)
	{
		this.debug = debug;
		this.inputFilename = null;
		trees = new HashMap<String, BST>();

		if(debug.getDebugVal() == 1)
		{
			System.out.println("BSTBuilder constructor called." 
			+ "\nParameters: debugVal" + 
			debug.getDebugVal() + "\n");
		}
	}

	/**
	*	Constructor with filename passed to object
	**/
	public BSTBuilder(Debug debug, String inputFilename)
	{
		this.debug = debug;
		this.inputFilename = inputFilename;
		trees = new HashMap<String, BST>();

		if(debug.getDebugVal() == 1)
		{
			System.out.println("BSTBuilder constructor called." 
			+ "\nParameters: debugVal" + debug.getDebugVal() 
			+ ", inputFilename " + inputFilename + "\n");
		}
	}

	/**
	*	This method creates a tree in the tree
	*	 builder instance
	**/
	public void createTree(String key)
	{
		trees.put(key, new BST(debug));	

		if(debug.getDebugVal() == 2)
		{
			System.out.println("Tree \"" + key +
				 "\" created and added to BSTBuilder");
		}
	}

	/**
	*	Sets the parent (subject) tree and registers
	*	 all other trees currently in the builder with the parent tree's
	*	 nodes
	**/
	public void setParentTree(String parentKey)
	{
		Vector<Node> treeNodes = new Vector<Node>();

		if(parentTreeRegistered == false)
		{
			if(trees.containsKey(parentKey) == true)
			{
			
				//Iterates through all trees in the hashmap
				for (String key : trees.keySet()) 
				{
					//Adds the root nodes to the vector 
					// ONLY if they are not the parent tree 
					// root node
					if(key.equals(parentKey) == false)
					{
						treeNodes.add(trees.get(key).getRoot());
					}
				}

				//Registers all nodes in the tree			
				registerTree(trees.get(parentKey).getRoot(), treeNodes);
				
				parentTreeName = parentKey;				
				parentTreeRegistered = true;
			}
			else
			{
				System.out.println("ERROR: Invalid tree name!");
			}
		}
		else
		{
			System.out.println("ERROR: Parent tree already setup!");
		}
	}

	/**
	*	Registers the node and its subtree's observers with 
	*	 all other corresponding nodes in all other trees
	**/
	private void registerTree(Node n1, Vector<Node> treeNodes)
	{
		Vector<Node> rightTreeNodes = new Vector<Node>();
		Vector<Node> leftTreeNodes = new Vector<Node>();

		if(n1 != null)
		{
			for(int i = 0; i < treeNodes.size(); i++)
			{
				n1.registerObserver((ObserverInterface) treeNodes.get(i));

				if(treeNodes.get(i).getRightChild() != null)
				{
					rightTreeNodes.add(treeNodes.get(i).getRightChild());
				}
				if(treeNodes.get(i).getLeftChild() != null)
				{
					leftTreeNodes.add(treeNodes.get(i).getLeftChild());
				}
			}

			if(n1.getRightChild() != null)
			{
				registerTree(n1.getRightChild(), rightTreeNodes);
			}

			if(n1.getLeftChild() != null)
			{
				registerTree(n1.getLeftChild(), leftTreeNodes);
			}
		}
	}

	/**
	*	This method returns the name of the current parent tree
	**/
	public String getParentTreeName()
	{
		if(parentTreeRegistered == true)
		{
			return parentTreeName;
		}
		else
		{
			System.out.println("ERROR: No parent currently set");
			return null;
		}
	}

	/**
	*	Unsets the parent tree, removing all the connections between
	*	 it and all other trees and resets all flags.
	**/
	public void unsetParentTree()
	{
		if(parentTreeRegistered == true)
		{
			BST tempTree = trees.get(parentTreeName);
			
			//Deregister all nodes in the tree			
			deregisterTree(tempTree.getRoot());
			
			//Set the parentTree name to empty
			parentTreeName = "";
			//Set the parentTreeRegistered flag to false,
			// meaning there is currently no parent tree
			parentTreeRegistered = false;
		}
		else
		{
			System.out.println("ERROR: No parent tree"
			 + " currently registered!");
		}
	}

	/**
	*	Recursive method that takes a node in, removes all 
	*	 observers, and then does the same for all of its children
	**/
	private void deregisterTree(Node n1)
	{
		if(n1 != null)
		{
			n1.removeAllObservers();
		
			if(n1.getRightChild() != null)
			{
				deregisterTree(n1.getRightChild());
			}
			if(n1.getLeftChild() != null)
			{
				deregisterTree(n1.getLeftChild());
			}
		}
	}

	/**
	*	This method prints all of the trees contained 
	*	 in the class hash map
	**/
	public void printAllTrees(String order)
	{
		//Iterates through all trees in the hashmap
		for (String key : trees.keySet()) 
		{
			printSingleTree(key, order);
		}
	}

	/**
	*	This method prints a single tree at the key given
	**/
	public void printSingleTree(String key, String order)
	{
		BST tempTree = trees.get(key);

		if(order.equals("pre"))
		{
			System.out.println("Printing " + key 
				+ " in preorder traversal");
			tempTree.printPreOrder(tempTree.getRoot());
			System.out.println("\n");
		
		}
		else if(order.equals("post"))
		{
			System.out.println("Printing " + key 
				+ " in postorder traversal");
			tempTree.printPostOrder(tempTree.getRoot());
			System.out.println("\n");
		}
		else if(order.equals("in"))
		{
			System.out.println("Printing " + key 
				+ " in inorder traversal");
			tempTree.printInOrder(tempTree.getRoot());
			System.out.println("\n");
		}
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
		System.out.println();	
	}

	/**
	*	This method clears all trees from the hashmap
	**/
	public void clearAllTrees()
	{
		for (String key : trees.keySet()) 
		{
			trees.remove(key);	
		}	
	}

	/**
	*	This method clears the tree at the key given from 
	*	 the hashmap
	**/
	public void clearTreeAt(String key)
	{
		trees.remove(key);
	}

	/**
	*	Populates all the current trees in the hash map
	**/
	public void populateAllTrees()
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
					value = Integer.parseInt(lineIn);
				}
				catch(NumberFormatException e)
				{
					//Catch for integer parsing
					System.out.println("ERROR: invalid line: \""
					 + lineIn + "\" in input file: " + inputFilename);

					System.exit(ERRORVAL);
				}
			
				//Iterate through all trees in the Hash,
				// calling insert on each tree
				for (String key : trees.keySet()) 
				{
					temp = trees.get(key);
					//Insert
					temp.insert(temp.getRoot(), value);
				}

				lineIn = inputFile.readLine();
			}

			//Closes the input file
			inputFile.close();	
		}
		catch(IOException e)
		{
			//Catch for no file or problem opening file
			System.out.println("ERROR: file not found!");
			System.exit(ERRORVAL);
		}
	}

	/**
	*	Populates the single tree at the key given
	**/
	public void populateSingleTree(String key)
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
					value = Integer.parseInt(lineIn);
				}
				catch(NumberFormatException e)
				{
					//Catch for integer parsing
					System.out.println("ERROR: invalid line: \""
					 + lineIn + "\" in input file: " + inputFilename);

					System.exit(ERRORVAL);
				}
			
				temp = trees.get(key);
				//Insert
				temp.insert(temp.getRoot(), value);

				lineIn = inputFile.readLine();
			}

			//Closes the input file
			inputFile.close();	
		}
		catch(IOException e)
		{
			//Catch for no file or problem opening file
			System.out.println("ERROR: file not found!");
			System.exit(ERRORVAL);
		}
	}

	/**
	*	This method returns a binary search tree at the key passed
	*	@return Returns a binary search tree corresponding to the key passed
	**/
	public BST getTree(String key)
	{
		BST temp = null;

		if(key != null)
		{
			if(trees.containsKey(key) == true)
			{
				temp = trees.get(key);
			}
			else
			{
				System.out.println("ERROR: No tree currently" +
					" associated with name: \"" + key + "\"");
			}
		}
		else
		{
			System.out.println("ERROR: Cannot get tree with null name");
		}
		return temp;
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
