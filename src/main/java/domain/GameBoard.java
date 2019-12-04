/**
 * class name : GameBoard
 *
 * version : V 0.1
 *
 * date : 2019.12.4
 *
 * copyright :
 *
 * description : 게임진행, 규칙에 관련된 클래스
 */

package domain;
import java.util.ArrayList;
import java.util.Random;

public class GameBoard {
    ArrayList<Car> cars = new ArrayList<Car>();
    int cycle;

    public void createCars(String inputCarNames) {
        String[] carNames = inputCarNames.split(",");

        for (int i = 0; i < carNames.length; i++) {
            if (carNames[i].length() <= 5) {
                Car car = new Car(carNames[i]);
                cars.add(car);
            }
        }
    }

    public void setCycle(int cycle) {
        this.cycle = cycle;
    }

    public void play() {
        while ((cycle--) > 0) {

        }
    }

    public boolean condition() {
        Random rand = new Random();

        int dice = rand.nextInt(10);

        if (dice >= 4) {
            return true;
        }
        if (dice >= 0) {
            return false
        }


    }

}
