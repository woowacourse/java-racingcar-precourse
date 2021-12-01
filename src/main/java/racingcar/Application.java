package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] carNames = Console.readLine().split(",");

        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }

        System.out.println("시도할 회수는 몇회인가요?");
        int trialNum = Integer.parseInt(Console.readLine());

        System.out.println("실행 결과");

        for (int i = 0; i < trialNum; i++) {
            for (Car car : cars) {
                car.play();
            }
            System.out.println();
        }
    }
}
