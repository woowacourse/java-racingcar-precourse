package ui;

import domain.Raceable;
import domain.RacingCar;
import domain.RacingGameConfig;
import domain.Validator;
import domain.errors.InvalidInputException;

import java.util.*;

public class Console implements UserInterface {

    private Scanner scanner;
    private Validator validator;

    public Console(Scanner scanner, Validator validator) {
        this.scanner = scanner;
        this.validator = validator;
    }

    @Override
    public String[] extractNames() {
        //todo: check dependency
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = scanner.nextLine();
        return parseNames(input);
    }

    private String[] parseNames(String input) {
        input = input.trim();
        if (input.startsWith(RacingGameConfig.STANDARD_TO_PARSE) || input.endsWith(RacingGameConfig.STANDARD_TO_PARSE)) {
            throw new InvalidInputException("입력값이 올바르지 않습니다. 구분자는 처음이나 마지막에 쓸 수 없습니다.");
        }

        String[] names = input.split(RacingGameConfig.STANDARD_TO_PARSE);
        if (!validator.validateNames(names)) {
            throw new InvalidInputException("입력값이 옳바르지 않습니다. 띄어쓰기 및 특수기호(!,@,#,$,%,^,&,*)는 이름으로 사용할 수 없습니다.");
        }

        return names;
    }
    private boolean isValidName(String name) {
        return Arrays.stream(RacingGameConfig.NOT_ALLOWED_IN_NAME).parallel().noneMatch(name::contains);
    }

    @Override
    public int getCycles() {
        System.out.println("시도할 회수는 몇회인가요?");
        int cycles = scanner.nextInt();
        //todo: 제대로 된 입력값을 받을 때까지 계속 물어보기.
        if (!validator.validateCycles(cycles)) {
            throw new InvalidInputException(String.format("입력값이 잘못됐습니다. %d 이상의 숫자를 입력해주세요.", RacingGameConfig.MIN_CYCLES));
        }
        return cycles;
    }
}
