package view;

import camp.nextstep.edu.missionutils.Console;

import service.IntInputValidator;
import service.IntInputValidatorImpl;
import service.StringInputValidator;
import service.StringInputValidatorImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputView {
    private static final String messageForNames = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String messageForCount = "시도할 회수는 몇회인가요?";
    private static final StringInputValidator stringValidator = new StringInputValidatorImpl();
    private static final IntInputValidator intValidator = new IntInputValidatorImpl();

    List<String> getNames() {
        String inputString;
        List<String> names;

        do {
            System.out.println(messageForNames);
            inputString = Console.readLine();
            names = new ArrayList<>(Arrays.asList(parseString(inputString)));
        } while (!validateStringLength(names));

        return names;
    }

    int getCount() {
        String inputString;
        int parsedNumber;

        while (true) {
            System.out.println(messageForCount);
            inputString = Console.readLine();
            if (!checkParsable(inputString)) continue;

            parsedNumber = Integer.parseInt(inputString);
            if (validateNumberInRange(parsedNumber)) break;
        }

        return parsedNumber;
    }

    String[] parseString(String string) {
        return string.split(",");
    }

    boolean validateStringLength(List<String> names) {
        try {
            for (String name : names) {
                stringValidator.checkLength(name);
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    boolean validateNumberInRange(int number) {
        try {
            intValidator.isInRange(number);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    boolean checkParsable(String input) {
        try {
            intValidator.isNumber(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }


}
