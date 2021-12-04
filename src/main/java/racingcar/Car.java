package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car implements ICar {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    @Override
    public void pickRandomNumber() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        if (randomNumber >= 4) {
            incrementPosition();
        }
        printPosition();
    }

    private void incrementPosition() {
        position ++;
    }

    private void printPosition() {
        String result = name + " : ";
        for (int i = 0; i < position; i++) {
            result += "-";
        }
        System.out.println(result);
    }
}
