package tanksStore.gui;

import com.sun.deploy.panel.JavaPanel;
import tanksStore.TankStore;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

//public class StoreInterface implements ActionListener {
public class StoreInterface {

    TankStore shop;

    public StoreInterface(TankStore shop) {
        this.shop = shop;

        JFrame frame = new JFrame();
        frame.setMinimumSize(new Dimension(800, 600));
        frame.setLocation(100, 100);

        frame.getContentPane().add(CreateSellingPanel());

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }

    private JPanel CreateSellingPanel() {
        JPanel panel = new JPanel();

        JLabel lName = new JLabel("Enter your name: ");
        JTextField tName = new JTextField();

        JRadioButton firstProdButton = new JRadioButton();
        firstProdButton.setMnemonic(KeyEvent.VK_F);
        firstProdButton.setActionCommand("Product 1");
        firstProdButton.setText("First Product");
        firstProdButton.setSelected(true);

        JRadioButton secondProdButton = new JRadioButton();
        secondProdButton.setActionCommand("Product 2");
        secondProdButton.setText("Product2");

        JRadioButton thirdProdButton = new JRadioButton();
        thirdProdButton.setActionCommand("Product 3");
        thirdProdButton.setText("Third Product");

        //Register a listener for the radio buttons.
        /*firstProdButton.addActionListener(this);
        secondProdButton.addActionListener(this);
        thirdProdButton.addActionListener(this);
        */
        //Group the radio buttons.
        ButtonGroup productGroup = new ButtonGroup();
        productGroup.add(firstProdButton);
        productGroup.add(secondProdButton);
        productGroup.add(thirdProdButton);


        JLabel lQuantity = new JLabel("Enter quantity: ");
        JTextField tQuantity = new JTextField();

        JButton button = new JButton();
        button.setText("Buy");
        button.setLocation(300, 300);
        button.setActionCommand("Buy1");

        panel.add(lName);
        panel.add(tName);

        panel.add(firstProdButton);
        panel.add(secondProdButton);
        panel.add(thirdProdButton);

        panel.add(lQuantity);
        panel.add(tQuantity);

        panel.add(button);

        return panel;
    }


    /** Listens to the radio buttons. */
/*    @Override
    public void actionPerformed(ActionEvent e) {
        picture.setIcon(createImageIcon("images/"
                + e.getActionCommand()
                + ".gif"));
    }
    */
}
