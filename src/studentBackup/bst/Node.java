//---------------------------------------------------------------------
package studentBackup.bst;
//---------------------------------------------------------------------
import studentBackup.util.Debug;
//---------------------------------------------------------------------
public class Node
{
	private final int errorVal = 4;
	private Debug debug;
	private int bNum;
	private Node leftChild;
	private Node rightChild;

	/**
	*	This is the "empty" class constructor
	**/
	public Node(Debug debug)
	{
		this.bNum = 0;
		this.leftChild = null;
		this.rightChild = null;
		this.debug = debug;

		if(debug.getDebugVal() == 3)
		{
			System.out.println("Basic Node constructor called." 
			+ "\nParameters: debugVal" +
			debug.getDebugVal() + "\n");
		}
	}
	
	/**
	*	Class constructor to construct a node with no children
	**/
	public Node(Debug debug, int bNum)
	{
		this.bNum = bNum;
		this.leftChild = null;
		this.rightChild = null;
		this.debug = debug;

		if(debug.getDebugVal() == 3)
		{
			System.out.println("Node constructor called with" +
			" no specified children nodes." 
			+ "\nParameters: debugVal" +
			debug.getDebugVal() + ", bNum " + bNum  + "\n");
		}
	}

	/**
	*	Class constructor to construct a node with children
	**/
	public Node(Debug debug, int bNum, Node leftChild,
		Node rightChild)
	{
		this.bNum = bNum;
		this.leftChild = null;
		rightChild = null;
		this.debug = debug;

		if(debug.getDebugVal() == 3)
		{
			System.out.println("Node constructor called with" +
			" specified children nodes." 
			+ "\nParameters: debugVal" +
			debug.getDebugVal() + ", bNum " + bNum  +
			", leftChild " + leftChild.getBNum() +
			", rightChild " + rightChild.getBNum() + "\n");
		}
	}
	
	/**
	*	This method is used to get the right child node	
	*	@return Returns the right child node
	**/
	public Node getRightChild()
	{
		return rightChild;
	}

	/**
	*	This method is used to set the right child 
	*	 node reference
	**/
	public void setRightChild(Node rightChild)
	{
		this.rightChild = rightChild;
	}
	
	/**
	*	This method is used to get the left child node
	*	@return Returns the left child node
	**/
	public Node getLeftChild()
	{
		return leftChild;
	}
	
	/**
	*	This method is used to set the left child 
	*	 node reference
	**/
	public void setLeftChild(Node leftChild)
	{
		this.leftChild = leftChild;
	}

	/**
	*	This method is used to get the bNum value
	*	@return This method returns the bNum value
	**/
	public int getBNum()
	{
		return bNum;
	}

	/**
	*	This method is used to set the bNum class variable
	**/
	public void setBNum(int bNum)
	{
		this.bNum = bNum;
	}

}//End of class node
//---------------------------------------------------------------------
