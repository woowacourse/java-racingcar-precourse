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

    public static final String MSG_EXECUTION_RESULT = "실행 결과";

    public void run() {
        setCar();
        setMovingNumber();

        startRacing();

        grading();
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

    }
}
