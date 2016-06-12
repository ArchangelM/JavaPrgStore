package tanksStore;

import tanksStore.data.SalesInvoice;
import tanksStore.utils.Init;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Osipov on 13.03.2016.
 */
public class TankStore {
    private Goods sklad;
    private List<Good> goods;
    private List<SalesInvoice> salesInvoices;
    private List<Client> clients;
    //private HashMap<String, SalesInvoice> salesInvoices;
    public final int PRIMARY_QUANTITY = 5;

    public TankStore() {
        salesInvoices = new ArrayList<>(PRIMARY_QUANTITY);
        //salesInvoices = new HashMap<String, SalesInvoice>;
        Init.transactionGenerator(salesInvoices);
        goods = new ArrayList<>();
        clients = new ArrayList<>();

    }

    public void addSaleInvoice(SalesInvoice salesInvoice) {
        salesInvoices.add(salesInvoice);
    }

    public Client addClient(int num, String Name) {
        Client client = new Client(num, Name);
        clients.add(client);
        return client;
    }

    public List<SalesInvoice> getSalesInvoices() {
        return salesInvoices;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public Goods getSklad() {
        return sklad;
    }

    public void setSklad(Goods sklad) {
        this.sklad = sklad;
    }

    public void setSalesInvoices(List<SalesInvoice> salesInvoices) {
        this.salesInvoices = salesInvoices;
    }

    public List<Good> getGoods() {
        return goods;
    }

    public void setGoods(List<Good> goods) {
        this.goods = goods;
    }
}
