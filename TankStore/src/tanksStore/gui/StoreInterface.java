package tanksStore.gui;

import com.sun.deploy.panel.JavaPanel;
import tanksStore.SalesInvoice;
import tanksStore.TankStore;
import tanksStore.utils.ListTransform;

import java.util.List;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.text.NumberFormat;

import static tanksStore.utils.ListTransform.listTransform;

//public class StoreInterface implements ActionListener {
public class StoreInterface {

    private TankStore shop;
    public JFrame frame;
    final int PRIMARY_QUANTITY = 5;

    public StoreInterface(TankStore shop) {
        this.shop = shop;

        //JFrame frame = new JFrame();
        frame = new JFrame();
        frame.setMinimumSize(new Dimension(800, 600));
        frame.setLocation(100, 100);

        //frame.getContentPane().add(CreateSellingPanel());
        //frame.getContentPane().add(CreateTablePanel());

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

    private JPanel CreateTablePanel() {


        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        String[] header = new String[] {"#", "Date", "Client", "Good", "Quantity", "Summ"};
        Object[][] data = new Object[PRIMARY_QUANTITY][];

        for(int i = 0; i < data.length;i++) {
            data[i] = new Object[header.length];
        }

        listTransform(shop.getSalesInvoices(), data);

        JTable table = new JTable(data, header);
        table.setFillsViewportHeight(true);
        JScrollPane scrollPane = new JScrollPane(table);

        panel.add(scrollPane, new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.LINE_START,
                GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
        /*
        panel.add(table.getTableHeader(), new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.LINE_START,
                GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
        panel.add(table, new GridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.LINE_START,
                GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
        */


        return panel;
    }

    public void viewTable() {
        frame.getContentPane().add(CreateTablePanel());
        frame.pack();

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
