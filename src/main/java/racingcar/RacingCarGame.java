package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingCarGame {
    private UserInput userInput;
    private List<Car> cars;

    public RacingCarGame() {
        this.userInput = new UserInput();
    }

    public void play() {
        userInput.inputNames();
        this.cars = makeCarList(userInput.getNames());
    }

    public List<Car> makeCarList(List<String> names){
        List<Car> cars = new ArrayList<>();
        for(String name : names){
            cars.add(new Car(name));
        }
        return cars;
    }
}
