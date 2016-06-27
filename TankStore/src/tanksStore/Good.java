package tanksStore;

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

    @Override
    public String toString() {
        return articul + " " + name + " " + price + " " + quantity + " " + weight;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getIndex() {
        return index;

    }

    public GoodType getType() {
        return type;
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
