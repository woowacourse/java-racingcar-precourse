package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {

    private final List<Car> carList;

    private final InputValidator inputValidator;

    public RacingGame(InputValidator inputValidator) {
        this.inputValidator = inputValidator;
        carList = new ArrayList<>();
    }

    public void play() {
        System.out.println(RacingCarConstant.INPUT_CAR_NAME_LIST_MESSAGE);
        for (String carName : getCarList()) {
            carList.add(new Car(carName));
        }
        System.out.println(RacingCarConstant.INPUT_ATTEMPT_MESSAGE);
        int tryNumber = getTryNumber();
        startRacing(tryNumber);

        List<String> winnerList = findWinnerList();
        showWinnerList(winnerList);
    }

    private void startRacing(int tryNumber) {
        System.out.println(RacingCarConstant.RESULT_MESSAGE);

        for (int i = 0; i < tryNumber; i++) {
            for (Car car : carList) {
                car.move();
                car.showPosition();
            }
            System.out.println();
        }
    }

    private String[] getCarList() {
        while (true) {
            String[] carNameList = Console.readLine().split(RacingCarConstant.DELIMITER);
            try {
                inputValidator.validateCarNameListInput(carNameList);
                return carNameList;
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    private int getTryNumber() {
        while (true) {
            String tryNumber = Console.readLine();
            try {
                inputValidator.validateTryNumber(tryNumber);
                return Integer.parseInt(tryNumber);
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    private void showWinnerList(List<String> winnerList) {
        System.out.print("최종 우승자 : ");
        System.out.print(String.join(RacingCarConstant.DELIMITER + " ", winnerList));
    }

    private List<String> findWinnerList() {
        int maxPosition = carList.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);

        return carList.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}
