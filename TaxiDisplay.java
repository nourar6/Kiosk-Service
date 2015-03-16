import javax.swing.*;
import java.awt.*;

//SAME AS PassengerDisplay
//using observer pattern
public class TaxiDisplay extends JPanel implements Observer {

    private Taxi taxidata;
    private JTextField taxiText = new JTextField(10);



    //sets up general gui
    public TaxiDisplay (Taxi taxi)
    {
        Font kioskFont = new Font("SansSerif", Font.BOLD, 14);

        this.taxidata = taxi;
        taxi.registerObserver(this);

        this.add(taxiText);

        taxiText.setEditable(false);
        taxiText.setHorizontalAlignment(JTextField.LEFT);
        taxiText.setFont(kioskFont);

        update();

    }

    //update method gets and stores time in 24 hour hh:mm format
    public void update()
    {
        String text =  taxidata.getTaxi();
        taxiText.setText(text);
    }
}

