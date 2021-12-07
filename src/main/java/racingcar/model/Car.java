package racingcar.model;

public class Car {
    private static final String POSITION_CHARACTER = "-";
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void printResult() {
        printCarName();
        attemptAdvance();
        printPosition();
    }

    public void attemptAdvance() {
        if (RaceModel.getRandomAdvanceResult()) {
            position++;
        }
    }

    private void printCarName() {
        System.out.print(this.name + " : ");
    }

    private void printPosition() {
        for (int i = 0; i < position; i++) {
            System.out.print(POSITION_CHARACTER);
        }
        System.out.println();
    }
}
