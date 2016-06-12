package tanksStore;

import tanksStore.gui.StoreInterface;

import java.util.ArrayList;
import java.util.List;
import tanksStore.utils.Init;

import static tanksStore.utils.Init.goodsInit;

public class LauncherStore {

    public static void main(String[] args) throws Exception {
        TankStore tankStore = new TankStore();

        goodsInit(tankStore.getGoods());

        StoreInterface panelSI = new StoreInterface(tankStore);

        panelSI.createPanels(tankStore.getGoods());
        //panelSI.viewTable();
        //Thread.sleep(1000);
        //panelSI.viewSaleForm();


    }
}
