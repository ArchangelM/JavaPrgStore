package tanksStore;

import tanksStore.gui.StoreInterface;

public class LauncherStore {
    public static void main(String[] args) {
        TankStore tankStore = new TankStore();

        StoreInterface panel = new StoreInterface(tankStore);

    }
}
