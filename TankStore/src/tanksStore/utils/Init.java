package tanksStore.utils;

import tanksStore.*;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Random;

public class Init {

    public static void goodsInit(List<Good> goods) {
        Good cur = new Tank("T34", "2345601", 1, 20000, 2, 50000);

        goods.add(cur);
        cur = new Tank("Tiger", "2345602", 2, 25000, 1, 55000);

        goods.add(cur);
        cur = new Armor("Passive", "2345701", 3, 2000, 5, 3000);
        goods.add(cur);
        cur = new Armor("Dynamic", "2345702", 4, 2000, 10, 4500);

        goods.add(cur);
        cur = new Ammo("Cummulative", "2345801", 5, 1000, 100, 50);
        goods.add(cur);
        cur = new Ammo("Piercing", "2345802", 6, 500, 80, 30);

        goods.add(cur);
        cur = new Engine("Maibah 1000 hp", "2345901", 7, 7000, 4, 50);
        goods.add(cur);
        cur = new Engine("B-2-34 500 hp", "2345902", 8, 3000, 3, 30);

    }

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
