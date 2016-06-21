package tanksStore.serviceClasses;

import tanksStore.data.SalesInvoice;

import java.util.Date;

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
