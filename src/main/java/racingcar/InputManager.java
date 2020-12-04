package racingcar;

import java.util.*;

public class InputManager {

    private Scanner scanner;

    public InputManager(Scanner scanner) {
        this.scanner = scanner;
    }

    public List<Car> generateCars() {
        String carList = scanner.next();
        Set<Car> filteredCars = new LinkedHashSet<>();
        String[] preFilteredCars = carList.split(",");
        for (String preFilteredCar : preFilteredCars) {
            filteredCars.add(new Car(preFilteredCar));
        }
        return new ArrayList<>(filteredCars);
    }
}
