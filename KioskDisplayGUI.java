// View for MVC

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//KioskDisplayGUI
class KioskDisplayGUI extends JFrame implements ActionListener {
    private JButton updateButton = new JButton("Start/Stop");
    Kiosk kiosk;
    //Constructor
    public KioskDisplayGUI() {
        //set up the frame for the kiosk
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(260, 180);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

    }

    // set the border layout center with the panel provided.
    public void addHeader(Kiosk kiosk) {
        this.kiosk = kiosk;
        JPanel buttonPanel = new JPanel();
        this.add(buttonPanel, BorderLayout.NORTH);
        buttonPanel.add(updateButton);
        updateButton.addActionListener(this);

    }

    public void addCenter(JPanel panel) {
        this.add(panel, BorderLayout.CENTER);
    }

    public void actionPerformed(ActionEvent e) {
        System.out.println(kiosk.number);
    }
}