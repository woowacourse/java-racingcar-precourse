package racingcar;

import ui.Input;
import ui.Output;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    public void start(Scanner scanner) {
        //  경주할 자동차들 이름 입력 받기
        String carNamesInput = Input.receiveRacingCarNames(scanner);
        String[] carNames = carNamesInput.split(",");

        // 시도할 횟수 입력 받기
        String attemptsCountInput = Input.receiveAttemptsCount(scanner);
        int attemptsCount = Integer.parseInt(attemptsCountInput);

        // 자동차 생성
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < carNames.length; i++) {
            cars.add(new Car(carNames[i]));
        }

        Output.willPrintResult();
        for (int i = 0; i < attemptsCount; i++) {
            for (int j = 0; j < cars.size(); j++) {
                cars.get(j).move();
            }
            Output.printEmptyLine();
        }
    }
}
