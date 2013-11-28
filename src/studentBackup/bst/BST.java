//---------------------------------------------------------------------
package studentBackup.bst;
//---------------------------------------------------------------------
import studentBackup.util.Debug;
import studentBackup.bst.Node;
//---------------------------------------------------------------------
public class BST
{
	private final int errorVal = 3;
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
	public void insert(Node root, int bNum)
	{
		//Checks for a null root node,
		// this is only used when the tree is completely
		// empty.
		if(root == null)
		{
			this.root = new Node(debug, bNum);
		}
		else
		{
			if(bNum < root.getBNum())
			{
				if(root.getLeftChild() == null)
				{
					root.setLeftChild(new Node(debug, bNum));
				}
				else
				{
					insert(root.getLeftChild(), bNum);
				}
			}
			else
			{
				if(root.getRightChild() == null)
				{
					root.setRightChild(new Node(debug, bNum));
				}
				else
				{
					insert(root.getRightChild(), bNum);
				}
			}
		}
	}


	/**
	*	This method visits and prints the b-number for each
	*	 node in the tree, by traversing the tree in pre-order
	**/
	public void printPreOrder()
	{
		//1) Visit root
		//2) Traverse left subtree
		//3) Traverse right subtree
	}

	/**
	*	This method visits and prints the b-number for each 
	*	 node in the tree, by traversing the tree in-order
	**/
	public void printInOrder()
	{
		//1) Traverse left subtree
		//2) Visit root
		//3) Traverse right subtree
	}

	/**
	*	This method visits and prints the b-number for each
	*	 node in the tree, by traversing the tree in post-order
	**/
	public void printPostOrder()
	{
		//1) Traverse left subtree
		//2) Traverse right subtree
		//3) Visit root
	}

	/**
	*	This method is the getter for the tree's root node
	*	@return Returns the root node of the tree
	**/
	public Node getRoot()
	{
		return root;
	}

	/**
	*	This method is the setter for the tree's root
	**/
	public void setRoot(Node root)
	{
		this.root = root;
	}
}//End of BST class
//---------------------------------------------------------------------
