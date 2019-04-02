package domain;

import java.util.Scanner;

public class InputHandler {

    private Validator validator;
    private final Scanner scanner;
    private final OutputHandler outputHandler;

    public InputHandler() {
        validator = null;
        scanner = new Scanner(System.in);
        outputHandler = new OutputHandler();
    }

    public int getNumOfMoves() {
        while (true) {
            System.out.println("시도할 횟수는 몇회인가요?");
            String moveNum = scanner.nextLine();        // TODO moveNumString이 숫자를 표현하는 문자가 아닐 때의 예외 처리가 필요하다
            validator = new MoveNumValidator(moveNum);
            if (validator.doesValid()) {
                return Integer.parseInt(moveNum);
            }
            outputHandler.printUnexpectedInput();
        }
    }

    public String[] getCarNames() {
        while (true) {
            System.out.println("경주할 자동차 이름(5글자 이내)을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");
            String[] carNames = splitByComma(scanner.nextLine());
            validator = new CarNameValidator(carNames);
            if (validator.doesValid()) {
                return carNames;
            }
            outputHandler.printUnexpectedInput();
        }
    }

    // TODO 성능을 위해 Pattern을 미리 컴파일해놓고 matcher를 사용하는 방식으로 구현할 것
    private String[] splitByComma(String input) {
        return input.split(",");
    }
}
