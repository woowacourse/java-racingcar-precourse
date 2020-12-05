package racingcar;

import exception.EmptyCarNameException;
import exception.InvalidCarNameLengthException;
import exception.InvalidInputException;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class NameParser {

    private static final String DELIMITER = ",";
    private static final int MAX_NAME_LENGTH = 5;

    private String line;
    private List<String> names = new ArrayList<>();

    public NameParser(String line) {
        this.line = line;
    }


    public String[] parseCarNames() throws InvalidInputException {
        getNamesFromLine();
        validateNames();
        return names.toArray(new String[0]);
    }

    private void getNamesFromLine() {
        StringTokenizer tk = new StringTokenizer(line, DELIMITER);
        while (tk.hasMoreTokens())
            names.add(tk.nextToken());
    }

    private void validateNames() throws InvalidInputException {
        validateNamesExists();
        for (String name : names)
            validateNameLength(name);
    }

    private void validateNamesExists() throws InvalidInputException {
        if (names.isEmpty())
            throw new EmptyCarNameException();
    }

    private void validateNameLength(String name) throws InvalidInputException {
        if (name.length() > MAX_NAME_LENGTH)
            throw new InvalidCarNameLengthException();
    }
}
