package domain;

import java.util.ArrayList;
import java.util.Scanner;

public class Controller {

    Scanner scanner = new Scanner(System.in);
    ArrayList<Car> cars = new ArrayList<>();
    int laps;
    private int winnerPosition = 0;
    String[] racers;

    public void askCarsName() {
        String names;

        do {
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉽표(,) 기준으로 구분");
            names = scanner.nextLine();

        } while (!checkNamesCriterion(names));

    }

    public void askNumberOfAttempts() {
        System.out.println("시도할 회수는 몇회인가요?");
        laps = scanner.nextInt();
    }

    /* 이름의 정당성 확인 및 split 기능 구현 */
    public boolean checkNamesCriterion(String name) {
        racers = name.split(",");

        for (String each : racers) {

            if (each.length() > 5) {
                System.out.println("이름을 5자 이하로 적어주세요");
                return false;
            }

        }

        return true;
    }

    public void startGame() {

        for (String racer : racers) {
            Car car = new Car(racer);
            cars.add(car);
        }

    }

    public void checkCarsPosition() {
        int carPosition;

        for (Car eachCar : cars) {
            carPosition = eachCar.getPosition();
            eachCar.goForward();
            System.out.printf("%s : ", eachCar.getCarsName());

            if (winnerPosition < carPosition) {
                winnerPosition = carPosition;
            }

            printCarRoad(carPosition);
        }

        System.out.println();
    }

    public void printCarRoad(int position) {
        for (int i = 0; i < position; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public void checkWinner() {
        for(Car eachCar : cars) {
            if(eachCar.getPosition() == winnerPosition){
                System.out.print(eachCar.getCarsName());
            }
        }
        System.out.println("가 최종 우승했습니다.");
    }

    public int getLaps() {
        return laps;
    }

}
