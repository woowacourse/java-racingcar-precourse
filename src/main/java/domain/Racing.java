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

    }

    public void grading() {

    }
}
