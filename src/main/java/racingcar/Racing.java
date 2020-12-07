package racingcar;

import View.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Racing {
    private static final String DELIMITER = ",";

    private List<Car> cars = new ArrayList<>();
    private Number number;

    public void init(Scanner scanner){
        saveCarName(scanner);
        saveTryNumber(scanner);
    }

    private void saveTryNumber(Scanner scanner) {
        OutputView.writeTryNumber();
        number = new Number(scanner.next());
    }

    public void saveCarName(Scanner scanner){
        OutputView.writeCarName();
        String temp = scanner.next();
        String[] names = temp.split(DELIMITER);
        for(String name : names){
            cars.add(new Car(name));
        }
    }

}
