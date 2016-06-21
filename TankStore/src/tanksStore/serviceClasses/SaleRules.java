package tanksStore.serviceClasses;

import java.util.List;

public class SaleRules {
    List<Sale> sales;

    public SaleRules() {
    }

    public List<Sale> getSales() {
        return sales;
    }

    public void setSales(List<Sale> sales) {
        this.sales = sales;
    }


}
