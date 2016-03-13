package tanksStore;


import tanksStore.Good;

/**
 * Created by Osipov on 07.03.2016.
 */
public class Purchase {
    private Good good;
    private int quantity;
    private double sum;

   public Purchase(Good good, int quantity) {
       this.good = good;
       this.quantity = quantity;
       sum = quantity * good.getPrice();
   }

    public String getName() {
        return good.getName();
    }

    public Good getGood() {
        return good;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getSum() {
        return sum;
    }
}
