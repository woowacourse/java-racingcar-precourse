package racingcar;

public class Car {
    private final String name;
    private int position = 0;

    private static final int MIN_NUMBER = 0;
    private static final int MAX_NUMBER = 9;
    private static final int BOUNDARY_NUMBER = 4;

    private static final String MOVE_MARK = "-";

    public Car(String name) {
        this.name = name;
    }

    public void move() {
        int randomNumber = NumberGenerator.generateRandomNumber(MIN_NUMBER, MAX_NUMBER);
        if (randomNumber >= BOUNDARY_NUMBER) {
            position++;
        }
    }

    public void showPosition() {
        System.out.print(name + " : ");
        for (int i = 0; i < position; i++) {
            System.out.print(MOVE_MARK);
        }
        System.out.println();
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}
