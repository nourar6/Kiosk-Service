import javax.swing.*;
import java.awt.*;

//using observer pattern
public class PassengerDisplay extends JPanel implements Observer {

    private Passenger passdata;
    private JTextField destText = new JTextField(10);
    private JTextField passText = new JTextField(10);


    //sets up general gui
    public PassengerDisplay (Passenger passenger)
    {
        //font of choice
        Font kioskFont = new Font("SansSerif", Font.BOLD, 14);

        //set the passenger data locally for future reference
        this.passdata = passenger;

        //set observer on Passenger
        passenger.registerObserver(this);

        //set basic settings on Destination Text field
        destText.setEditable(false);
        destText.setHorizontalAlignment(JTextField.LEFT);
        destText.setFont(kioskFont);

        //set basic settings on No of Passengers Text field
        passText.setEditable(false);
        passText.setHorizontalAlignment(JTextField.LEFT);
        passText.setFont(kioskFont);

        //add these textfields to the panel.
        this.add(destText);
        this.add(passText);

        //update the text for these text fields with the passenger data
        //update();

    }


    //update method gets and stores the Passenger Information in a container
    public void update()
    {
        // get the destination
        String text =  passdata.getDestination();
        //set the destination in frame
        destText.setText(text);
        //get the no of passengers
        int pass = passdata.getNo_of_pas();
        //set the amount of passengers in the frame
        passText.setText(pass+ " people");

    }
}

