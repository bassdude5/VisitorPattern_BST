//---------------------------------------------------------------------
package studentBackup.bst;
//---------------------------------------------------------------------
import studentBackup.util.Debug;
import studentBackup.bst.Node;
//---------------------------------------------------------------------
public class BST
{
	private Debug debug;
	private Node root;

	/**
	*	Basic class constructor for an empty tree
	**/
	public BST(Debug debug)
	{
		this.debug = debug;

		//Sets the root of the tree to null
		root = null;
	}

	/**
	*	Class constructor for a tree with a root
	**/
	public BST(Debug debug, Node root)
	{
		this.debug = debug;
		this.root = root;
	}

	/**
	*	This method inserts a node into the BST
	*	 according the BST rules
	**/
	public Node insert(Node root, int value)
	{
		//If there is no root, create a root
		if(root == null)
		{
			return null;
			//return new Node(value);	
		}
		else
		{
			if(value < root.getBNum())
			{
				insert(root.getLeftChild(), value);	
			}
			else
			{
				insert(root.getRightChild(), value);
			}
		}
	
		return null;
	}

	/**
	*	This method visits and prints the b-number for each 
	*	 node in the tree
	**/
	public void printInOrder()
	{

	}
}//End of BST class
//---------------------------------------------------------------------
