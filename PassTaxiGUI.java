
import javax.swing.*;
import java.awt.*;

class PassTaxiGUI extends JFrame
{	

	public PassTaxiGUI(int size)
	{

        this.setLayout(new GridLayout(size, 1));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(100, 75 * size);
        this.setVisible(true);

	}

    public void addComponent(JPanel panel, int i) {
        panel.setLayout(new GridLayout(2,1));
        this.add(panel, i);
    }

    public void update()
    {}

}

