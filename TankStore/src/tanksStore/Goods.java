package tanksStore;

public class Goods {
    private Good[][] goods;
    /*private Tank[] tanks;
    private Engine[] engines;
    private Ammo[] ammos;
    private Armor[] armors;
*/

    public Goods() {
        goods = new Good[GoodType.NUM][];
    }

    public void printGoods() {
        System.out.println(" #  Articul   Name      Price  Quantity Wheiht");
        GoodType type = GoodType.TANK;
        System.out.println("Type " + type);
        int j = type.ordinal();
        for(int i = 0; i < goods[j].length;i++) {
            System.out.println(goods[j][i].toString());
        }
        type = GoodType.ENGINE;
        System.out.println("Type " + type);
        j = type.ordinal();
        for(int i = 0; i < goods[j].length;i++) {
            System.out.println(goods[j][i].toString());
        }
        type = GoodType.ARMOR;
        System.out.println("Type " + type);
        j = type.ordinal();
        for(int i = 0; i < goods[j].length;i++) {
            System.out.println(goods[j][i].toString());
        }
        type = GoodType.AMMO;
        System.out.println("Type " + type);
        j = type.ordinal();
        for(int i = 0; i < goods[j].length;i++) {
            System.out.println(goods[j][i].toString());
        }
    }

    public Goods(Good[][] goods) {
        this.goods = goods;
    }

    public Good[][] getGoods() {
        return goods;
    }
}
