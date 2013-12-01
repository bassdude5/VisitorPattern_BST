//---------------------------------------------------------------------
package studentBackup.visitor;
//---------------------------------------------------------------------
import studentBackup.bst.Node;
//---------------------------------------------------------------------
public interface VisitorInterface
{
	//Visit method for sum of the tree
	public int visit(Node root);

	//Visit method for adding a value to all nodes and registered
	// observers to a tree
	public void visit(Node root, int updateValue);

}//End of visitor interface
//---------------------------------------------------------------------
