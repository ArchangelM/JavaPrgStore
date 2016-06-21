package tanksStore.utils;

import tanksStore.serviceClasses.Sale;

import java.util.List;

public class WorkWithSales {

    public static double getSaleQuantity(List<Sale> sales, double sum) {
        if(sales != null) {
            if(sales.size() != 0) {
                int  i = 0;
                while (i < sales.size() && sales.get(i).getSum() < sum) {
                    i++;
                }

                if(i == 0 && sales.get(0).getSum() > sum) {
                    return 0.0;
                } else if(i == 0 && sales.get(0).getSum() <= sum) {
                    return sum*sales.get(0).getPercent()/100d;
                } else if (i < sales.size() && sales.get(i).getSum() <= sum) {
                    return sum*sales.get(i).getPercent()/100d;
                } else if (i == sales.size() && sales.get(i-1).getSum() <= sum) {
                    return sum*sales.get(i-1).getPercent()/100d;
                }if (i < sales.size() && sales.get(i).getSum() > sum) {
                    return sum*sales.get(i-1).getPercent()/100d;
                }
            }

        }


        return 0.0;
    }

    public void addSale() {


    }

    public static void addSale(List<Sale> sales, Sale sale) {
        sales.add(sale);
    }

    public static void deleteSale(List<Sale> sales, int index) {

    }

    public static void getSale(List<Sale> sales, int index) {

    }


}
