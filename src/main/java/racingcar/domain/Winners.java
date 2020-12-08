package racingcar.domain;

import java.util.ArrayList;

public class Winners {
    private ArrayList<String> winnerList;

    public Winners(Cars cars) {
        ArrayList<Car> carList = cars.getCarList();
        int maxDistance = getMaxDistance(carList);
        ArrayList<String> winnerEnrollment = new ArrayList<String>();
        carList.forEach(car -> addWinner(winnerEnrollment, car, maxDistance));
        this.winnerList = winnerEnrollment;
    }

    private int getMaxDistance(ArrayList<Car> carList) {
        return carList.stream()                      // carList를 대상으로 하는 스트림 생성
                      .mapToInt(Car::getPosition)    // carList에서 위치 반환
                      .summaryStatistics()           // 통계요약본 만들기
                      .getMax();                     // 최대값 반환
    }

    private void addWinner(ArrayList<String> winner, Car candidate, int maxDistance) {
        if (candidate.isMaxDistance(maxDistance)) {
            winner.add(candidate.getName());
        }
    }

    public ArrayList<String> getWinnerList() {
        return this.winnerList;
    }
}
