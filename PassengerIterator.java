import java.util.ArrayList;
import java.util.Iterator;

class PassengerIterator {

    private Iterator<Passenger> pi;
    private int passenger_size;
    private PassTaxiGUI pd;

    PassengerIterator(ArrayList<Passenger> passengers, PassTaxiGUI passDisplay){
        pi = passengers.iterator();
        pd = passDisplay;
        passenger_size = passengers.size();

    }

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

    public synchronized Iterator<Passenger> fetch() {
        return pi;
    }

}
