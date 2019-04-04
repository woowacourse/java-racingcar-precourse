package domain;

import java.util.ArrayList;

/**
 * car 객체의 position 을 비교하여
 * 우승자를 정하는 class
 * 우승자는 1명 이상일 수 있다.
 */
public class Winner {

    private Car[] cars;
    private ArrayList<String> winnerList;
    private int maxDistance;

    public Winner(Car[] cars) {
        this.cars = cars;
        this.winnerList = new ArrayList<>();
    }

    public void callFindWinnerFunctions() {
        findMaxDistance();
        findWinner();
        printWinner();
    }

    /**
     * 각각의 자동차의 position 을 비교하여
     * 최대값을 갖는 position 값을 maxDistance 로 설정한다.
     */
    private void findMaxDistance() {
        int maxValue;

        maxValue = ConstValue.MINIMUM_DISTANCE_VALUE;
        for (int i = 0; i < cars.length; i++) {
            maxValue = max(maxValue, cars[i].getPosition());
        }
        setMaxDistance(maxValue);
    }

    private void findWinner() {
        for (int i = 0; i < cars.length; i++) {
            addValidWinner(cars[i]);
        }
    }

    private void addValidWinner(Car car) {
        if (isMaxPosition(car)) {
            winnerList.add(car.getName());
        }
    }

    private boolean isMaxPosition(Car car) {
        return car.getPosition() == maxDistance;
    }

    /* 우승자가 여러명일 경우 쉼표(,)로 구분하여 출력한다. */
    private void printWinner() {
        String winners;

        winners = String.join(", ", winnerList);

        System.out.format("%s 이(가) 최종 우승했습니다.\n", winners);
    }

    private int max(int a, int b) {
        return a > b ? a : b;
    }

    private void setMaxDistance(int maxDistance) {
        this.maxDistance = maxDistance;
    }
}
