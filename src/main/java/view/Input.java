package view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Input {
    private Scanner scanner = new Scanner(System.in);

    public Input() {
    }

    public String input() {
        return scanner.nextLine();
    }

    public List<String> splitAsComma(String inputs) {
        return Arrays.asList(inputs.split(","));
    }

    public boolean isPositiveInteger(String times) {
        try {
            return Integer.parseInt(times) > 0;
        } catch (NumberFormatException e) {
            //TODO Output error message
            return false;
        }
    }
}
