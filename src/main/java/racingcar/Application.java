package racingcar;

import java.util.ArrayList;
import java.util.List;

import racingcar.domain.CarList;
import racingcar.domain.Car;

public class Application {

    private static List<Car> cars = new ArrayList<Car>();

    public static void main(String[] args) {
        // TODO 구현 진행

        getCarNameInput();

    }

    private static void getCarNameInput() {

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        cars = CarList.input();
    }
}
