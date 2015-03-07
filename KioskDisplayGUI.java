import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class KioskDisplayGUI extends JFrame
{			
	public KioskDisplayGUI()
	{	
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(700,220);
		this.setVisible(true);

	}
	
	public void addCenter(JPanel panel) {
		this.add(panel, BorderLayout.CENTER);
	}

	public void addSouth(JPanel panel) {
		this.add(panel, BorderLayout.SOUTH);
	}
}

