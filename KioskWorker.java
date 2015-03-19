//Controller for MVC
import javax.swing.*;
import java.awt.*;
import java.util.Iterator;

// Main Controller for Updating the Views
public class KioskWorker implements Runnable  {

    private volatile boolean status;

    // instantiate variables
    private int number;
    PassengerIterator pi;
    Iterator<Passenger> passenger_iterator;
    private int passenger_queue;
    private PassTaxiGUI pass_display;

    TaxiIterator ti;
    Iterator<Taxi> taxi_iterator;
    private int taxi_queue;
    private PassTaxiGUI taxi_display;
    private Kiosk kiosk;

    // constructor
    public KioskWorker(int number, PassengerIterator pi, TaxiIterator ti) {
        // initialize
        this.pi = pi;
        this.passenger_iterator = pi.fetch();
        this.number = number;
        this.passenger_queue = pi.queue_length();
        this.pass_display = pi.passDisplay();

        this.ti = ti;
        this.taxi_iterator = ti.fetch();
        this.taxi_queue = ti.queue_length();
        this.taxi_display = ti.taxiDisplay();
        this.kiosk = new Kiosk(number);

        WindowDisplay wd = new WindowDisplay(kiosk);

        KioskDisplayGUI display = new KioskDisplayGUI();
        display.addHeader(kiosk);
        display.addCenter(wd);

    }

    // execute thread
    public void run(){

        // get Loggers instance
        Logger logger = Logger.getInstance();
        // begin loop of passenger queue
        while(passenger_iterator.hasNext()) {
            this.status = kiosk.getStatus();
            while(!this.status){
                this.status = kiosk.getStatus();
                try { System.out.println("PAUSED "+ number + " " + this.status);
                    Thread.sleep(500);
                      }
                catch (Exception e) {}
            }

            // check taxi is available
            if (taxi_iterator.hasNext()) {
                // get the taxi
                Taxi taxi = taxi_iterator.next();
                // log to the logger
                logger.log("Window" + number + ": " + taxi.getTaxi());
                // set the taxi to the window that the passengers will be using
                kiosk.setTaxi(taxi.getTaxi());
                // remove the taxi from the queue
                taxi_iterator.remove();

                // remove the taxi from the gui
                taxi_display.getContentPane().remove(0);
                update_header("TAXIS", ti.decrement(), taxi_display);
                taxi_display.getContentPane().remove(1);
                taxi_display.revalidate();
                taxi_display.setVisible(true);
            }
            else {
                // if no taxis available stop the loop
                break;
            }
            // get the passenger in queue
            Passenger passenger = passenger_iterator.next();
            // log the passenger info to the logger
            logger.log("Window" + number + ": " + passenger.getDestination());
            // remove the passenger from the queue
            passenger_iterator.remove();
            passenger_queue--;
            //remove the passenger from the gui passenger queue
            pass_display.getContentPane().remove(0);
            update_header("PASSENGER QUEUE", pi.decrement(), pass_display);
            pass_display.getContentPane().remove(1);
            pass_display.revalidate();
            pass_display.setVisible(true);
            // update the kiosk to show the passenger
            kiosk.setDestination(passenger.getDestination());
            kiosk.setNo_of_pas(passenger.getNo_of_pas());

            //repaint the displays to make sure they are most up-to-date
            taxi_display.repaint();
            pass_display.repaint();

            // sleep for 3 * no_of_pass to simulate paying at kiosk
            // allows workers to pick up passengers in a random order
            // instead of the usual 1-2-1-2-1-2
            try {
                Thread.sleep(3000 * passenger.getNo_of_pas());
            }
            catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
            //after wait has finished clear the kiosk for next passenger
            kiosk.setDestination("");
            kiosk.setNo_of_pas(0);
            kiosk.setTaxi("");

            try {
                Thread.sleep(750);
            }
            catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }

        }
        taxi_display.revalidate();
        pass_display.revalidate();

        logger.close();

    }

    public void restart(){
        run();
    }

    // function to update the header on the display to show the remaining number in the queue
    public void update_header(String header, int size, JFrame display)
    {
        // same set up as in PassTaxiGUI constructor
        Font kioskFont = new Font("SansSerif", Font.BOLD, 14);
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1,1));

        JTextField pas_groups = new JTextField(15);
        pas_groups.setEditable(false);
        pas_groups.setText(header + " ("+size+")");
        pas_groups.setHorizontalAlignment(JTextField.LEFT);
        pas_groups.setFont(kioskFont);
        panel.add(pas_groups);

        display.add(panel, 0);
        display.setVisible(true);

    }

}



