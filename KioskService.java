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
        ArrayList<ArrayList<String>> passenger_queue = new ArrayList<ArrayList<String>>();
        ArrayList<String> passenger_group = new ArrayList<String>();
        passenger_group.add("Edinburgh");
        passenger_group.add("3");
        passenger_queue.add(passenger_group);
        passenger_group = new ArrayList<String>();
        passenger_group.add("Manchester");
        passenger_group.add("4");
        passenger_group = new ArrayList<String>();
        passenger_group.add("Newcastle");
        passenger_group.add("3");
        passenger_group = new ArrayList<String>();
        passenger_group.add("London");
        passenger_group.add("2");

        //TODO Generate Taxi Queues

        //create gui to allow users to set the size of groups.
        PassTaxiGUI  setPassTaxiGUI = new PassTaxiGUI(kiosk, passenger_queue);
        setPassTaxiGUI.setVisible(true);

        //Run the program..

    	//now program just waits for user to use the SetClockGUI 
    }
    
}