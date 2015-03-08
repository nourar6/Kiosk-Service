import javax.swing.*;
import java.awt.*;
class KioskDisplayGUI extends JFrame
{			
	public KioskDisplayGUI()
	{	
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(260,180);
		this.setVisible(true);

	}
	
	public void addCenter(JPanel panel) {
		this.add(panel, BorderLayout.CENTER);
	}

	public void addSouth(JPanel panel) {
		this.add(panel, BorderLayout.SOUTH);
	}
}

