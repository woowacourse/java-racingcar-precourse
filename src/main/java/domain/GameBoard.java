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
        System.out.println("Play");
    }

}
