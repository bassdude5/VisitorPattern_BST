//---------------------------------------------------------------------
package studentBackup.visitor;
//---------------------------------------------------------------------
import studentBackup.util.Debug;
import studentBackup.bst.Node;
//---------------------------------------------------------------------
public class Visitor implements VisitorInterface
{
	private final int ERRORVAL = 5;
	private Debug debug;

	/**
	*	Visitor constructor
	**/
	public Visitor(Debug debug)
	{
		if(debug.getDebugVal() == 1)
		{
			System.out.println("Visitor constructor called."
				+ "\nParameters: debugVal " 
				+ debug.getDebugVal() + "\n");
		}
	}

	/**
	*	This is the visit method that is used to get the sum of a tree
	*	 or subtree
	*	@return Returns the sum of the tree
	**/
	public int visit(Node root)
	{
		int sum = 0;

		if(root == null)
		{
			System.out.println("ERROR: attempted to visit a null node!");
			System.exit(ERRORVAL);
		}

		if(root.getRightChild() != null && root.getLeftChild() != null)
		{
			sum = root.getBNum() + visit(root.getRightChild()) + 
			visit(root.getLeftChild());
		}
		else if(root.getRightChild() != null && root.getLeftChild() == null)
		{
			sum = root.getBNum() + visit(root.getRightChild());
		}
		else if(root.getRightChild() == null && root.getLeftChild() != null)
		{
			sum = root.getBNum() + visit(root.getLeftChild());
		}
		else
		{
			sum = root.getBNum();
		}

		return sum;
	}

	/**
	*	This is the visit method that is used to add updateValue 
	*	 to all nodes in a tree
	**/
	public void visit(Node root, int updateValue)
	{
		if(root != null)
		{
			root.setBNum(root.getBNum() + updateValue);

			root.notifyObservers(updateValue);
			
			if(root.getRightChild() != null)
			{
				visit(root.getRightChild(), updateValue);
			}
			if(root.getLeftChild() != null)
			{
				visit(root.getLeftChild(), updateValue);
			}
		}
		else
		{	
			System.out.println("ERROR: Unable to add value to null root node");
		}	
	}

}//End of Visitor class
//---------------------------------------------------------------------
