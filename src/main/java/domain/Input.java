package domain;

import java.util.ArrayList;
import java.util.Scanner;

public class Input {
    private Scanner scanner;

    private Input() {
        scanner = new Scanner(System.in);
    }

    private static class InputHolder {
        public static final Input INSTANCE = new Input();
    }

    public static Input getInstance() {
        return InputHolder.INSTANCE;
    }

    public ArrayList<Car> enrollCarName() {
        ArrayList<Car> carList = new ArrayList<>();
        String[] inputCarName = scanner.nextLine().split(",");

        for (int i = 0; i < inputCarName.length; i++) {
            carList.add(new Car(inputCarName[i]));
        }

        return carList;
    }

    public int tryNumber(){
        int tryNumber = Integer.parseInt(scanner.nextLine());
        scanner.close();
        return tryNumber;
    }
}
