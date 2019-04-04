package domain;

import java.util.ArrayList;
import java.util.Scanner;

public class Player {
    private final String CAR_SELECTION_GUIDE = "경주할 자동차 이름을 입력하세요."
        + "(이름은 쉼표(,) 기준으로 구분)";
    private final String MOVE_COUNT_GUIDE = "시도할 회수는 몇회인가요?";

    public ArrayList<Car> selectCar() {
        String[] carNames = this.getCarNames();
        ArrayList<Car> cars = this.createCars(carNames);
        return cars;
    }

    private String[] getCarNames() {
        while (true) {
            System.out.println(CAR_SELECTION_GUIDE);
            Scanner prompt = new Scanner(System.in);
            String playerInput = prompt.nextLine();
            String[] carNames = playerInput.split(",");
            if (isValidCarName(carNames)) {
                return carNames;
            }
        }
    }

    public ArrayList<Car> createCars(String[] carNames) {
        ArrayList<Car> cars = new ArrayList<>();
        for (int i = 0; i < carNames.length; i++) {
            Car racingCar = new Car(carNames[i]);
            cars.add(racingCar);
        }
        return cars;
    }

    public boolean isValidCarName(String[] carNames) {
        for (int i = 0; i < carNames.length; i++) {
            if (carNames[i].length() > 5) {
                return false;
            }
        }
        return true;
    }

    public int setMoveCount() {
        while (true) {
            System.out.println(MOVE_COUNT_GUIDE);
            Scanner prompt = new Scanner(System.in);
            int moveCount = prompt.nextInt();
            if (isValidMoveCount(moveCount)) {
                return moveCount;
            }
        }
    }

    private boolean isValidMoveCount(int moveCount) {
        if (moveCount <= 0) {
            return false;
        }
        return true;
    }
}
