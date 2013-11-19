<<<<<<< HEAD
package studentBackup.bst;

=======
//---------------------------------------------------------------------
package studentBackup.bst;
//---------------------------------------------------------------------
>>>>>>> d1675f392180703435b0bd39ad0ef9d250583b7a
public class Node
{
	private int bNum;

	/**
	*	This is the empty class constructor
	**/
	public Node()
	{
		
	}
	
	/**
	*	This is a class constructor that can be used instead
	*	 of the empty constructor to intialize a node and 
	*	 construct it at the same time
	**/
	public Node(int bNum)
	{
		this.bNum = bNum;
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
