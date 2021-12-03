package racingcar.Model;

import java.util.ArrayList;
import java.util.List;

public class RacingCarGame {
    private Input input;
    private List<Car> cars = new ArrayList<>();

    public void setInput(Input input) {
        this.input = input;
    }

    public void setCars(Input input) {
        for (String name : input.getNames()) {
            this.cars.add(new Car(name));
        }
    }

    public Input getInput() {
        return this.input;
    }

    public List<Car> getCars() {
        return this.cars;
    }

}
