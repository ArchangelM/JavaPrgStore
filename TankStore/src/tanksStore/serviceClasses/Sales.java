package tanksStore.serviceClasses;

import tanksStore.Purchase;
import tanksStore.SalesInvoice;

import javax.xml.soap.SAAJMetaFactory;
import java.util.Date;

/**
 * Created by Osipov on 13.03.2016.
 */
public class Sales {

    final long milliDay = 24*60*60*1000;

    public String getPurchaseForDays(SalesInvoice[] sales, long days) {
        String lastSales = "(";
        Date beginDate = new Date(System.currentTimeMillis() - days * milliDay);

        for (SalesInvoice tmpSale: sales
                ) {
            Date tmpDate = tmpSale.getDate();
            if(tmpDate.after(beginDate)) {
                lastSales = tmpSale.getInvoiceSum() + ", ";
            }
        }
        lastSales = lastSales.substring(0, lastSales.length()-3);
        lastSales = lastSales + ")";

        return lastSales;
    }
}
