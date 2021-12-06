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
        PrintPosition();
    }

    private void RandomNum(){
        int num = Randoms.pickNumberInRange(0,9);
        if(num >= 4){
            position ++;
        }
    }

    private void PrintPosition(){
        System.out.print(name + " : ");
        for(int i=0; i<position; i++){
            System.out.print("-");
        }
        System.out.println();
    }
}
