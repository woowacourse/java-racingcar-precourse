package racingcar;
import camp.nextstep.edu.missionutils.Randoms;


public class Car {
    private final String name;
    private int position = 0;
    private static final int STANDARD = 4;

    public Car(String name) {
        this.name = name;
    }

    public void movement() {
        int randomData = Randoms.pickNumberInRange(0, 9);
        if (randomData >= STANDARD) {
            position += 1;
        }
    }

    public void printCarData() {
        System.out.print(name + " : ");
        for (int i = 0; i<position; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public int getPosition() {
        return this.position;
    }

    public String getName() {
        return this.name;
    }
}
