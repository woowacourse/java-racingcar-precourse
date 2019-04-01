package domain;

import java.util.ArrayList;

public class RaceingGameController {

    public void gameStart(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        ArrayList<Car> carNameList = Input.getInstance().enrollCarName();

        System.out.println("시도할 회수는 몇회인가요?");
        int tryNumber = Input.getInstance().tryNumber();

        System.out.print("자동차 등록 이름 : ");
        for(Car cars : carNameList){
            System.out.print(cars.getName());
        }
        System.out.println();
        System.out.println("시도할 횟수 : " + tryNumber);

    }


}
