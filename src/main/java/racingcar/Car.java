package racingcar;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void PlayMoving() {
        TryMoveForward();
        PrintResult();
    }

    final public static int MIN_NUMBER=0;
    final public static int MAX_NUMBER=9;

    public void TryMoveForward(){
        int randomNumber=pickNumberInRange(MIN_NUMBER,MAX_NUMBER);
        if(randomNumber>=4){
            position++;
        }
    }

    public void PrintResult(){
        System.out.print(name+" : ");
        for(int i=0;i<position;++i){
            System.out.print("-");
        }
        System.out.print("\n");
    }

    public String getName(){
        return name;
    }

    public int getPosition(){
        return position;
    }
}
