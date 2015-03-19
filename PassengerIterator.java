import java.util.ArrayList;
import java.util.Iterator;

// our Thread Safe and Thread Shareable Iterator that the workers will work off of.
class PassengerIterator {

    //instantiate local vars
    private Iterator<Passenger> pi;
    private int passenger_size;
    private int original_size;
    private PassTaxiGUI pd;

    //constructor
    PassengerIterator(ArrayList<Passenger> passengers, PassTaxiGUI passDisplay){
        //these vars will be shared across the workers
        pi = passengers.iterator();
        pd = passDisplay;
        passenger_size = passengers.size();
        original_size = passengers.size();

    }

    // syncronized functions so that each worker can always have the most up to date version of the object
    public synchronized PassTaxiGUI passDisplay(){
        return pd;
    }

    public synchronized  int queue_length(){
        return passenger_size;
    }

    public synchronized  int decrement(){
        passenger_size--;
        return passenger_size;
    }
    public synchronized void increment(ArrayList<Passenger> passengers) {
        pi = passengers.iterator();
        passenger_size = passengers.size();

    }

    public synchronized Iterator<Passenger> fetch() {
        return pi;
    }

}
