//holds the time, with various get and set methods
//subject of observer pattern

import java.util.*;
public class Kiosk implements Subject
{
    //Kiosk Class
    public int number;
    private boolean active;
    private String destination;
    private int no_of_pas;
    private String taxi;

	//initially, set time to midnight
	public Kiosk(int num)
	{   number = num;
        active = false;
	}
	
	//////////////////////////////////////////////////////////////
	//VARIOUS GET METHODS
	//returns hours component of the time
	public boolean getStatus()
	{
		return active;
	}

    public String getDestination() { return destination; }

    public int getNo_of_pas() { return  no_of_pas; }

    public String getTaxi() { return taxi; }
	//initialises Active with the state
	public void setState(boolean state)
	{
		active = state;
		notifyObservers();
	}
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
