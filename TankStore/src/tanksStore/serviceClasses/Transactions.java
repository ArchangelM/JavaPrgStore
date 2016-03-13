package tanksStore.serviceClasses;

import tanksStore.DayTotalSale;
import tanksStore.SalesInvoice;

import java.util.Date;

/**
 * Created by Osipov on 13.03.2016.
 */
public class Transactions {
    private DayTotalSale[] dayTotalSales;

    public DayTotalSale daySales(Date date) {
        int i = 0;
        Date tmpDate;

         do {
             tmpDate = dayTotalSales[i].getDate();
             i++;
         } while(!tmpDate.equals(date) && (i < dayTotalSales.length));

        if (tmpDate.equals(date)) return dayTotalSales[i-1];
        return null;
    }

    public void printDayTransaction(SalesInvoice sales, Date date) {


    }
}
