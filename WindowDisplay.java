import java.awt.*;
import javax.swing.*;
import javax.swing.JTextField;

//using observer pattern
public class WindowDisplay extends JPanel implements Observer
{
	private Kiosk kioskdata;
    private JTextField kioskText = new JTextField(10);
	private JTextField destText = new JTextField(10);
    private JTextField passText = new JTextField(10);
    private JTextField taxiText = new JTextField(10);


	//sets up general gui
	public WindowDisplay (Kiosk kiosk)
	{
        Font kioskFont = new Font("SansSerif", Font.BOLD, 14);

		this.kioskdata = kiosk;
        kiosk.registerObserver(this);
        this.add(kioskText);
        this.add(destText);
        this.add(passText);
        this.add(taxiText);


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
		update();

	}	
	//update method gets and stores time in 24 hour hh:mm format
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
