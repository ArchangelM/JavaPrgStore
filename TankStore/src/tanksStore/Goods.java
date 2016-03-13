package tanksStore;

/**
 * Created by Osipov on 07.03.2016.
 */
public class Goods {
    private Good[] goods;
    /*private Tank[] tanks;
    private Engine[] engines;
    private Ammo[] ammos;
    private Armor[] armors;
*/
    public Goods(Good[] goods) {
        this.goods = goods;
    }

    public Good[] getGoods() {
        return goods;
    }
}
