import java.util.ArrayList;

public class KioskService
{
    public static void main(String[] args)
    {

        //TODO Generate Passenger Queues
        ArrayList<Passenger> passenger_queue = new ArrayList<Passenger>();

        Passenger passenger = new Passenger();
        passenger.setDestination("Edinburgh");
        passenger.setNo_of_pas(3);
        passenger_queue.add(passenger);

        passenger = new Passenger();
        passenger.setDestination("Manchester");
        passenger.setNo_of_pas(1);
        passenger_queue.add(passenger);

        passenger = new Passenger();
        passenger.setDestination("Newcastle");
        passenger.setNo_of_pas(3);
        passenger_queue.add(passenger);

        passenger = new Passenger();
        passenger.setDestination("London");
        passenger.setNo_of_pas(2);
        passenger_queue.add(passenger);

        passenger = new Passenger();
        passenger.setDestination("Birmingham");
        passenger.setNo_of_pas(2);
        passenger_queue.add(passenger);

        ArrayList<Taxi> taxi_queue = new ArrayList<Taxi>();

        Taxi taxi = new Taxi();
        taxi.setTaxi("L5H 140");
        taxi_queue.add(taxi);

        taxi = new Taxi();
        taxi.setTaxi("Z6N 557");
        taxi_queue.add(taxi);

        taxi = new Taxi();
        taxi.setTaxi("R6D 703");
        taxi_queue.add(taxi);

        taxi = new Taxi();
        taxi.setTaxi("U6F 901");
        taxi_queue.add(taxi);

        int pass_size = passenger_queue.size();
        PassTaxiGUI  passDisplay = new PassTaxiGUI("PASSENGER GROUPS ",pass_size);


        for(int i=0; i < pass_size; i++){
            Passenger pass = passenger_queue.get(i);
            PassengerDisplay pd = new PassengerDisplay(pass);
            passDisplay.addComponent(pd, i);
        }

        int taxi_size = taxi_queue.size();
        PassTaxiGUI  taxiDisplay = new PassTaxiGUI("TAXIS ",taxi_size);
        for(int i=0; i < taxi_size; i++){
            Taxi taxis = taxi_queue.get(i);
            TaxiDisplay td = new TaxiDisplay(taxis);
            taxiDisplay.addComponent(td, i);
        }

        try {
            Thread.sleep(2000);
        }
        catch (Exception e) {}

        PassengerIterator pi = new PassengerIterator(passenger_queue, passDisplay); //passenger_queue
        TaxiIterator ti = new TaxiIterator(taxi_queue, taxiDisplay); //passenger_queue

        Thread thread2 = new Thread(new KioskWorker(1, pi, ti)); //kioskWorker
        try {
            Thread.sleep(1000);
        }
        catch (Exception e) {}
        thread2.start();

        try {
            Thread.sleep(200);
        }
        catch (Exception e) {}

        Thread thread3 = new Thread(new KioskWorker(2, pi, ti)); //kioskWorker
        try {
            Thread.sleep(1000);
        }
        catch (Exception e) {}
        thread3.start();

        //Run the program..

    	//now program just waits for user to use the SetClockGUI 
    }
    
}