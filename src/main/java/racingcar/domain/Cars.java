package racingcar.domain;

import racingcar.view.ErrorViewer;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.stream.IntStream;

public class Cars {
    private final ArrayList<Car> carList = new ArrayList<Car>();

    public Cars(String[] carNames) {
        checkOverlap(carNames);
        for (String carName : carNames) {
            Car tempCar = new Car(carName);
            carList.add(tempCar);
        }
    }

    private void checkOverlap(String[] carNames) {
        HashSet<String> checkOverlapSet = new HashSet<>(Arrays.asList(carNames));
        if (checkOverlapSet.size() != carNames.length) {
            ErrorViewer.carsInputError();
        }
    }

    public ArrayList<Car> getCarList() {
        return carList;
    }

    /*게임 한턴을 진행시켜주는 메서드 */
    public void processOneTurn() {
        carList.forEach(Car::oneTurn);
    }

    /**
     * 전체 중 우승자를 찾는 메서드
     * @return 우승자들
     */
    public ArrayList<String> getWinners() {
        ArrayList<String> winner = new ArrayList<String>();
        int maxDistance = getMaxDistance();
        carList.forEach(car -> addWinners(winner, car, maxDistance));
        return winner;
    }

    private int getMaxDistance() {
        IntStream carStream = carList.stream().mapToInt(Car::getPosition);
        return carStream.summaryStatistics()    //통계요약본 만들기
                        .getMax();              // 최대값 반환
    }

    private void addWinners(ArrayList<String> winner, Car candidate, int maxDistance) {
        if (candidate.isMaxDistance(maxDistance)) {
            winner.add(candidate.getName());
        }
    }
}
