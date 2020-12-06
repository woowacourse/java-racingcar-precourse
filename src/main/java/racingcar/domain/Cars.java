package racingcar.domain;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashSet;

import racingcar.view.InputViewer;
import racingcar.view.OutputViewer;

public class Cars {
    private final ArrayList<Car> carList = new ArrayList<Car>();

    public Cars(String[] carNames) {
        checkOverlap(carNames);
        for (String carName : carNames) {
            Car tempCar = new Car(carName);
            this.carList.add(tempCar);
        }
    }

    private void checkOverlap(String[] carNames) {
        HashSet<String> checkOverlapSet = new HashSet<>(Arrays.asList(carNames));
        if (checkOverlapSet.size() != carNames.length) {
            InputViewer.carsInputError();
        }
    }

    /*게임 한턴을 진행시켜주는 메서드 */
    public void oneTurn() {
        processOneTurn();
        showTurnResult();
    }

    private void processOneTurn() {
        for (Car car : this.carList) {
            car.oneTurn();
        }
    }

    private void showTurnResult() {
        for (Car car : this.carList) {
            OutputViewer.participantScoreName(car.getName(), car.getPosition());
        }
        OutputViewer.spaceBetweenGames();
    }

    /**
     * 전체 중 우승자를 찾는 메서드
     * @return 우승자들
     */
    public ArrayList<String> getWinners() {
        ArrayList<String> winner = new ArrayList<String>();
        int maxDistance = getMaxDistance();
        for (Car car : this.carList){
            addWinners(winner, car, maxDistance);
        }
        return winner;
    }

    private int getMaxDistance() {
        int maxDistance = 0;
        for (Car car : this.carList) {
            maxDistance = compareDistance(car, maxDistance);
        }
        return maxDistance;
    }

    private int compareDistance(Car car, int maximumNumber) {
        return Math.max(maximumNumber, car.getPosition());
    }

    private void addWinners(ArrayList<String> winner, Car candiate, int maxDistance) {
        if (candiate.isMaxDistance(maxDistance)) {
            winner.add(candiate.getName());
        }
    }
}
