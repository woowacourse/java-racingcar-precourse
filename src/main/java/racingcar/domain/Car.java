package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void carMove() {
        int randNum = Randoms.pickNumberInRange(0, 9);

        if (randNum >= 4) {
            this.position += 1;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void showInfo() {
        String info = getName() + " : ";

        for (int i = 0; i < position; i++) {
            info += "-";
        }
        System.out.println(info);
    }
}
