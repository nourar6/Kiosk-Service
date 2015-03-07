
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class SetKioskGUI extends JFrame implements ActionListener
{	
	private Kiosk kioskdata;

	private JTextField hours = new JTextField();
	private JTextField mins = new JTextField();
	private JButton updateButton = new JButton("Update");

	public SetKioskGUI(Kiosk kiosk)
	{	
		this.kioskdata = kiosk;
		
		this.add(BorderLayout.NORTH, new JLabel("Enter time here"));
		JPanel panel = new JPanel(new GridLayout(2,2));
//		panel.add(new JLabel("Hours (0 - 23)"));
//		panel.add(hours);
//		panel.add(new JLabel("Minutes"));
//		panel.add(mins);
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

