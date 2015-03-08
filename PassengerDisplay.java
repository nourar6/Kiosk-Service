import javax.swing.*;
import java.awt.*;

//using observer pattern
public class PassengerDisplay extends JPanel implements Observer {

    private Passenger passdata;
    private JTextField titleText = new JTextField(10);
    private JTextField destText = new JTextField(10);
    private JTextField passText = new JTextField(10);


    //sets up general gui
    public PassengerDisplay (Passenger passenger)
    {
        Font kioskFont = new Font("SansSerif", Font.BOLD, 14);

        this.passdata = passenger;
        passenger.registerObserver(this);

        this.add(destText);
        this.add(passText);

        destText.setEditable(false);
        destText.setHorizontalAlignment(JTextField.LEFT);
        destText.setFont(kioskFont);

        passText.setEditable(false);
        passText.setHorizontalAlignment(JTextField.LEFT);
        passText.setFont(kioskFont);

        update();

    }


    //update method gets and stores time in 24 hour hh:mm format
    public void update()
    {

        String text =  passdata.getDestination();
        destText.setText(text);
        int pass = passdata.getNo_of_pas();
        passText.setText(pass+ " people");

    }
}

