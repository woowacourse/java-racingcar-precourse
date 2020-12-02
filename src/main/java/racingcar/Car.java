package racingcar;

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
}
