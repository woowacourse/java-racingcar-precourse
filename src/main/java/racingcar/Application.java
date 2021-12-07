package racingcar;

import constants.SystemMessage;
import jdk.internal.util.xml.impl.Pair;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO 구현 진행

        // 입력을 받는다
        // 입력값이 잘못되었으면 다시 입력을 받는다.
        List<String> parsedCarName = Player.getCarName();
        int turn = Player.getTurnNumber();
        List<Car> carList = Car.makeCarNameToCarList(parsedCarName);

        // 횟수만큼 실행한다
        do {
            Car.play(carList);
            System.out.println("");
            turn--;
        } while (turn>0);


        // 결과를 출력한다
        Utils.getFinalResult(carList);
    }
}
