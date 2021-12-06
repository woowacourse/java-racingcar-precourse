package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class RacingGame {
    private static final String MSG_PRINT_EXECUTE_RESULT = "실행 결과";
    private static final String MSG_PRINT_WINNER = "최종 우승자 : ";

    private final List<Car> cars;
    private int maxPosition;
    private final Player player;

    public RacingGame() {
        cars = new ArrayList<>();
        maxPosition = 0;
        player = new Player();
    }

    public void play() {
        createCarObjByName(player.inputCarNames());
        int numberOfAttempts = player.inputNumberOfAttempts();
        System.out.println(MSG_PRINT_EXECUTE_RESULT);
        while (numberOfAttempts-- > 0) {
            for (Car car : cars) {
                car.moveForward();
                printEachAttempts(car.getName(), car.getPosition());
                updateMaxPosition(car.getPosition());
            }
            System.out.println();
        }
        printWinner();
    }

    private void printWinner() {
        StringBuilder sb = new StringBuilder();
        sb.append(MSG_PRINT_WINNER);
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                sb.append(car.getName());
                sb.append(", ");
            }
        }
        System.out.println(sb.substring(0, sb.length()-2));
    }

    private void updateMaxPosition(int position) {
        this.maxPosition = Math.max(maxPosition, position);
    }

    private void printEachAttempts(String name, int position) {
        System.out.print(name + " : ");
        while (position-- > 0) {
            System.out.print("-");
        }
        System.out.println();
    }

    private void createCarObjByName(List<String> carNameList) {
        for (String name : carNameList) {
            this.cars.add(new Car(name));
        }
    }
}
