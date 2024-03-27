import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Basket {
    private int fruitsCount = 0;
    private List<String> fruits;
    private Scanner scanner;
    private File file;

    public void fruitsCounter(String filename) throws FileNotFoundException {
        initData(filename);

        while (scanner.hasNextLine()) {
            fruits = List.of(scanner.nextLine().toLowerCase().split(" "));
            fruitsCount = fruitsCount + fruits.size();
        }

        System.out.println("Всего слов - " + fruitsCount);
        scanner.close();
    }

    public List<String> getFruits() {
        if (!fruits.isEmpty()) {
            return fruits;
        } else {
            return null;
        }
    }

    public void longestFruit(String filename) throws FileNotFoundException {
        initData(filename);
        int lettersInLongestWord = Integer.MIN_VALUE;
        String longest = null;

        for (String fruit : fruits) {
            int countLetter = 0;
            for (int i = 0; i < fruit.length(); i++) {
                countLetter++;
            }
            if (countLetter > lettersInLongestWord) {
                lettersInLongestWord = countLetter;
                longest = fruit;
            }
        }

        System.out.println("Самое длинное слово - " + longest);
        scanner.close();
    }

    public void fruitsTop(String filename) throws FileNotFoundException {
        initData(filename);
        List<String> allFruits = new ArrayList<>();

        while (scanner.hasNextLine()) {
            allFruits.add(scanner.next().toLowerCase());
        }

        Map<String, Long> result = allFruits.stream().collect(Collectors.groupingBy(n -> n, Collectors.counting()));

        System.out.println("Количество каждого слова - " + result);
        scanner.close();
    }

    private void initData(String filename) throws FileNotFoundException {
        file = new File(filename);
        scanner = new Scanner(file);
    }
}