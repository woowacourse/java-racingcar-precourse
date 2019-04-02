package domain;

import java.util.ArrayList;

public class Winner {
    private Car[] cars;
    private ArrayList<String> winnerList;
    private int maxDistance;

    public Winner(Car[] cars) {
        this.cars = cars;
        this.winnerList = new ArrayList<>();
    }

    /* 우승자를 찾아내서 출력하는 과정 */
    public void getWinner() {
        findMaxDistance();
        findWinner();
        printWinner();
    }

    /**
     * 각각의 자동차의 position 을 비교하여
     * 최대값을 갖는 position 값을 maxDistance 로 설정한다.
     */
    public void findMaxDistance() {
        int maxValue;

        maxValue = ConstValue.MINIMUM_DISTANCE_VALUE;
        for (int i = 0; i <cars.length; i++) {
            maxValue = max(maxValue, cars[i].getPosition());
        }

        setMaxDistance(maxValue);
    }

    /**
     * 각각의 자동차 객체에 대하여 우승자를 찾는다.
     * 현재 position 과 maxDistance 값과 비교한다.
     */
    public void findWinner() {
        for(int i = 0; i < cars.length; i++) {
            putValidWinner(cars[i]);
        }
    }

    /* car 객체가 우승자인지 판단 후 우승자 리스트에 추가 */
    public void putValidWinner(Car car) {
        if (isMaxPosition(car)) {
            winnerList.add(car.getName());
        }
    }

    /* car 객체의 현재 position 이 최대값인지 확인 */
    public boolean isMaxPosition(Car car) {
        return car.getPosition() == maxDistance;
    }

    /**
     * 우승자가 여러명일 경우 쉼표(,)로 구분하여 출력한다.
     */
    public void printWinner() {
        String winners;

        winners = String.join(", ", winnerList);

        System.out.printf(winners);
        System.out.println("가 최종 우승했습니다.");
    }

    public int max(int a, int b) {
        return a > b ? a : b;
    }

    public void setMaxDistance(int maxDistance) {
        this.maxDistance = maxDistance;
    }
}
