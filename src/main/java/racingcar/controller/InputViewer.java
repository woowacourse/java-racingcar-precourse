package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class InputViewer {
    private static final String NAME_TOKEN_DELIM = ",";
    private final Scanner scanner;

    public InputViewer(final Scanner scanner) {
        this.scanner = scanner;
    }

    List<String> inputCarNameList() {
        String inputToken = this.scanner.next();
        List<String> carNameList = new ArrayList<>();
        StringTokenizer stringTokenizer = new StringTokenizer(inputToken, NAME_TOKEN_DELIM);

        while (stringTokenizer.hasMoreTokens()) {
            carNameList.add(stringTokenizer.nextToken());
        }

        return carNameList;
    }

    int inputTryNumber() {
        String token = this.scanner.next();
        return Integer.parseInt(token);
    }
}