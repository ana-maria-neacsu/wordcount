import java.util.Scanner;

public class Foo {

    public static void main(final String[] args) {
        System.out.print("Enter text: ");
        final Scanner scanner = new Scanner(System.in);
        final String input = scanner.nextLine();
        System.out.println("Number of words: " + wordCount(input));
    }

    static int wordCount(final String line) {
        final String[] possibleWords = line.split(",|\\.|\\s+");

        int count = 0;
        for (final String possibleWord: possibleWords) {
            if (possibleWord.matches("[a-z]+|[A-Z]+")) {
                count++;
            }
        }

        return count;
    }
}
