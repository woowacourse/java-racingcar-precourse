package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void carMove(){
        int randNum = Randoms.pickNumberInRange(0, 9);

        if (randNum >= 4){
            this.position += 1;
        }
    }
}
