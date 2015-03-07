
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

class PassTaxiGUI extends JFrame implements ActionListener
{	
	private Kiosk kioskdata;

	private JButton updateButton = new JButton("Update");

	public PassTaxiGUI(Kiosk kiosk, ArrayList<ArrayList<String>> passenger_queue)
	{	
		this.kioskdata = kiosk;
		
		this.add(BorderLayout.NORTH, new JLabel("Enter time here"));
		JPanel panel = new JPanel(new GridLayout(2,2));
		this.add(BorderLayout.CENTER, panel);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.add(updateButton);	
		updateButton.addActionListener(this);
		this.add(BorderLayout.SOUTH, buttonPanel);
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
				
		this.setSize(200,120);
		this.setLocation(200, 100);
	}


	public void actionPerformed (ActionEvent e)
	{
		String destination = "Dest";
		int no_of_pas = 1;
        String taxi = "BY12 4RR";

        kioskdata.setNo_of_pas(no_of_pas);
        kioskdata.setDestination(destination);
        kioskdata.setTaxi(taxi);

	}
	

}

