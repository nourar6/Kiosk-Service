
import java.util.*;
public class Taxi implements Subject
{
    //Passenger Class
    private String taxi_reg;

    //initially, set time to midnight
    public Taxi(){}

    //////////////////////////////////////////////////////////////
    //VARIOUS GET METHODS
    //returns hours component of the time

    public String getTaxi() { return taxi_reg; }

    public void setTaxi(String reg) { taxi_reg = reg; }


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
