//---------------------------------------------------------------------
package studentBackup.observer;
//---------------------------------------------------------------------
public interface SubjectInterface
{
	public void registerObserver(ObserverInterface o);
	public void removeObserver(ObserverInterface o);
	public void notifyObservers(int num);
}//End of SubjectInterface
//---------------------------------------------------------------------
