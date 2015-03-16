// View for MVC

import javax.swing.*;
import java.awt.*;

//KisokDisplayGUI
class KioskDisplayGUI extends JFrame
{
    //Constructor
	public KioskDisplayGUI()
	{
        pack();
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(260,180);
        this.setLocationRelativeTo(null);
		this.setVisible(true);

	}
	
	public void addCenter(JPanel panel) {
		this.add(panel, BorderLayout.CENTER);
	}

	public void addSouth(JPanel panel) {
		this.add(panel, BorderLayout.SOUTH);
	}
}

