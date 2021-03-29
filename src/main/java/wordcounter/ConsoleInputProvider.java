package wordcounter;

import java.util.Scanner;

public class ConsoleInputProvider implements InputProvider {

    @Override
    public String getInput() {
        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }
}
