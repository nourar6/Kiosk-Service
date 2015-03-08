
import java.util.*;
public class Passenger implements Subject
{
    //Passenger Class
    private String destination;
    private int no_of_pas;

    //initially, set time to midnight
    public Passenger(){}

    //////////////////////////////////////////////////////////////
    //VARIOUS GET METHODS
    //returns hours component of the time

    public String getDestination() { return destination; }

    public int getNo_of_pas() { return  no_of_pas; }

    public void setDestination(String dest) { destination = dest; }

    public void setNo_of_pas(int no_of_passengers) { no_of_pas = no_of_passengers; }

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
