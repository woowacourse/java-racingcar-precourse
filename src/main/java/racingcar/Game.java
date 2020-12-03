package racingcar;

import java.util.stream.Collectors;
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
        if (carNames.length == 0) {
            throw new IllegalArgumentException("[Error] 이름이 공백이거나 콤마(,)이면 안 됩니다.");
        }

        // 시도할 횟수 입력 받기
        String attemptsCountInput = Input.receiveAttemptsCount(scanner);
        int attemptsCount = Integer.parseInt(attemptsCountInput);

        // 자동차 생성
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < carNames.length; i++) {
            cars.add(new Car(carNames[i]));
        }

        // 시행 결과 출력
        Output.willPrintResult();
        for (int i = 0; i < attemptsCount; i++) {
            for (int j = 0; j < cars.size(); j++) {
                cars.get(j).move();
            }
            Output.printEmptyLine();
        }

        // 최종 우승자 출력
        int maxPosition = cars.stream()
            .map(car -> car.getPosition())
            .mapToInt(x -> x)
            .max()
            .getAsInt();

        List<String> winners = cars.stream()
            .filter(car -> car.getPosition() == maxPosition)
            .map(car -> car.getName())
            .collect(Collectors.toList());

        Output.printWinners(winners);
    }
}
