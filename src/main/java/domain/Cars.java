package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Cars {
    public static final String SEPARATOR_NAME = "쉼표";
    public static final String SEPARATOR = ",";
    private static final int CARS_MIN_AMOUNT = 2;
    private ArrayList<Car> cars = new ArrayList<>();

    public Cars(String input) throws IllegalArgumentException {
        if (doesNotContainSeparator(input)) {
            String separator = SEPARATOR_NAME + "(" + SEPARATOR + ")";
            throw new IllegalArgumentException(String.format("※경주이므로 최소 %d대 이상의 자동차 이름을 입력해 주세요.(이름은 %s 기준으로 구분)", CARS_MIN_AMOUNT, separator));
        }
        ArrayList<String> carNamesList = getCarNamesList(input);
        for (String carName : carNamesList) {
            try {
                cars.add(new Car(carName));
            } catch (IllegalArgumentException e) {
                throw e;
            }
        }
        if (haveDuplicatedNames(cars)) {
            throw new IllegalArgumentException("※중복되는 자동차 이름은 사용할 수 없습니다.");
        }
    }

    private static boolean doesNotContainSeparator(String input) {
        return !(input.contains(SEPARATOR));
    }

    private static ArrayList<String> getCarNamesList(String input) {
        ArrayList<String> carNamesList = new ArrayList<>();
        String[] carNames = input.split(SEPARATOR);
        for (String carName : carNames) {
            carNamesList.add(carName);
        }
        return carNamesList;
    }

    private static boolean haveDuplicatedNames(ArrayList<Car> cars) {
        HashSet<Car> carsSet = new HashSet<Car>(cars);
        return carsSet.size() != cars.size();
    }

    public void showMoves(MoveCount moveCount) {
        int moveCountValue = moveCount.get();
        while (0 < moveCountValue) {
            for (Car car : cars) {
                car.move();
                System.out.println();
            }
            System.out.println();
            moveCountValue--;
        }
    }

    public ArrayList<String> findWinnerName() {
        ArrayList<String> winnerList = new ArrayList<>();
        int maxCarPositionValue = getMaxCarPositionValue();
        for (Car car : cars) {
            if (car.isEqualPosition(maxCarPositionValue)) {
                winnerList.add(car.getName());
            }
        }
        return winnerList;
    }

    private int getMaxCarPositionValue() {
        ArrayList<Integer> carPositionValues = new ArrayList<>();
        for (Car car : cars) {
            carPositionValues.add(car.getPosition());
        }
        carPositionValues.sort(Collections.reverseOrder());
        return carPositionValues.get(0);
    }

}
