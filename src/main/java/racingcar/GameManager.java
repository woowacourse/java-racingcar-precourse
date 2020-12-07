package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameManager {
    public void activate(Scanner scanner) {
        String[] cars = inputCars(scanner);
        List<Car> carList = createCars(cars);
        String cntInput = inputGameCnt(scanner);

        Game game = new Game(Integer.parseInt(cntInput), carList);
        game.start();
    }

    private String[] inputCars(Scanner scanner) {
        String[] cars;
        InputValidator inputValidator = new InputValidator();
        do {
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            String carsInput = scanner.next();
            cars = carsInput.split(",");
        } while (!inputValidator.validateCarName(cars));
        return cars;
    }

    private static List<Car> createCars(String[] cars) {
        List<Car> carList = new ArrayList<>();
        for (String car : cars) {
            carList.add(new Car(car));
        }
        return carList;
    }

    private String inputGameCnt(Scanner scanner) {
        String cntInput;
        InputValidator inputValidator = new InputValidator();
        do {
            System.out.println("시도할 회수는 몇회인가요?");
            cntInput = scanner.next();
        } while (!inputValidator.validGameCntInput(cntInput));
        return cntInput;
    }
}
