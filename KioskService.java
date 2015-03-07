public class KioskService
{
    public static void main(String[] args)
    {
    	//create kiosks for serving the Passenger Groups
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
    	
    	//create gui to allow users to set the size of groups.
    	SetKioskGUI  setKiosk = new SetKioskGUI(kiosk);
        setKiosk.setVisible(true);

    	//now program just waits for user to use the SetClockGUI 
    }
    
}