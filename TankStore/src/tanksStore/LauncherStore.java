package tanksStore;

import tanksStore.gui.StoreInterface;

import java.util.ArrayList;
import java.util.List;
import tanksStore.utils.Init;

import static tanksStore.utils.Init.goodsInit;

public class LauncherStore {
    public static void main(String[] args) {
        TankStore tankStore = new TankStore();
        List<Good> goods = new ArrayList<>();

        goodsInit(goods);

        StoreInterface panel = new StoreInterface(tankStore);
        panel.viewTable();


    }
}
