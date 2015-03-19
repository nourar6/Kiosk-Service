import java.util.ArrayList;

// MAIN Class for Setting up everything Execute this file.
public class KioskService
{
    // main function
    public static void main(String[] args)
    {
        int number = 0;
        NumberOfKioskGUI nok = new NumberOfKioskGUI();
        nok.setVisible(true);
        while(number == 0){
            number = nok.getNumber();
            try { System.out.println(number);Thread.sleep(500); }
            catch (Exception e) {}
        }
        System.out.println(number);

        // Passenger ArrayList similar to part 1 of coursework
        ArrayList<Passenger> passenger_queue = new ArrayList<Passenger>();

        // just add static items to list
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

        // Taxi ArrayList similar to part 1 of coursework
        ArrayList<Taxi> taxi_queue = new ArrayList<Taxi>();

        // again adding static data to list
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

        // caclulate the size of the queue to have it as a header on the queue to see the number of passengers remaining
        int pass_size = passenger_queue.size();
        // Set up the GUI Window with the information
        PassTaxiGUI  passDisplay = new PassTaxiGUI("PASSENGER GROUPS ",pass_size);

        // for each member of the list we are going to add them to our graphical queue
        for(int i=0; i < pass_size; i++){
            Passenger pass = passenger_queue.get(i);
            //send our passenger object to the PassengerDisplay to format the information into a component for viewing
            PassengerDisplay pd = new PassengerDisplay(pass);
            //add the component to the Graphical queue
            passDisplay.addComponent(pd, i);
        }

        // same as above but for our taxi queue
        int taxi_size = taxi_queue.size();
        PassTaxiGUI  taxiDisplay = new PassTaxiGUI("TAXIS ",taxi_size);
        for(int i=0; i < taxi_size; i++){
            Taxi taxis = taxi_queue.get(i);
            TaxiDisplay td = new TaxiDisplay(taxis);
            taxiDisplay.addComponent(td, i);
        }

        // Generate a thread safe sharable iterator used by the threads to process the queue
        PassengerIterator pi = new PassengerIterator(passenger_queue, passDisplay); //passenger_queue
        TaxiIterator ti = new TaxiIterator(taxi_queue, taxiDisplay); //passenger_queue
        for(int i=1; i< number+1; i++){
            //wait 2 seconds to allow user to move the loaded windows that are on top of one another.
            try { Thread.sleep(2000); }
            catch (Exception e) {}

            //create thread1 which will be our first window
            Thread thread = new Thread(new KioskWorker(i, pi, ti)); //kioskWorker
//            try { Thread.sleep(1000); }
//            catch (Exception e) {}
            thread.start(); // start the thread after a delay

        }


    }
    
}