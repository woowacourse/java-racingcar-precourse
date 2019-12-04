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


    public void play() {
        while ((cycle--) > 0) {
            moveCars();
            printBoard();
        }

        winner();
    }

    public void moveCars() {
        for (int i = 0; i < cars.size(); i++) {
            if (condition()) {
                cars.get(i).forward();
            }
        }
    }

    public boolean condition() {
        Random rand = new Random();
        int dice = rand.nextInt(10);

        if (dice >= 4) {
            return true;
        }

        return false;
    }

    public void printBoard() {
        for (int i = 0; i < cars.size(); i++) {
            System.out.print(cars.get(i).getName() + " : ");

            for (int j = 0; j <cars.get(i).getPosition(); j++){
                System.out.print("-");
            }

            System.out.println("");
        }
        System.out.println("");
    }

    public void winner() {
        ArrayList<Car> winner = new ArrayList<Car>();

        winner.add(cars.get(0));

        for (int i = 1; i < cars.size(); i++) {
            if (winner.get(0).getPosition() == cars.get(i).getPosition()) {
                winner.add(cars.get(i));
            }
            if (winner.get(0).getPosition() < cars.get(i).getPosition()) {
                winner.clear();
                winner.add(cars.get(i));
            }
        }

        for (int j = 0; j < winner.size(); j++){
            System.out.println(winner.get(j).getName());
        }
    }

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



}
