package racingcar;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import utils.Printer;

import java.util.*;

public class CarRacingGame {
    private List<Car> carList;
    private int playRound;

    public CarRacingGame(List<String> inputList, int playRound) {
        carList = new ArrayList<>();
        setCarList(inputList);
        this.playRound = playRound;
    }

    public void setCarList(List<String> inputList) {
        for (String car : inputList) {
            carList.add(new Car(car));
        }
    }

    public void inputTest() {
        System.out.println("--------------");
        System.out.println("입력값 테스트");
        for (Car car : carList)
        {
            System.out.print(car.getName() + " ");
        }
        System.out.println();
        System.out.println(playRound);
        System.out.println("--------------");
    }


}
