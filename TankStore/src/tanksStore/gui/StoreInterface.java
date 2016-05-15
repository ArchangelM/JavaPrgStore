package tanksStore.gui;

import com.sun.deploy.panel.JavaPanel;
import tanksStore.TankStore;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.text.NumberFormat;

//public class StoreInterface implements ActionListener {
public class StoreInterface {

    TankStore shop;
    int productIndex = 0;

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
        panel.setLayout(new GridBagLayout());

        JLabel lName = new JLabel("Enter your name: ");
        JTextField tName = new JTextField();
        //tName.setText("Misha");
        tName.setColumns(25);
        panel.add(lName, new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.LINE_START,
                   GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
        panel.add(tName, new GridBagConstraints(1, 0, 1, 1, 0, 0, GridBagConstraints.LINE_START,
                0, new Insets(0, 0, 0, 0), 0, 0));


        JPanel products = new JPanel();
        products.setLayout(new GridLayout(3, 0));
        products.setBorder(BorderFactory.createLineBorder(Color.BLUE));

        JRadioButton firstProdButton = new JRadioButton();
        ActionListener rbActionListener = new RBActionListener();

        firstProdButton.setMnemonic(KeyEvent.VK_F);
        //firstProdButton.setActionCommand("Product 1");
        firstProdButton.setActionCommand(String.valueOf(0));
        firstProdButton.setText("First Product");
        firstProdButton.addActionListener(rbActionListener);
        firstProdButton.setSelected(true);

        JRadioButton secondProdButton = new JRadioButton();
        secondProdButton.setActionCommand(String.valueOf(1));
        secondProdButton.setText("Product 2");
        secondProdButton.addActionListener(rbActionListener);

        JRadioButton thirdProdButton = new JRadioButton();
        thirdProdButton.setActionCommand(String.valueOf(2));
        thirdProdButton.setText("Third Product");
        thirdProdButton.addActionListener(rbActionListener);



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

        products.add(firstProdButton);
        products.add(secondProdButton);
        products.add(thirdProdButton);

        panel.add(products, new GridBagConstraints(1, 1, 1, 1, 0, 0, GridBagConstraints.LINE_START,
                0, new Insets(10, 0, 10, 0), 30, 30));


        JLabel lQuantity = new JLabel("Enter quantity: ");
        //JTextField tQuantity = new JTextField();
        //for numbers only
        NumberFormat nf = NumberFormat.getNumberInstance();
        JFormattedTextField nQuantity = new JFormattedTextField(nf);
        nQuantity.setColumns(2);
        nQuantity.setValue(1);

        panel.add(lQuantity, new GridBagConstraints(0, 2, 1, 1, 0, 0, GridBagConstraints.LINE_START,
                0, new Insets(0, 0, 0, 0), 0, 0));
        panel.add(nQuantity, new GridBagConstraints(1, 2, 1, 1, 0, 0, GridBagConstraints.LINE_START,
                0, new Insets(0, 0, 0, 0), 0, 0));

        JButton buttonBuy = new JButton();
        buttonBuy.setText("Buy");
        buttonBuy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //ссылки уже и нету...
                String message = "Product added";
                JOptionPane.showMessageDialog(new JFrame(), message, "Сегодня вам повезло!",
                        JOptionPane.WARNING_MESSAGE);
            }
        });

        panel.add(buttonBuy, new GridBagConstraints(1, 3, 1, 1, 0, 0, GridBagConstraints.LINE_START,
                0, new Insets(10, 40, 10, 10), 0, 0));



        return panel;
    }

    private class RBActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            productIndex = Integer.parseInt(e.getActionCommand());
        }
    }

}
