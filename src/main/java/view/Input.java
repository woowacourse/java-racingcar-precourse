package view;

import java.util.*;

public class Input {
    private static final int MAX_NAME_LENGTH = 5;

    private Scanner scanner = new Scanner(System.in);
    private String input;

    public Input() {

    }

    public void setInput() {
        input = scanner.nextLine();
    }

    public List<String> asCarNames() {
        Output.showNamesInputForm();
        setInput();
        List<String> nameList = splitAsComma(input);
        if (isNamesLengthUnderMax(nameList) && isNoBlankNames(nameList)) {
            return nameList;
        }
        return new Input().asCarNames();
    }

    public int asRounds() {
        Output.showRoundsInputForm();
        setInput();
        if (isPositiveInteger(input)) {
            return Integer.parseInt(input);
        }
        return new Input().asRounds();
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
        return names.stream().allMatch(x -> !x.equals(" ") && x.length() != 0)
                && names.size() != 0;
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
