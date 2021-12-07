package racingcar;

public class Car {
    private final String name;
    private int position = 0;


    public Car(String name) {
        this.name = name;
    }

    public void move() {
        int randomNumber = NumberGenerator.generateRandomNumber(RacingCarConstant.MIN_NUMBER, RacingCarConstant.MAX_NUMBER);
        if (randomNumber >= RacingCarConstant.BOUNDARY_NUMBER) {
            position++;
        }
    }

    public void showPosition() {
        System.out.print(name + " : ");
        for (int i = 0; i < position; i++) {
            System.out.print(RacingCarConstant.MOVE_MARK);
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
