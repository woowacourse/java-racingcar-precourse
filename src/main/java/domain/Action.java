package domain;

public class Action {
    private Car car;

    public Action(Car car) {
        this.car = car;
    }

    /**
     * 전진 할 경우 자동차 객체를 이동시킨다.
     */
    public void actBasedOnDecision() {
        if(decideAction()) {
            car.move();
        }
    }

    /**
     * 0 에서 9사이에 random 값을 구한다.
     * 구한 값이 4이상일 경우 전진, 3이하일 경우 정지
     * @return  true 일 경우 move, false 일 경우 stop
     */
    public boolean decideAction() {
        int value = randomNumber();
        return value >= ConstValue.ACTION_DECISION_VALUE;
    }

    /**
     * @return  0 ~ 9 까지의 임의의 수
     */
    public int randomNumber() {
        return (int) (Math.random() * ConstValue.RANDOM_NUMBER_RANGE);
    }
}