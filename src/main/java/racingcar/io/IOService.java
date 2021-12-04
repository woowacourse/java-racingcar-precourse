package racingcar.io;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.garage.Garage;
import racingcar.validation.Validation;

import static racingcar.io.FixedString.*;

public class IOService {
    public static String readCarNames() {
        return Validation.inputCarNames(Console.readLine());
    }

    public static int readRoundCount() {
        return Validation.inputRoundCount(Console.readLine());
    }

    public static void printEachRoundResult(Garage garage) {
        System.out.print(garage.whereAreCars());
    }

    public static void printRacingResult(Garage garage) {
        System.out.println(WINNER.getContent() + garage.whichWin());
    }

    public static void ask(FixedString fixedString) {
        System.out.println(fixedString.getContent());
    }

    public static void makeNewLine() {
        System.out.println();
    }

    public static void printErrorMessage(String message) {
        System.out.println(message);
    }

}
