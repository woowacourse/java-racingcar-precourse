package ui;

import domain.RacingGameConfig;
import domain.Validator;
import domain.errors.InvalidInputException;

import util.RacingPrinter;

import java.util.*;

public class Console implements UserInterface {

    private Scanner scanner;
    private Validator validator;
    private RacingPrinter racingPrinter;

    public Console(Scanner scanner, Validator validator, RacingPrinter racingPrinter) {
        this.scanner = scanner;
        this.validator = validator;
        this.racingPrinter = racingPrinter;
    }

    @Override
    public String[] extractNames() {
        racingPrinter.printRequestForNames();
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

    @Override
    public int getCycles() {
        racingPrinter.printRequestForCycles();
        int cycles = scanner.nextInt();
        //todo: 제대로 된 입력값을 받을 때까지 계속 물어보기.
        if (!validator.validateCycles(cycles)) {
            throw new InvalidInputException(String.format("입력값이 잘못됐습니다. %d 이상의 숫자를 입력해주세요.", RacingGameConfig.MIN_CYCLES));
        }
        return cycles;
    }
}
