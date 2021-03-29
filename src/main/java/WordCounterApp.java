import java.util.Scanner;
import wordcounter.WordCounter;

public class WordCounterApp {

    public static void main(String[] args) {
        // 1. ask user for input
        System.out.print("Enter text: ");
        Scanner in = new Scanner(System.in);
        String text = in.nextLine();

        // 2. process the input
        WordCounter wordCounter = new WordCounter();
        int count = wordCounter.count(text);

        // 3. print out the result
        System.out.println("Number of words: " + count);
    }
}
