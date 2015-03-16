//Model for MVC

import java.util.LinkedList;
import java.util.List;
public class Kiosk implements Subject
{
    //Kiosk Class
    public int number;
    private String destination;
    private int no_of_pas;
    private String taxi;

	// give the kiosk a number like Window 1
	public Kiosk(int num) { number = num; }
	
	//////////////////////////////////////////////////////////////
	//VARIOUS GET METHODS

    public String getDestination() { return destination; }

    public int getNo_of_pas() { return  no_of_pas; }

    public String getTaxi() { return taxi; }

    //////////////////////////////////////////////////////////////
    //VARIOUS SET METHODS

    public void setDestination(String dest)
    {
        destination = dest;
        notifyObservers();
    }

    public void setNo_of_pas(int no_of_passengers)
    {
        no_of_pas = no_of_passengers;
        notifyObservers();
    }

    public void setTaxi(String taxi_reg)
    {
        taxi = taxi_reg;
        notifyObservers();
    }

	////////////////////////////////////////////////////////
	//OBSERVER PATTERN
	//SUBJECT must be able to register, remove and notify observers
	//list to hold any observers
	private List<Observer> registeredObservers = new LinkedList<Observer>();
	//methods to register, remove and notify observers
	public void registerObserver( Observer obs)
	{
		registeredObservers.add( obs);
	}
	
	public void removeObserver( Observer obs)
	{
		registeredObservers.remove( obs);
	}
	
	public void notifyObservers()
	{
		for( Observer obs : registeredObservers)
			obs.update();
	}
	//////////////////////////////////////////////////////// 	
}
