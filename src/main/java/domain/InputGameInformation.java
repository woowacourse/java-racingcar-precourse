package domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;


public class InputGameInformation {
    private Scanner sc;
    private ArrayList<Car> carName;
    private String cars[];
    private HashSet<String> carOverlapCheck;
    private int gameCount = 0;
    private final int limitedCarNameLength = 5;

    private void init() {
        sc = new Scanner(System.in);
        carName = new ArrayList<>();
        carOverlapCheck = new HashSet<>();
        gameCount = 0;
    }

    public void inputCar() {
        init();
        inputCarName();
        inputGameCount();
    }

    private void inputCarName() {
        System.out.println(Message.gameInputMessage.get("INPUT_CARNAME"));
        cars = sc.next().split(",");
        int carslength = cars.length;
        for (int i = 0; i < carslength; i++) {
            if (checkCar(cars[i])) {
                carName.add(new Car(cars[i]));
            }
        }
    }

    private void inputGameCount() {
        do {
            System.out.println(Message.gameInputMessage.get("INPUT_GAMECOUNT"));
            gameCount = sc.nextInt();
        } while (checkGameCount(gameCount));
    }

    private boolean checkGameCount(int number) {
        if (number <= 0) {
            System.out.println(Message.errorMessage.get("ERROR_GAMECOUNTLIMIT"));
            return true;
        }
        return false;
    }

    private boolean checkCar(String name) {
        boolean CheckOverlap = checkOverlap(name);
        boolean CheckLength = checkLimitLength(name);
        if (CheckOverlap && CheckLength) {
            return true;
        }
        return false;
    }

    private boolean checkOverlap(String name) {
        if (!carOverlapCheck.contains(name)) {
            carOverlapCheck.add(name);
            return true;
        }
        return false;
    }

    private boolean checkLimitLength(String name) {
        if (name.length() <= limitedCarNameLength) {
            return true;
        }
        return false;
    }

}
