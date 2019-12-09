/*
 * @(#)Console.java 2019/12/10
 *
 * Copyright (c) 2019 Geunwon Lim
 * All rights reserved.
 */

package ui;

import domain.RacingGameConfig;
import domain.Validator;
import domain.errors.InvalidInputException;
import util.RacingPrinter;

public class Console implements UserInterface {

    private InputController inputController;
    private Validator validator;
    private RacingPrinter racingPrinter;

    public Console(InputController inputController, Validator validator, RacingPrinter racingPrinter) {
        this.inputController = inputController;
        this.validator = validator;
        this.racingPrinter = racingPrinter;
    }

    /** 성공적으로 이름들을 추출할 때까지 반복합니다. */
    @Override
    public String[] extractNames() {
        racingPrinter.printRequestForNames();
        String input = inputController.nextLine();

        try {
            return parseNames(input);
        } catch (InvalidInputException e) {
            racingPrinter.printErrorWhenExtractingNames(e);
            return extractNames();
        }
    }

    private String[] parseNames(String input) {
        input = input.trim();
        if (input.startsWith(RacingGameConfig.STANDARD_TO_PARSE) || input.endsWith(RacingGameConfig.STANDARD_TO_PARSE)) {
            throw new InvalidInputException("구분자는 처음이나 마지막에 쓸 수 없습니다.");
        }

        String[] names = input.split(RacingGameConfig.STANDARD_TO_PARSE);
        if (!validator.validateNames(names)) {
            throw new InvalidInputException("이름은 2개 이상이어야 하고, 5글자를 넘을 수 없습니다. 또한, 띄어쓰기 및 특수기호(!,@,#,$,%,^,&,*)를 이름으로 사용할 수 없습니다.");
        }

        return names;
    }

    /** 성공적으로 기간(주기)을 받을 때까지 반복합니다. */
    @Override
    public int getCycles() {
        racingPrinter.printRequestForCycles();

        try {
            int cycles = Integer.parseInt(inputController.nextLine());
            if (!validator.validateCycles(cycles)) {
                racingPrinter.printErrorWithTooSmallCycle(RacingGameConfig.MIN_CYCLES);
                return getCycles();
            }

            return cycles;
        } catch (NumberFormatException e) {
            racingPrinter.printErrorWithNotNaturalNumber();
            return getCycles();
        }
    }
}
