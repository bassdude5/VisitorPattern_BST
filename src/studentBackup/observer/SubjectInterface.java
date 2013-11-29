package studentBackup.observer;

public interface SubjectInterface
{
	public void registerObserver(ObserverInterface o);
	public void removeObserver(ObserverInterface o);

	//FIXME: Add parameter?
	public void notifyObservers();
}
