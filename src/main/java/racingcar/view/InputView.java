package racingcar.view;

import static racingcar.utils.Constant.*;

import racingcar.utils.Validator;

import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static List<String> requestCarInput() {
        List<String> result;
        String input;
        System.out.println(REQUEST_CAR_NAMES);
        input = Console.readLine();
        while ((result = Validator.isValidNameList(input)).isEmpty()){
            input = Console.readLine();
        }

        return result;
    }

    public static int requestTryCount() {
        String input;
        System.out.println(REQUEST_TRY_COUNT);
        input = Console.readLine();
        while (!Validator.isValidCount(input)) {
            input = Console.readLine();
        }
        return Integer.parseInt(input);
    }
}