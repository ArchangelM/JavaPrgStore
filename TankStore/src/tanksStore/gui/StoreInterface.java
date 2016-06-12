package tanksStore.gui;

import tanksStore.Client;
import tanksStore.Good;
import tanksStore.TankStore;
import tanksStore.data.SalesInvoice;

import java.util.Calendar;
import java.util.GregorianCalendar;
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
    public JMenuBar barMenu;
    private JMenu menu;
    private JMenuItem menuItem;


    private JPanel tablePanel;
    private JPanel salePanel;

    final int PRIMARY_QUANTITY = 5;

    public StoreInterface(TankStore shop) {
        this.shop = shop;

        //JFrame frame = new JFrame();
        frame = new JFrame();
        frame.setMinimumSize(new Dimension(800, 600));
        frame.setLocation(100, 100);

        barMenu = new JMenuBar();
        menu = new JMenu("My menu");
        menu.setMnemonic(KeyEvent.VK_M);

        menuItem = new JMenuItem("Tank buy");
        menuItem.setMnemonic(KeyEvent.VK_T);


        menuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                viewSaleForm();
            }



        });

        menu.add(menuItem);
        barMenu.add(menu);
        frame.setJMenuBar(barMenu);

        //frame.getContentPane().add(CreateSellingPanel());
        //frame.getContentPane().add(CreateTablePanel());

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }

    private JPanel CreateSellingPanel(List<Good> goods) {
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
        products.setLayout(new GridLayout(4, 0));
        products.setBorder(BorderFactory.createLineBorder(Color.BLUE));

        JRadioButton[] buttons = new JRadioButton[goods.size()];
        buttons[0] = new JRadioButton(goods.get(0).getName());
        buttons[0].setMnemonic(KeyEvent.VK_3);
        buttons[0].setActionCommand(goods.get(0).getArticul());
        //buttons[0].setText(goods.get(0).getName());
        buttons[0].setSelected(true);

        ButtonGroup productGroup = new ButtonGroup();
        productGroup.add(buttons[0]);
        products.add(buttons[0]);

        for (int i = 1; i < goods.size(); i++) {
            buttons[i] = new JRadioButton(goods.get(i).getName());
            buttons[i].setActionCommand(goods.get(i).getArticul());
            //buttons[i].setText(goods.get(i).getName());
            productGroup.add(buttons[i]);
            products.add(buttons[i]);

        }

        //Register a listener for the radio buttons.
        /*firstProdButton.addActionListener(this);
        secondProdButton.addActionListener(this);
        thirdProdButton.addActionListener(this);
        */
        //Group the radio buttons.

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
                Calendar calendar = new GregorianCalendar();

                shop.addSaleInvoice(new SalesInvoice(1, shop.addClient(shop.getClients().size()+1, "Gadya1"),
                                    calendar.getTime(), goods.get(2), 2));
                //ссылки уже и нету... Date date, Good good, int quantity
                String message = "Product added";
                JOptionPane.showMessageDialog(new JFrame(), message, "Сегодня вам повезло!",
                        JOptionPane.WARNING_MESSAGE);
                viewTable();
            }



        });

        panel.add(buttonBuy, new GridBagConstraints(1, 3, 1, 1, 0, 0, GridBagConstraints.LINE_START,
                0, new Insets(10, 40, 10, 10), 0, 0));

        panel.setEnabled(true);

        return panel;
    }

    private JPanel CreateTablePanel() {

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        String[] header = new String[] {"#", "Date", "Client", "Good", "Quantity", "Summ"};
        Object[][] data = new Object[shop.getSalesInvoices().size()][];

        for(int i = 0; i < data.length;i++) {
            data[i] = new Object[header.length];
        }

        listTransform(shop.getSalesInvoices(), data);

        JTable table = new JTable(data, header);
        table.getColumnModel().getColumn(1).setPreferredWidth(200);

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


    public void createPanels(List<Good> goods) {
        //salePanel = CreateSellingPanel(goods);
        //frame.getContentPane().add(salePanel);
        //salePanel.setEnabled(false);
        tablePanel = CreateTablePanel();
        frame.getContentPane().add(tablePanel);

        frame.pack();
    }

    public void viewSaleForm() {

        //tablePanel.setEnabled(false);
        //salePanel.setEnabled(true);

        frame.remove(tablePanel);
        salePanel = CreateSellingPanel(shop.getGoods());
        frame.getContentPane().add(salePanel);
        frame.pack();


    }

    public void viewTable() {

        //salePanel.setEnabled(false);
        //tablePanel.setEnabled(true);
        frame.remove(salePanel);
        tablePanel = CreateTablePanel();
        frame.getContentPane().add(tablePanel);
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
