package domain.handler;

import domain.validator.CarNameValidator;
import domain.validator.MoveNumValidator;
import domain.validator.Validator;

import java.util.Scanner;
import java.util.regex.Pattern;

public class InputHandler {

    private Validator validator;
    private final Scanner scanner;
    private final OutputHandler outputHandler;
    private final Pattern pattern;

    public InputHandler() {
        validator = null;
        scanner = new Scanner(System.in);
        outputHandler = new OutputHandler();
        pattern = Pattern.compile(",");
    }

    public int getNumOfMoves() {
        while (true) {
            System.out.println("시도할 횟수는 몇회인가요?");
            int moveNum = getInteger();
            validator = MoveNumValidator.createMoveNumValidatorWithMoveNum(moveNum);
            if (validator.doesValid()) {
                return moveNum;
            }
            outputHandler.printUnexpectedInput();
        }
    }

    public String[] getCarNames() {
        while (true) {
            System.out.println("경주할 자동차 이름(" + CarNameValidator.getCarNameLengthBound() + "글자 이내)을 입력하세요."
                    + " (이름은 쉼표(,) 기준으로 구분)");
            String[] carNames = splitByComma(scanner.nextLine());
            validator = CarNameValidator.createCarNameValidatorWithCarNames(carNames);
            if (validator.doesValid()) {
                return carNames;
            }
            outputHandler.printUnexpectedInput();
        }
    }

    private String[] splitByComma(String input) {
        return pattern.split(input);
    }

    private int getInteger() {
        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                break;
            }
            outputHandler.printUnexpectedInput();
            scanner.next();
        }
        return scanner.nextInt();
    }
}
