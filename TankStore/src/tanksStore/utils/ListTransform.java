package tanksStore.utils;

import tanksStore.SalesInvoice;

import java.util.List;

public class ListTransform {
    public static void listTransform(List<SalesInvoice> si, Object[][] table) {
        for(int i = 0; i < si.size();i++) {
            //{"#", "Date", "Client", "Good", "Number", "Summ"};
            table[i][0] = i;
            table[i][1] = si.get(i).getDate();
            table[i][2] = si.get(i).getClient();
            table[i][3] = si.get(i).getGoodName();
            table[i][4] = si.get(i).getGoodQuantity();
            table[i][5] = si.get(i).getInvoiceSum();
        }
    }
}
