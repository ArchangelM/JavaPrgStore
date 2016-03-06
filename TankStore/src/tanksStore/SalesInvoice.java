package tanksStore;

import java.util.Date;

/**
 * Created by Osipov on 07.03.2016.
 */
public class SalesInvoice {
    private int number;
    private Client client;
    private Date date;
    private int lineNumbers;
    double invoiceSum;

    private Purchase[] purchases; //табличная часть расходной накладной

    public SalesInvoice(int number, Client client, Date date) {
        this(number, client, date, 1);
   }

    public SalesInvoice(int number, Client client, Date date, int lineNumbers) {
        this.number = number;
        this.client = client;
        this.date = date;
        this.lineNumbers = lineNumbers;

        if (lineNumbers > 0) {
            purchases = new Purchase[lineNumbers];
        }

        invoiceSum = 0;

    }


    public Client getClient() {
        return client;
    }

    public Purchase[] getPurchases() {
        return purchases;
    }

    public Date getDate() {
        return date;
    }
}
