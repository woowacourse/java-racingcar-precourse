package domain;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public static String carName(Car a) {
        return a.name;
    }

    public static int carPosition(Car a) {
        return a.position;
    }

    public static void addPosition(Car a, int forward) {
        a.position += forward;
    }

    public static void positionState(Car a) {
        System.out.printf("%s", a.name);
        for(int i = 0; i < a.position; i++) {
            System.out.print("-");
        }
        System.out.print("\n");
    }

}
