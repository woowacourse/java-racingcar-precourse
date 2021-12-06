package racingcar.io;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.garage.Garage;
import racingcar.validator.CarNamesValidator;
import racingcar.validator.RoundCountValidator;

import static racingcar.io.FixedString.*;

public class IOService {
    public static String readCarNames() {
        return CarNamesValidator.checkNamesAndReturn(Console.readLine());
    }

    public static int readRoundCount() {
        return RoundCountValidator.checkRoundCountAndReturn(Console.readLine());
    }

    public static void printEachRoundResult(Garage garage) {
        System.out.print(garage.whereAreCars());
    }

    public static void printRacingResult(String winners) {
        System.out.println(WINNER.getContent() + winners);
    }

    public static void print(FixedString fixedString) {
        System.out.println(fixedString.getContent());
    }

    public static void makeNewLine() {
        System.out.println();
    }

    public static void printErrorMessage(String message) {
        System.out.println(message);
    }

}
