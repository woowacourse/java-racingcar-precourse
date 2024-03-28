package racingcar;

import javax.naming.LimitExceededException;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) throws LimitExceededException {

        InputView inputView = new InputView();

        String CarNames = inputView.inputCarName();
        String[] carList = CarNames.split(",");

        List<Car> cars = new ArrayList<>();
        for (String name : carList) {
            cars.add(new Car(name));
        }

        int count = inputView.inputCount();

        for (int i = 0; i < count; i++) {
            for (Car car : cars) {
                car.move();
            }
            OutputView.outputCarStatus(carList);
        }

        OutputView.outputWinner(carList);
    }
}
