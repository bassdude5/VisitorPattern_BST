//---------------------------------------------------------------------
package studentBackup.bst;
//---------------------------------------------------------------------
import studentBackup.util.Debug;
import studentBackup.bst.Node;
import studentBackup.visitor.Visitor;
//---------------------------------------------------------------------
public class BST
{
	private final int ERRORVAL = 3;
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

		if(debug.getDebugVal() == 1)
		{
			System.out.println("BST constructor called."
				+ "\nParameters: debugVal " 
				+ debug.getDebugVal() + "\n");
		}
	}

	/**
	*	Class constructor for a tree with a root
	**/
	public BST(Debug debug, Node root)
	{
		this.debug = debug;
		this.root = root;

		if(debug.getDebugVal() == 1)
		{
			System.out.println("BST constructor called."
				+ "\nParameters: debugVal " 
				+ debug.getDebugVal()
				+ ", root " + root.getBNum() + "\n");
		}
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
	*	This method is used to balance the binary search tree so
	*	 that the size of right and left trees are fairly equal.
	*	
	*	NOTE: The root node may be changed when this method is run
	**/
	public void balance()
	{
		//if(sizeLeft > sizeRight)
		//else if(sizeLeft < sizeRight)
		//else
		//{
		//	System.out.println("Tree is already balanced!");
		//}

		//NEED TO RECALCULATE THE SIZE OF BOTH SUBTREES
		//FIXME: Finish this method
	}

	/**
	*	
	**/
	public void accept(Visitor visitor)
	{

	}


	/**
	*	This method visits and prints the b-number for each
	*	 node in the tree, by traversing the tree in pre-order
	**/
	public void printPreOrder(Node root)
	{
		//1) Visit root
		System.out.print(root.getBNum() + " ");

		//2) Traverse left subtree	
		if(root.getLeftChild() != null)
		{
			printPreOrder(root.getLeftChild());
		}

		//3) Traverse right subtree
		if(root.getRightChild() != null)
		{
			printPreOrder(root.getRightChild());
		}
	}

	/**
	*	This method visits and prints the b-number for each 
	*	 node in the tree, by traversing the tree in-order
	**/
	public void printInOrder(Node root)
	{
		//1) Traverse left subtree
		if(root.getLeftChild() != null)
		{
			printInOrder(root.getLeftChild());
		}

		//2) Visit root
		System.out.print(root.getBNum() + " ");

		//3) Traverse right subtree
		if(root.getRightChild() != null)
		{
			printInOrder(root.getRightChild());
		}
	}

	/**
	*	This method visits and prints the b-number for each
	*	 node in the tree, by traversing the tree in post-order
	**/
	public void printPostOrder(Node root)
	{
		//1) Traverse left subtree
		if(root.getLeftChild() != null)
		{
			printPostOrder(root.getLeftChild());
		}

		//2) Traverse right subtree
		if(root.getRightChild() != null)
		{
			printPostOrder(root.getRightChild());
		}

		//3) Visit root
		System.out.print(root.getBNum() + " ");
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
