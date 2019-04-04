/*
 * @class       Racing class
 * @version     1.0.0
 * @date        19.04.04
 * @author      OHSANG SEO (tjdhtkd@gmail.com)
 * @brief       include racing game info.
 */

package domain;

import java.util.*;

public class Racing {
    private List<Car> cars = new ArrayList<>();
    private int movingNumber = 0;
    private List<String> winners = new ArrayList<>();

    public static final String MSG_EXECUTION_RESULT = "실행 결과";
    public static final String MSG_PRINT_WINNER = "가 최종 우승했습니다.";

    public void run() {
        setCar();
        setMovingNumber();

        startRacing();

        grading();
        printWinner();
    }

    public void setCar() {
        UserInput userInput = new UserInput();
        String[] names = userInput.enterCar();

        for (String name : names) {
            cars.add(new Car(name));
        }
    }

    public void setMovingNumber() {
        UserInput userInput = new UserInput();
        movingNumber = userInput.enterMovingNumber();
    }

    public void startRacing() {
        System.out.println("\n" + MSG_EXECUTION_RESULT);
        for (int i = 0; i < movingNumber; i++) {
            for (Car car : cars) {
                car.move();
                car.printCurrentPosition();
            }
            System.out.println();
        }
    }

    public void grading() {
        int topScore = 0;

        for (int i = 0; i < cars.size(); i++) {
            if (cars.get(i).getPosition() == topScore) {
                winners.add(cars.get(i).getName());
            }
            if (cars.get(i).getPosition() > topScore) {
                winners.clear();
                winners.add(cars.get(i).getName());
                topScore = cars.get(i).getPosition();
            }
        }
    }

    public void printWinner() {
        System.out.print(winners.get(0));
        if (winners.size() > 1) {
            for (int i = 1; i < winners.size(); i++) {
                System.out.print(", " + winners.get(i));
            }
        }
        System.out.println(MSG_PRINT_WINNER);
    }
}
