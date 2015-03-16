
import javax.swing.*;
import java.awt.*;

class PassTaxiGUI extends JFrame
{	

	public PassTaxiGUI(String header, int size)
	{
        Font kioskFont = new Font("SansSerif", Font.BOLD, 14);
        pack();
        this.setLayout(new GridLayout(size, 1));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setSize(200, 75 * size);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1,1));

        JTextField pas_groups = new JTextField(15);
        pas_groups.setEditable(false);
        pas_groups.setText(header + "("+size+")");
        pas_groups.setHorizontalAlignment(JTextField.LEFT);
        pas_groups.setFont(kioskFont);
        panel.add(pas_groups);
        this.add(panel, 0);
        this.setVisible(true);
	}

    public void addComponent(JPanel panel, int i) {
        pack();
        panel.setLayout(new GridLayout(2,1));
        this.add(panel, i+1);
        this.setVisible(true);

    }

    public void update()
    {}

}

