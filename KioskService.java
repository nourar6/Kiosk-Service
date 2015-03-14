import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class KioskService
{
    public static void main(String[] args)
    {
    	//create kiosks for serving the Passenger Groups
        //TODO Set each Kiosk as a thread unless swing takes care of that for us will need to read into it.
    	Kiosk kiosk = new Kiosk(1);
        Kiosk kiosk2 = new Kiosk(2);

    	//create  window displays for each kiosk
        WindowDisplay dd = new WindowDisplay(kiosk);
        WindowDisplay dd2 = new WindowDisplay(kiosk2);

    	//create displays for kiosks
    	KioskDisplayGUI display = new KioskDisplayGUI();
        KioskDisplayGUI display2 = new KioskDisplayGUI();

        //add all the display kiosk panels
    	display.addCenter(dd);
        //add all the display kiosk panels
        display2.addCenter(dd2);



    	//create counter
    	Counter counter = new Counter (kiosk);

        //TODO Generate Passenger Queues
        ArrayList<Passenger> passenger_queue = new ArrayList<Passenger>();

        Passenger passenger = new Passenger();
        passenger.setDestination("Edinburgh");
        passenger.setNo_of_pas(3);
        passenger_queue.add(passenger);

        passenger = new Passenger();
        passenger.setDestination("Manchester");
        passenger.setNo_of_pas(4);
        passenger_queue.add(passenger);

        passenger = new Passenger();
        passenger.setDestination("Newcastle");
        passenger.setNo_of_pas(3);
        passenger_queue.add(passenger);

        passenger = new Passenger();
        passenger.setDestination("London");
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


//        SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>(passenger_queue) {
//            @Override
//            protected Void doInBackground() throws Exception {
//                // Simulate doing something useful.
//                for(int i = 0; 0 < pass_size; i++) {
//
//                    try {
//                        Thread.sleep(5000);
//                    } catch (InterruptedException ex) {
//                        Thread.currentThread().interrupt();
//                    }
//                    Passenger passenger1 = passenger_queue.remove(0);
//                    Taxi taxi1 = taxi_queue.remove(0);
//                    taxi_size = taxi_queue.size();
//                    pass_size = passenger_queue.size();
//                    taxiDisplay.getContentPane().remove(0);
//                    passDisplay.getContentPane().remove(0);
//
//                    passDisplay.revalidate();
//                    taxiDisplay.revalidate();
//
//                    dd.setKioskdata(passenger1, taxi1);
//
//                }
//
//                return null;
//            }
//        };
//
//        SwingWorker<Void, Void> worker2 = new SwingWorker<Void, Void>() {
//            @Override
//            protected Void doInBackground() throws Exception {
//                // Simulate doing something useful.
//                for(int i = 0; 0 < pass_size; i++) {
//
//                    try {
//                        Thread.sleep(5000);
//                    } catch (InterruptedException ex) {
//                        Thread.currentThread().interrupt();
//                    }
//                    Passenger passenger1 = passenger_queue.remove(0);
//                    Taxi taxi1 = taxi_queue.remove(0);
//                    taxi_size = taxi_queue.size();
//                    pass_size = passenger_queue.size();
//                    taxiDisplay.getContentPane().remove(0);
//                    passDisplay.getContentPane().remove(0);
//
//                    passDisplay.revalidate();
//                    taxiDisplay.revalidate();
//
//                    dd2.setKioskdata(passenger1, taxi1);
//
//                }
//
//                return null;
//            }
//        };
//
//        worker.execute();
//        worker2.execute();

        for(int i = 0; 0 < pass_size; i++) {

            try {
                Thread.sleep(5000);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            Passenger passenger1 = passenger_queue.remove(0);
            Taxi taxi1 = taxi_queue.remove(0);
            taxi_size = taxi_queue.size();
            pass_size = passenger_queue.size();
            taxiDisplay.getContentPane().remove(1);
            passDisplay.getContentPane().remove(1);

            passDisplay.revalidate();
            taxiDisplay.revalidate();

            Component[] header = taxiDisplay.getContentPane().getComponents();

            JTextField pas_groups = new JTextField(15);
            pas_groups.setEditable(false);
            pas_groups.setText(header + "("+size+")");
            pas_groups.setHorizontalAlignment(JTextField.LEFT);
            pas_groups.setFont(kioskFont);
            header[0].add(pas_groups);
            System.out.println(header[0].toString());
            //header.setText("" + "(" + size + ")");
            dd.setKioskdata(passenger1, taxi1);

        }





        //Run the program..

    	//now program just waits for user to use the SetClockGUI 
    }
    
}