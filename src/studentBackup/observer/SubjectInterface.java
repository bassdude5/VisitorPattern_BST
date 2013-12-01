//---------------------------------------------------------------------
package studentBackup.observer;
//---------------------------------------------------------------------
public interface SubjectInterface
{
	//Method used to register observers
	public void registerObserver(ObserverInterface o);

	//Method used to remove observer from the list of observers
	public void removeObserver(ObserverInterface o);

	//Method used to notify all current observers
	public void notifyObservers(int num);

}//End of SubjectInterface
//---------------------------------------------------------------------
