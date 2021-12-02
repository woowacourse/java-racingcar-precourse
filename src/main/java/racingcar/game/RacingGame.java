package racingcar.game;

import racingcar.domain.Car;
import racingcar.util.UserInputUtil;

import java.util.ArrayList;
import java.util.List;

import static racingcar.util.UserInputUtil.*;

public class RacingGame {

    public void startGame() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        List<Car> carList = getCarList();

        System.out.println("시도할 회수는 몇회인가요?");
        int count = getIntNum();

        System.out.println("실행 결과");

        for (int i = 0; i < count; i++) {
            progressGame(carList);
        }
    }

    private void progressGame(List<Car> carList) {
        for (Car car : carList) {
            car.progress();
            car.printProgress();
        }

        System.out.println();
    }

    private List<Car> getCarList() {
        String[] carNames = getCarNames();

        List<Car> cars = new ArrayList<>();

        for (String carName : carNames) {
            cars.add(new Car(carName));
        }

        return cars;
    }
}
