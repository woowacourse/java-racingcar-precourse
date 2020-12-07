package racingcar;

import View.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Racing {
    private static final String DELIMITER = ",";

    private List<Car> cars = new ArrayList<>();
    private int tryNumber;

    public void init(Scanner scanner) {
        saveCarName(scanner);
        saveTryNumber(scanner);
        raceStart();
    }

    private void raceStart() {
        for(int i = 0;i<tryNumber;i++){
            racing();
        }
    }



    private void saveTryNumber(Scanner scanner) {
        OutputView.writeTryNumber();
        Number number = new Number(scanner.next());
        tryNumber = number.getTryNumber();
    }

    public void saveCarName(Scanner scanner) {
        OutputView.writeCarName();
        String temp = scanner.next();
        String[] names = temp.split(DELIMITER);
        for (String name : names) {
            cars.add(new Car(name));
        }
    }

}
