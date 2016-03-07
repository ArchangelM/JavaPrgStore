package tanksStore;

/**
 * Created by Osipov on 07.03.2016.
 */
public class Good {
    protected int index;
    protected GoodType type;
    private String name;
    private String articul;

    private double price;
    private int quantity;

    private double weight;


    public Good(String name, String articul, int index, double price, int quantity, double weight) {
        this.name = name;
        this.articul = articul;
        this.index = index;
        this.price = price;
        this.weight = weight;
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getIndex() {
        return index;

    }

    public String getArticul() {
        return articul;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public double getWeight() {
        return weight;
    }
}
