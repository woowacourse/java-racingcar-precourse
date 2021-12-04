package racingcar;

import java.util.ArrayList;

public class Application {
        public static ArrayList<Car> carList;

    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        carList = Reader.inputCarName();

        System.out.println("시도할 회수는 몇회인가요?");
        int numberOfTry = Reader.inputNumberOfTry();

        System.out.println("\n실행 결과");
        for (int i = 0; i < numberOfTry; i++) {
            Race.doOneIterationRace(carList);
        }
        Race.determineWinner(carList);
    }
}
