package tanksStore.data;

import tanksStore.Client;
import tanksStore.Good;
import tanksStore.Purchase;

import java.util.Date;

/**
 * Created by Osipov on 07.03.2016.
 */
public class SalesInvoice {
    private int number;
    private Client client;
    private Date date;
    double invoiceSum;
    private Purchase purchase;

    //private int lineNumbers;
    //private Purchase[] purchases; //табличная часть расходной накладной

    /*
    public SalesInvoice(int number, Client client, Date date) {
        this(number, client, date, 1);
   }
   */

    public SalesInvoice(int number, Client client, Date date, Good good, int quantity) {
        this.number = number;
        this.client = client;
        this.date = date;
        purchase = new Purchase(good, quantity);
        invoiceSum = purchase.getSum();

    }

    /*
    public SalesInvoice(int number, Client client, Date date, int lineNumbers) {
        this.number = number;
        this.client = client;
        this.date = date;
        this.lineNumbers = lineNumbers;
        invoiceSum = 0;

        if (lineNumbers > 0) {
            purchases = new Purchase[lineNumbers];
        }

        invoiceSum = 0;

    }*/

    @Override
    public String toString() {
        return number + " " + client + " " + purchase.getName() + " " + purchase.getQuantity() + " " + invoiceSum;
    }

    public double getInvoiceSum() {
        return invoiceSum;
    }

    public Client getClient() {
        return client;
    }

    public Purchase getPurchase() {
        return purchase;
    }

    public Date getDate() {
        return date;
    }

    public String getGoodName() {
        return purchase.getName();
    }

    public String getGoodQuantity() {
        return String.valueOf(purchase.getQuantity());
    }
}
