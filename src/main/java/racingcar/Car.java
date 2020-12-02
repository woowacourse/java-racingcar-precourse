package racingcar;

import utils.RandomUtils;

public class Car {
    private final String name;
    private int position = 0;
    private static int timesToTry = 0;

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", position=" + position +
                ", timesToTry=" + timesToTry +
                '}';
    }

    public Car(String name) {
        this.name = name;
    }

    // 추가 기능 구현
    public String getName() {
        return this.name;
    }

    public static int getTimesToTry() {
        return timesToTry;
    }

    public static void setTimesToTry(int timesToTryLocal) {
        timesToTry = timesToTryLocal;
    }

    public void moveOrStay() {
        int randomValue = getRandomValue();
        if (isRandomValueMoreThan4(randomValue)) {
            position++;
        }
    }

    public int getRandomValue() {
        return RandomUtils.nextInt(0, 9);
    }

    public boolean isRandomValueMoreThan4(int randomValue) {
        return randomValue >= 4;
    }

    public static void useOneTurn() {
        timesToTry--;
    }
}
