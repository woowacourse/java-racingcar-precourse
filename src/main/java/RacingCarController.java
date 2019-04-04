import domain.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RacingCarController {
    public static void main(String[] args) {
        RacingCarInputView racingCarInputView = new RacingCarInputView();
        List<Car> cars = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        racingCarInputView.inputRacingCarName();
        String[] inputCarNames = scanner.next().split(",");
        for(String carName : inputCarNames) {
            cars.add(new Car(carName));
        }

        racingCarInputView.inputTryCount();
        int tryCount = scanner.nextInt();
    }
} 
