package tanksStore;

import tanksStore.utils.Init;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Osipov on 13.03.2016.
 */
public class TankStore {
    private Goods sklad;
    private List<SalesInvoice> salesInvoices;
    public final int PRIMARY_QUANTITY = 5;

    public TankStore() {
        salesInvoices = new ArrayList<>(PRIMARY_QUANTITY);
        Init.transactionGenerator(salesInvoices);
    }

    public List<SalesInvoice> getSalesInvoices() {
        return salesInvoices;
    }


}
