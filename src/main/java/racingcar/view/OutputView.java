package racingcar.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

import racingcar.model.Car;
import racingcar.util.Constants;

public class OutputView {
    private static final List<String> winner = new ArrayList<>();

    public static void askCarNames() {
        System.out.println(Constants.ASK_CAR_NAMES);
    }

    public static void askAttemptsNum() {
        System.out.println(Constants.ASK_ATTEMPTS_NUMBER);
    }

    public static void showAllProcess(Car[] cars, int attemptsNum) {
        for (int i = 0; i < attemptsNum; i++) {
            showProcess(cars);
            System.out.println();
        }
    }

    private static void showProcess(Car[] cars) {
        for (Car car : cars) {
            car.advance();
            int position = car.getPosition();
            System.out.println(car.getName() + " : " + String.join("", Collections.nCopies(position, "-")));
        }
    }

    public static void showWinner(Car[] cars) {

        getWinner(cars);
        System.out.print("최종 우승자 : ");
        for (int i = 0; i < winner.size(); i++) {
            System.out.print(winner.get(i));
            if (i != winner.size() - 1) {
                System.out.print(", ");
            }
        }
    }

    private static void getWinner(Car[] cars) {
        int max_num = getMaxPosition(cars);
        for (Car car : cars) {
            if (car.getPosition() == max_num) {
                winner.add(car.getName());
            }
        }
    }

    private static int getMaxPosition(Car[] cars) {
        int max_position = 0;

        for (Car car : cars){
            if(car.getPosition()>max_position){
                max_position=car.getPosition();
            }
        }
        return max_position;
    }
}
