package racingcar;

import java.util.*;

public class Racing {

    static final String TRIAL_RESULT = "실행 결과";

    public List<Car> makeCars(List<String> carNames) {
        List<Car> carList = new ArrayList<>();
        for (String carName : carNames) {
            Car car = new Car(carName);
            carList.add(car);
        }
        return carList;
    }

    public void oneTrialGame(List<Car> carList) {
        for (Car car : carList) {
            car.tryMove();
            System.out.print(car.getName() + " : ");
            printMove(car.getPosition());
        }

    }

    public void printMove(int move) {
        for (int i = 0; i < move; i++) {
            System.out.print("-");
        }
    }

    public int winnerPosition(List<Car> carList) {
        List<Integer> carPosition = new ArrayList<>();
        for (Car car : carList) {
            carPosition.add(car.getPosition());
        }
        return Collections.max(carPosition);
    }

    public List<String> getWinnersList(List<Car> carList, int winnerPosition) {
        List<String> winners = new ArrayList<>();
        for(Car car : carList) {
            if(car.getPosition() == winnerPosition) {
                winners.add(car.getName());
            }
        }
        return winners;
    }

    public void printWinnersName(List<String> winners) {
        Iterator<String> iterator = winners.iterator();
        if (iterator.hasNext()) {
            System.out.print(iterator.next());
        }
        while (iterator.hasNext()) {
            System.out.print(", " + iterator.next());
        }
    }




}
