package tanksStore.utils;

import tanksStore.Client;
import tanksStore.Good;
import tanksStore.SalesInvoice;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Random;

public class Init {

    public static void transactionGenerator(List <SalesInvoice> si) {
        Random random = new Random(107894579);
        Calendar calendar = new GregorianCalendar();

       // Good(String name, String articul, int index, double price, int quantity, double weight)

        for(int i = 0; i < 5;i++) {
            Good good = new Good("Tank1", "123", i, 45.67d, random.nextInt(4), 20d);
            try {
                SalesInvoice curSI = new SalesInvoice(i + 1, new Client(i, "Gadya"), calendar.getTime(), good, random.nextInt(5) + 1);
                //SalesInvoice(int number, Client client, Date date, Good good, int quantity)
                Thread.sleep(500);
                si.add(i, curSI);
            } catch(Exception e) {
                System.out.println(e);
            }

        }
    }
}
