package domain;

import java.util.ArrayList;
import java.util.List;

public class RacingCarGame {
    public static void main(String[] args) {
        System.out.println("asd".toUpperCase().equals("ASD"));
        startRacingCarGame();
    }

    private static void startRacingCarGame() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        getRacingCarName();
    }

    private static void getRacingCarName() {
        Validator carValidator = new Validator();
        List<String> racingCarNames = carValidator.getRacingCarNames();
        List<Car> racingCars = new ArrayList<>();
        for(String racingCar : racingCarNames) {
            racingCars.add(new Car(racingCar));
        }
        for(Car c : racingCars) {
            System.out.println(c.getCarName());
        }
    }


}
