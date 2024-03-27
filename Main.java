import java.io.FileNotFoundException;
import java.util.List;

public class Main {
    static Basket basket;
    static final String FILENAME = "src/Input.txt";
    static List<String> fruits;

    public static void main(String[] args) throws FileNotFoundException {
        init();

        basket.fruitsCounter(FILENAME);
        fruits = basket.getFruits();

        basket.longestFruit(FILENAME);

        basket.fruitsTop(FILENAME);
    }

    private static void init() {
        basket = new Basket();
    }
}