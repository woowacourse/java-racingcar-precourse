package racingcar;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    // 추가 기능 구현
    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void moveOrStop() {
        int dice = Randoms.pickNumberInRange(Const.MIN_RANDOM_VALUE, Const.MAX_RANDOM_VALUE);
        if(dice >= Const.FORWARD_STANDARD)
            this.position++;
    }

    public void printPosition() {
        StringBuilder outputText = new StringBuilder(name + Const.CAR_PRINT_SEPARATOR);
        for (int i = 0; i < position; i++) {
            outputText.append(Const.CAR_POSITION_MARKER);
        }
        System.out.println(outputText);
    }

    public static List<Car> generateCars(List<String> names) {
        List<Car> result = new ArrayList<>();

        for (String name : names) {
            result.add(new Car(Validator.validateName(name)));
        }

        return result;
    }
}
