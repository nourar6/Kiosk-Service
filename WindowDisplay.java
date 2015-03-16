//Another View for MVC

import javax.swing.*;
import java.awt.*;

//using observer pattern
public class WindowDisplay extends JPanel implements Observer
{
    //local vars
	private Kiosk kioskdata;
    private JTextField kioskText = new JTextField(10);
	private JTextField destText = new JTextField(20);
    private JTextField passText = new JTextField(10);
    private JTextField taxiText = new JTextField(10);


	//constructor sets up general gui
	public WindowDisplay (Kiosk kiosk)
	{
        //FONT of Choice
        Font kioskFont = new Font("SansSerif", Font.BOLD, 14);

        // set up the local vars
		this.kioskdata = kiosk;
        kiosk.registerObserver(this);

        //set up the Text Fields for the kiosk these will update when a worker picks up the data from the queues
        kioskText.setEditable(false);
        kioskText.setHorizontalAlignment(JTextField.CENTER);
        kioskText.setFont(kioskFont);
        kioskText.setText("Window "+ kioskdata.number);
		destText.setEditable(false);
		destText.setHorizontalAlignment(JTextField.CENTER);
		destText.setFont(kioskFont);

        passText.setEditable(false);
        passText.setHorizontalAlignment(JTextField.CENTER);
        passText.setFont(kioskFont);

        taxiText.setEditable(false);
        taxiText.setHorizontalAlignment(JTextField.CENTER);
        taxiText.setFont(kioskFont);

        this.add(kioskText);
        this.add(destText);
        this.add(passText);
        this.add(taxiText);

		update();

	}

	//update method stores the text data to the textfields
	public void update()
	{

		String text =  kioskdata.getDestination();
		destText.setText("Destination: " + text);
        int pass = kioskdata.getNo_of_pas();
        passText.setText("Passengers: " + pass);
        String taxi = kioskdata.getTaxi();
        taxiText.setText("Taxi: " + taxi);
	}
}
