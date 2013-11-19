package studentBackup.util;

public class Debug
{
	private int debugVal;

	/**
	*	Empty (null) class constructor
	**/
	public Debug()
	{

	}
	
	/**
	*	Class constructor that sets the debug val and 
	*	 constructs a new object
	**/
	public Debug(int debugVal)
	{
		this.debugVal = debugVal;
	}
	
	/**
	*	Getter method for the debug value
	*	@return Returns the debug value
	**/	
	public int getDebugVal()
	{
		return debugVal;
	}

	/**
	*	Setter method for the debug value
	**/
	public void setDebugVal(int debugVal)
	{
		this.debugVal = debugVal;
	}
}
