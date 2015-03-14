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
        PassTaxiGUI  taxiDisplay = new PassTaxiGUI("TAXIS ",pass_size);
        for(int i=0; i < taxi_size; i++){
            Taxi taxis = taxi_queue.get(i);
            TaxiDisplay td = new TaxiDisplay(taxis);
            taxiDisplay.addComponent(td, i);
        }

        //create counter
//        Counter counter = new Counter (kiosk);


        try {
            Thread.sleep(2000);
        }
        catch (Exception e) {}

        PassengerIterator pi = new PassengerIterator(passenger_queue, passDisplay); //passenger_queue
        TaxiIterator ti = new TaxiIterator(taxi_queue, taxiDisplay); //passenger_queue

        Thread thread2 = new Thread(new KioskWorker(1, pi, ti)); //kioskWorker
        thread2.start();
        Thread thread3 = new Thread(new KioskWorker(2, pi, ti)); //kioskWorker
        thread3.start();
//        Thread thread4 = new Thread(new KioskWorker(2, pi, ti)); //kioskWorker
//        thread4.start();


//        KioskWorker task = new KioskWorker(1,i);
//        try {
//            Thread.sleep(1000);
//        }
//        catch (Exception e){}
//
//        KioskWorker task2 = new KioskWorker(2, i);
//
//        task.execute();
//        task2.execute();
//
//        try {
//            System.out.println(task.get()); //prints all prime numbers we have got
//            System.out.println("");
//        }
//        catch (Exception e) {
//            System.out.print(e.getMessage());
//        }
//        try {
//            System.out.println(task2.get()); //prints all prime numbers we have got
//            System.out.println("");
//        }
//        catch (Exception e) {
//            System.out.print(e.getMessage());
//        }
//        task.addPropertyChangeListener(
//            new PropertyChangeListener() {
//                public  void propertyChange(PropertyChangeEvent evt) {
//                    System.out.println(evt.getPropertyName());
//                    if ("progress".equals(evt.getPropertyName())) {
//
//                    }
//                }
//            });
//
//        task2.addPropertyChangeListener(
//            new PropertyChangeListener() {
//                public  void propertyChange(PropertyChangeEvent evt) {
//                    System.out.println(evt.getPropertyName());
//                    if ("progress".equals(evt.getPropertyName())) {
//
//                    }
//                }
//            });

//        for(int i = 0; 0 < pass_size; i++) {
//
//            try {
//                Thread.sleep(5000);
//            } catch (InterruptedException ex) {
//                Thread.currentThread().interrupt();
//            }
//            Passenger passenger1 = passenger_queue.remove(0);
//            Taxi taxi1 = taxi_queue.remove(0);
//            taxi_size = taxi_queue.size();
//            pass_size = passenger_queue.size();
//            taxiDisplay.getContentPane().remove(1);
//            passDisplay.getContentPane().remove(1);
//
//            passDisplay.revalidate();
//            taxiDisplay.revalidate();
//
//            Component[] header = taxiDisplay.getContentPane().getComponents();
//
//            JTextField pas_groups = new JTextField(15);
////            pas_groups.setEditable(false);
////            pas_groups.setText(header + "("+size+")");
////            pas_groups.setHorizontalAlignment(JTextField.LEFT);
////            pas_groups.setFont(kioskFont);
//
//            System.out.println(header[0].toString());
//            //header.setText("" + "(" + size + ")");
//            dd.setKioskdata(passenger1, taxi1);
//
//        }





        //Run the program..

    	//now program just waits for user to use the SetClockGUI 
    }
    
}