package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class RacingSystem {
    private static final String INPUT_CAR_SENTENCE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_CNT_SENTENCE = "시도할 회수는 몇회인가요?";
    private static final String SEPARATOR = ",";
    private static final String NUMBER_REGAX = "^[0-9]*$";
    private static final int MAX_LENGTH = 5;
    private static final int NEGATIVE_NUMBER = -1;

    private List<Car> cars = new ArrayList<>();
    private Winners winners = new Winners();
    private int cnt = 0;

    public RacingSystem() {
    }

    public void inputCarName() {
        String input = write(INPUT_CAR_SENTENCE);
        try {
            checkValidName(input);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 올바른 자동차 이름을 입력하세요.");
            inputCarName();
        }
    }

    public void inputTryCnt() {
        String input = write(INPUT_CNT_SENTENCE);
        try {
            checkNumber(input);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 올바른 숫자를 입력하세요.");
            inputTryCnt();
        }
    }

    public void checkNumber(String input) throws IllegalArgumentException {
        if (!isNumber(input) || !isUnderMax(input)) {
            throw new IllegalArgumentException();
        }
        this.cnt = Integer.parseInt(input);
    }

    public void checkValidName(String input) {
        String[] nameArray = input.split(SEPARATOR, NEGATIVE_NUMBER);
        for (String name : nameArray) {
            if (isInvalidName(name)) {
                throw new IllegalArgumentException();
            }
            cars.add(new Car(name));
        }
    }

    private String write(String sentence) {
        System.out.println(sentence);
        return Console.readLine();
    }

    private boolean isNumber(String str) {
        return Pattern.matches(NUMBER_REGAX, str);
    }

    private boolean isUnderMax(String str) {
        return Long.parseLong(str) <= Integer.MAX_VALUE;
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
        return name.length() > MAX_LENGTH;
    }

    private boolean isEmptyString(String name) {
        return name == null || "".equals(name);
    }
}
