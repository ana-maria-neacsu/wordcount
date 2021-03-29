package wordcounter;

import java.util.Scanner;

public class InputProvider {

    public String getInput() {
        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }
}
