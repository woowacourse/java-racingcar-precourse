package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {

    private List<Car> carList;

    private final InputValidator inputValidator;

    private static final String INPUT_CAR_NAME_LIST_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_ATTEMPT_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String DELIMITER = ",";

    private static final String RESULT_MESSAGE = "\n실행 결과";

    public RacingGame(InputValidator inputValidator) {
        this.inputValidator = inputValidator;
        carList = new ArrayList<>();
    }

    public void play() {
        System.out.println(INPUT_CAR_NAME_LIST_MESSAGE);
        String[] carNameList = Console.readLine().split(DELIMITER);
        inputValidator.validateCarNameListInput(carNameList);

        System.out.println(INPUT_ATTEMPT_MESSAGE);
        String tryNumber = Console.readLine();
        inputValidator.validateTryNumber(tryNumber);

        for (String carName : carNameList) {
            carList.add(new Car(carName));
        }

        startRacing(Integer.parseInt(tryNumber));
    }

    public void startRacing(int tryNumber) {
        System.out.println(RESULT_MESSAGE);

        for (int i = 0; i < tryNumber; i++) {
            for (Car car: carList) {
                car.move();
                car.showPosition();
            }
            System.out.println();
        }
    }

    public List<String> findWinnerList() {
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
