package tanksStore;

/**
 * Created by Osipov on 13.03.2016.
 */
public class Prices {

    public void printGoodsPrice(Good[] goods) {
        System.out.print("Prices for goods (");
        for (Good good:
                goods) {
            System.out.print(good.getName() + " - " + good.getPrice() + ", ");
        }
        System.out.println(")");
    }

    public void printGoodPrice(Good[] goods, String goodType) {
        GoodType type = GoodType.valueOf(goodType);

        int typeNum = type.ordinal();

        System.out.print("Prices for " + type + " goods (");
        for (Good good:
                goods) {
            if (good.getType() == type) {
                System.out.print(good.getName() + " - " + good.getPrice() + ", ");
            }
        }
        System.out.println(")");
    }

}
