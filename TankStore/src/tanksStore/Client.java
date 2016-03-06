package tanksStore;

/**
 * Created by Osipov on 07.03.2016.
 */
public class Client {
    protected int number;
    protected String name;

    public Client(int number, String name) {
        this.number = number;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    public void setName(String name) {
        this.name = name;
    }
}
