
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
class NumberOfKioskGUI extends JFrame implements ActionListener
{
    private int number =0;

    private JTextField numberField = new JTextField();

    private JButton goButton = new JButton("Go!");

    public NumberOfKioskGUI()
    {
        JPanel panel = new JPanel(new GridLayout(2,2));
        panel.add(new JLabel("Please enter the number of workers you would like (1-5)."));
        panel.add(numberField);

        this.add(BorderLayout.CENTER, panel);

        JPanel startPanel = new JPanel();
        startPanel.add(goButton);
        goButton.addActionListener(this);
        this.add(BorderLayout.SOUTH, startPanel);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.setSize(200,120);
        this.setLocation(200, 100);

    }

    public int getNumber(){
        return this.number;
    }

    public void actionPerformed (ActionEvent e)
    {
        number = Integer.parseInt(numberField.getText());
    }


}

