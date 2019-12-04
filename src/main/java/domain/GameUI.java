/**
 * class name : GameUI
 *
 * version : V 0.1
 *
 *
 * date : 2019.12.4
 *
 * copyright :
 *
 * description : input, output, 게임 진행을 담당하는 클래
 */

package domain;

import java.util.Scanner;
import java.util.ArrayList;

public class GameUI {
    Scanner sc = new Scanner(System.in);
    ArrayList<Car> cars = new ArrayList<Car>();

    public void createCars() {
        String inputCarName = sc.nextLine();
        String[] carNames = inputCarName.split(",");

        for (int i = 0; i < carNames.length; i++) {
            if (carNames[i].length() <= 5) {
                Car car = new Car(carNames[i]);
                cars.add(car);
            }
        }
    }
}
