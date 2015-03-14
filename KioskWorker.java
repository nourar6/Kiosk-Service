//Controller for MVC
import java.util.Iterator;

public class KioskWorker implements Runnable  {
    private int number;

    Iterator<Passenger> passenger_iterator;
    private int passenger_queue;
    private PassTaxiGUI pass_display;

    Iterator<Taxi> taxi_iterator;
    private int taxi_queue;
    private PassTaxiGUI taxi_display;
    private Kiosk kiosk;

    public KioskWorker(int number, PassengerIterator pi, TaxiIterator ti) {
        //initialize
        this.passenger_iterator = pi.fetch();
        this.number = number;
        this.passenger_queue = pi.queue_length();
        this.pass_display = pi.passDisplay();

        this.taxi_iterator = ti.fetch();
        this.taxi_queue = ti.queue_length();
        this.taxi_display = ti.taxiDisplay();


        this.kiosk = new Kiosk(number);
        WindowDisplay dd = new WindowDisplay(kiosk);
        KioskDisplayGUI display = new KioskDisplayGUI();
        display.addCenter(dd);

    }

    public void run() {
        Logger logger = Logger.getInstance();

        while(passenger_iterator.hasNext()) {
            Passenger passenger = passenger_iterator.next();
            logger.log(number + ": " + passenger.getDestination());
            passenger_iterator.remove();

            kiosk.setDestination(passenger.getDestination());
            kiosk.setNo_of_pas(passenger.getNo_of_pas());

            if (taxi_iterator.hasNext()) {
                Taxi taxi = taxi_iterator.next();

                logger.log(number + ": " + taxi.getTaxi());

                kiosk.setTaxi(taxi.getTaxi());
                taxi_iterator.remove();
                taxi_display.getContentPane().remove(1);
                taxi_display.revalidate();
            }

            pass_display.getContentPane().remove(1);
            pass_display.revalidate();

            try {
                Thread.sleep(3000 * passenger.getNo_of_pas());
            }
            catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }

            kiosk.setDestination("");
            kiosk.setNo_of_pas(0);
            kiosk.setTaxi("");


        }
        taxi_display.revalidate();
        pass_display.revalidate();

        logger.close();
    }

//    @Override
//    public ArrayList<Passenger>  doInBackground() {
//
//        while (passenger_queue.hasNext()) {
//            Passenger passenger = passenger_queue.next();
//            System.out.println(number + " " + passenger.getDestination());
//            passenger_queue.remove();
//            notify(passenger_queue);
//            try {
//                Thread.sleep(passenger.getNo_of_pas()*1000);
//            }
//            catch (Exception e){
//
//            }
//
//        }
//        return passenger_queue2;
//    }

}



