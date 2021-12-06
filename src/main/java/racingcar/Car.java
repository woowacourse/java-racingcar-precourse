package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    // 추가 기능 구현

    public void CarPlay(){
        RandomNum();
    }

    private void RandomNum(){
        int num = Randoms.pickNumberInRange(0,9);
        if(num >= 4){
            position ++;
        }
    }
}
