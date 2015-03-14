import java.util.ArrayList;
import java.util.Iterator;

class TaxiIterator {

    private Iterator<Taxi> ti;
    private int taxi_size;
    private PassTaxiGUI td;

    TaxiIterator(ArrayList<Taxi> taxis, PassTaxiGUI taxiDisplay){
        ti = taxis.iterator();
        td = taxiDisplay;
        taxi_size = taxis.size();

    }

    public synchronized PassTaxiGUI taxiDisplay(){
        return td;
    }

    public synchronized void remove() {
        ti.remove();
    }

    public synchronized  int queue_length(){
        return taxi_size;
    }

    public synchronized Iterator<Taxi> fetch() {
        return ti;
    }

}