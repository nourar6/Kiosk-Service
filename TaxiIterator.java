import java.util.ArrayList;
import java.util.Iterator;

// TaxiIterator Class which is used for sharing between the Threads(workers)
class TaxiIterator {
    // instantiate the variables that will be shared
    private Iterator<Taxi> ti;
    private int taxi_size;
    private PassTaxiGUI td;

    //constructor
    TaxiIterator(ArrayList<Taxi> taxis, PassTaxiGUI taxiDisplay){
        ti = taxis.iterator();
        td = taxiDisplay;
        taxi_size = taxis.size();

    }
    //method to return the GUI to update the state.
    public synchronized PassTaxiGUI taxiDisplay(){
        return td;
    }

    public synchronized void remove() {
        ti.remove();
    }

    // method to return the length of the queue
    public synchronized  int queue_length(){
        return taxi_size;
    }

    public synchronized  int decrement(){
        taxi_size--;
        return taxi_size;
    }
    // method to return the iterator
    public synchronized Iterator<Taxi> fetch() {
        return ti;
    }

}