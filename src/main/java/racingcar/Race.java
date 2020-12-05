package racingcar;

import java.util.List;

public class Race {
    private static final String RACE_RESULT = "실행 결과";
    private static final String CAR_INPUT_STATEMENT = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";

    private List<Car> cars;

    public Race(List<Car> cars) {
        this.cars = cars;
    }

    public static Race generateRace(InputManager inputManager) {
        System.out.println(CAR_INPUT_STATEMENT);
        while (true) {
            try {
                return new Race(inputManager.generateCars());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void startCarRace(int trialCount) {
        System.out.println(RACE_RESULT);
        for (int i=0; i<trialCount; i++) {
            for (Car car : cars) {
                car.moveCar();
                System.out.println(car.toString());
            }
            System.out.println();
        }
    }
}
