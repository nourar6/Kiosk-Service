// View for MVC

import javax.swing.*;
import java.awt.*;

//KioskDisplayGUI
class KioskDisplayGUI extends JFrame
{
    //Constructor
	public KioskDisplayGUI()
	{
        //set up the frame for the kiosk
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(260,180);
        this.setLocationRelativeTo(null);
		this.setVisible(true);

	}
	// set the border layout center with the panel provided.
	public void addCenter(JPanel panel) {
		this.add(panel, BorderLayout.CENTER);
	}

}

