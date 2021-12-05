package racingcar.console;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import racingcar.Car;
import racingcar.CarInitializer;
import racingcar.CarRepository;
import racingcar.util.StringUtils;

public class ConsoleCarInitializer implements CarInitializer {
    private static final String GUIDE_INPUT_CAR_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String COMMA = ",";

    @Override
    public void registerCars() {
        while (true) {
            addCarByCarRepository();
            if (CarRepository.isReady()) {
                break;
            }
        }
    }

    private void addCarByCarRepository() {
        try {
            Arrays.stream(StringUtils.splitComma(inputCarNames(), COMMA))
                .forEach(name -> CarRepository.addCar(new Car(StringUtils.trim(name))));
        } catch (IllegalArgumentException exception) {
            CarRepository.clear();
            System.out.println(exception.getMessage());
        }
    }

    private String inputCarNames() {
        System.out.println(GUIDE_INPUT_CAR_NAME);
        return Console.readLine();
    }
}
