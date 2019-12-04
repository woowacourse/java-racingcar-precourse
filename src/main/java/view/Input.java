package view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Input {
    private static final int MAX_NAME_LENGTH = 5;

    private Scanner scanner = new Scanner(System.in);

    public Input() {
    }

    public String input() {
        return scanner.nextLine();
    }

    public List<String> splitAsComma(String inputs) {
        return Arrays.asList(inputs.split(","));
    }

    public boolean isNameLengthUnderMax(String name) {
        return name.length() <= MAX_NAME_LENGTH;
    }

    public boolean isNamesLengthUnderMax(List<String> names) {
        return names.stream().allMatch(this::isNameLengthUnderMax);
    }

    public boolean isNoBlankNames(List<String> names) {
        return names.stream().allMatch(x -> !x.equals(" ") && x.length() != 0);
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
