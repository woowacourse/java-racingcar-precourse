package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Racing {

    private List<Car> lineup;

    public Racing() {
        this.lineup = new ArrayList<>();
    }

    public void start() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] waitingCarNames = Console.readLine().split(",");
        enroll(waitingCarNames);
    }

    private void enroll(String[] waitingCarNames) {
        for (int i = 0; i < waitingCarNames.length; i++) {
            String carName = waitingCarNames[i].trim();
            try {
                validateCarName(carName);
                Car car = new Car(carName);
                lineup.add(car);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                this.lineup = new ArrayList<>();
                String[] retriedWaitingCarNames = Console.readLine().split(",");
                enroll(retriedWaitingCarNames);
            }
        }
    }

    private void validateCarName(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("[ERROR] 이름의 길이가 5를 넘습니다");
        }
    }
}
