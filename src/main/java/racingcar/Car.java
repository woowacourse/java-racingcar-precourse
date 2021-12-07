package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public String race() {
        int randomNumber = Randoms.pickNumberInRange(0,9);
        if (randomNumber > 3) {
            this.position++;
        }
        String result = this.name+" : ";
        for (int i=0; i<this.position; i++) {
            result += "-";
        }
        return result;
    }

    public static void main(String[] args) {
    }
}
