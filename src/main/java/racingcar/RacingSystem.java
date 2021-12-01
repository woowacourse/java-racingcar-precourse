package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class RacingSystem {
    private static final String INPUT_CAR_SENTENCE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_CNT_SENTENCE = "시도할 회수는 몇회인가요?";
    private static final String SEPARATOR = ",";
    private static final int MAX_CNT = 5;

    private List<Car> cars = new ArrayList<>();
    private Winners winners = new Winners();

    public RacingSystem() {
    }

    public void inputCarName() {
        String input = write(INPUT_CAR_SENTENCE);
        checkValid(input);
        // TODO exception 발생 시 다시 입력 받기
    }

    private String write(String sentence) {
        System.out.println(sentence);
        return Console.readLine();
    }

    public void checkValid(String input) {
        String[] nameArray = input.split(SEPARATOR, -1);
        for (String name : nameArray) {
            if (isInvalidName(name)) {
                throw new IllegalArgumentException();
            }
            cars.add(new Car(name));
        }
    }

    private boolean isInvalidName(String name) {
        return isDuplicated(name)
                || isOverMaxCnt(name)
                || isEmptyString(name);
    }

    private boolean isDuplicated(String name) {
        for (Car car : cars) {
            if (name.equals(car.getName())) {
                return true;
            }
        }
        return false;
    }

    private boolean isOverMaxCnt(String name) {
        return name.length() > MAX_CNT;
    }

    private boolean isEmptyString(String name) {
        return name == null || "".equals(name);
    }
}
