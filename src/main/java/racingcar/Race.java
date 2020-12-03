package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static racingcar.MessageBox.ATTEMPT_NUMBER_ASK_MESSAGE;
import static racingcar.MessageBox.NAME_ASK_MESSAGE;

public class Race {
    private final Scanner sc;
    private int attemptNum;
    private List<Car> cars = new ArrayList<>();

    public Race(Scanner scanner) {
        sc = scanner;
    }

    public void start() {
        nameInput();
        attemptNumberInput();
        carsMoveProcess();
        printWinner();
    }

    private void nameInput() {
        System.out.println(NAME_ASK_MESSAGE);
        String[] carNames = sc.nextLine().split(",");
        carNameSetting(carNames);
    }

    private void attemptNumberInput() {
        System.out.println(ATTEMPT_NUMBER_ASK_MESSAGE);
        attemptNum = sc.nextInt();
    }

    private void carNameSetting(String[] carNames) {

        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
    }


}
