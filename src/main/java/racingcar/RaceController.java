package racingcar;

import racingcar.View.Input;
import racingcar.View.Relay;

import java.util.List;

import static racingcar.Message.Message.RESULT;

public class RaceController {

    private final int tryCount;
    private List<Car> cars;
    private Input input = new Input();
    private Relay relay = new Relay();

    RaceController() {
        this.cars = input.getCars();
        tryCount = input.getTryCount();
    }

    public void racing() {
        System.out.println(RESULT);

        for (int i = 0; i < tryCount; i++) {
            for (Car car : cars) car.accelerate();

            String lapse = relay.showLapse(cars);
            System.out.println(lapse);
        }

    }

    public void awarding() {
        System.out.println(relay.winners(this.cars));
    }
}
