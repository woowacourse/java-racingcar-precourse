package racingcar.controller;

import racingcar.Car;
import racingcar.domain.CarGenerator;
import racingcar.domain.ResultStringGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

public class RacingGameController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void run() {

        String carNames = inputView.readCarName();
        CarGenerator carGenerator = new CarGenerator(carNames);
        List<Car> cars = carGenerator.generateNamesToCars();

        int gameCount = inputView.readGameCount();
        outputView.printResultMessage();
        // 게임 횟수만큼 게임 실행
        playTheGame(cars, gameCount);
        // 우승 car 구하기
        String winner = getWinners(cars);
        // 우승자 출력
        outputView.printWinner(winner);
    }

    private String getWinners(List<Car> cars) {
        List<Car> winners = getWinnerCars(cars);
        return winners.stream().map(Car::getName).collect(Collectors.joining(", "));
    }

    private void playTheGame(List<Car> cars, int gameCount) {
        for (int i = 0; i < gameCount; i++) {
            //1. 일단 list돌면서 Car마다 playTheGame메서드 실행
            cars.forEach(Car::playGame);
            //2. list 돌면서 `car이름 : getPosition()\n` 마다 string으로 변환
            String executionResult = getExecutionResult(cars);
            outputView.printResult(executionResult);
        }
    }

    private String getExecutionResult(List<Car> cars) {
        return cars.stream()
                .map(ResultStringGenerator.generateExecutionResult())
                .collect(Collectors.joining());
    }

    private List<Car> getWinnerCars(List<Car> cars) {
        Integer maxPosition = getMaxPosition(cars);
        return calculateWinner(cars, maxPosition);
    }

    private Integer getMaxPosition(List<Car> cars) {
        return cars.stream()
                .map(Car::getPosition)
                .reduce(Integer::max)
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 최댓값을 구할 수 없습니다"));
    }

    private List<Car> calculateWinner(List<Car> cars, int maxPosition) {
        return cars.stream()
                .filter(i -> i.getPosition() == maxPosition)
                .collect(Collectors.toList());
    }
}
