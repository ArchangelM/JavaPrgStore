package tanksStore.serviceClasses;

import tanksStore.Good;
import tanksStore.GoodType;

/**
 * Created by Osipov on 13.03.2016.
 */
public class Quantity {

    public void printGoodsQuantity(Good[] goods) {
        long quantity = 0;
        System.out.print("Quantity for goods (");
        for (Good good:
                goods) {
            System.out.print(good.getQuantity() + " " + good.getName() + ", ");
            quantity += good.getQuantity();
        }
        System.out.println("All quantity is " + quantity + ")");
    }

    public void printGoodQuantity(Good[] goods, String goodType) {
        long quantity = 0;
        GoodType type = GoodType.valueOf(goodType);

        System.out.print("Quantity for " + type + " goods (");
        for (Good good:
                goods) {
            if (good.getType() == type) {
                System.out.print(good.getQuantity() + " " + good.getName() + ", ");
                quantity += good.getQuantity();
            }
        }
        System.out.println("All quantity is " + quantity + ")");
    }
}
