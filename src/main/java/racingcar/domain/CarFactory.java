package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarFactory {

    public static final int MAX_CAR_NAME_LENGTH = 5;

    public static List<Car> manufactureByUserInput() {
        String[] carNames = getCarNamesFromUser();
        return Arrays.stream(carNames)
                .map(Car::new)
                .collect(Collectors.toList());
    }

    private static String[] getCarNamesFromUser() {
        String[] carNames;
        do {
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            String carNamesInput = Console.readLine();
            carNames = carNamesInput.split(",");
        } while (isIllegalName(carNames));
        return carNames;
    }

    private static boolean isIllegalName(String[] carNames) {
        for (String name : carNames) {
            try {
                assertName(name);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return true;
            }
        }
        return false;
    }

    private static void assertName(String name) {
        if (name.length() > MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름의 크기는 " + MAX_CAR_NAME_LENGTH + "를 초과할 수 없습니다. 현재 자동차 이름 = " + name);
        }
    }
}
