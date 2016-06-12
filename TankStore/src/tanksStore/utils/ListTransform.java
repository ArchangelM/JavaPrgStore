package tanksStore.utils;

import tanksStore.data.SalesInvoice;

import java.text.SimpleDateFormat;
import java.util.List;

public class ListTransform {

    public static void listTransform(List<SalesInvoice> si, Object[][] table) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");

        for(int i = 0; i < si.size();i++) {
            //{"#", "Date", "Client", "Good", "Number", "Summ"};
            table[i][0] = i;
            table[i][1] = sdf.format(si.get(i).getDate());
            table[i][2] = si.get(i).getClient();
            table[i][3] = si.get(i).getGoodName();
            table[i][4] = si.get(i).getGoodQuantity();
            table[i][5] = si.get(i).getInvoiceSum();
        }
    }
}
