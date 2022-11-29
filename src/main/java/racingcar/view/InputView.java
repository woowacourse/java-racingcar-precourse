package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static racingcar.ErrorCode.NOT_TRY_COUNT;
import static racingcar.ErrorCode.NOT_VALID_TRY_COUNT;

public class InputView {
    private static final String MESSAGE_INPUT_CARS = "경주할 자동차 이름을 입력하세요.";
    private static final String MESSAGE_INPUT_COUNT = "시도할 회수는 몇회인가요?";
//    (이름은 쉼표(,) 기준으로 구분)

    public List<String> inputCars() {
        System.out.println(MESSAGE_INPUT_CARS);

        String input = Console.readLine();
        //빈값 혹은 null인지 유효성 체크
        return createCarLists(input);
    }

    public List<String> createCarLists(String input) {
        return Arrays.stream(input.split(","))
                .collect(Collectors.toList());
    }

    public int inputMovingCount() {
        System.out.println(MESSAGE_INPUT_COUNT);

        String input = Console.readLine();
        validateMovingCount(input);
        return Integer.parseInt(input);
    }

    public void validateMovingCount(String input) {
        isNumber(input);
        int movingCount = Integer.parseInt(input);
        if(movingCount < 1) {
            NOT_VALID_TRY_COUNT.throwError();
        }
    }

    public void isNumber(String input) {
        try{
            Integer.parseInt(input);
        }catch (NumberFormatException e) {
            NOT_TRY_COUNT.throwError();
        }
    }
}
