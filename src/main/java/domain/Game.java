/**
 * Game.java
 * 아직 리팩토링 중...
 * 우아한테크코스 프리코스 2주차.
 * Original code https://github.com/hotheadfactory/java-racingcar-precourse
 * Version: v0.0.1, 2019.12.05 (c) 정회형
 */
package domain;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private User user = new User();

    public void startGame() {
        List<Car> cars = enrollPlayers();
        startRace(cars, user.getTurnNumber());
        printWinner(cars);
    }

    private List<Car> enrollPlayers() {
        String[] carArray = user.getCarNames();
        List<Car> cars = new ArrayList<Car>();
        for (String oneCar : carArray) {
            cars.add(new Car(oneCar));
        }
        return cars;
    }

    private void startRace(List<Car> cars, int turnNumber) {
        System.out.println("실행 결과");
        for (int i = 0; i < turnNumber; i++) {
            playOneTurn(cars);
        }
    }

    private void playOneTurn(List<Car> cars) {
        for (Car oneCar : cars) {
            oneCar.playTurn();
        }
        System.out.println();
    }

    private void printWinner(List<Car> cars) {
        List<String> winnerList = getWinner(cars);
        for (int i = 0; i < winnerList.size(); i++) {
            System.out.printf("%s", winnerList.get(i));
            if (i != winnerList.size() - 1) {
                System.out.printf(", ");
            }
        }
        System.out.printf("님이 최종 우승했습니다.\n");
    }

    private List<String> getWinner(List<Car> cars) {
        int maxScore = getMaxScore(cars);
        List<String> winnerList = new ArrayList<String>();
        for (Car oneCar : cars) {
            if (oneCar.getPosition() == maxScore) {
                winnerList.add(oneCar.getName());
            }
        }
        return winnerList;
    }

    private int getMaxScore(List<Car> cars) {
        int maxScore = 0;
        for (Car oneCar : cars) {
            int thisCarPosition = oneCar.getPosition();
            if (thisCarPosition > maxScore) {
                maxScore = thisCarPosition;
            }
        }
        return maxScore;
    }

}
