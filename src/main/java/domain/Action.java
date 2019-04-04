package domain;

/**
 * random 하게 생성된 임의의 수에 따라
 * moveCarPosition 할지 stop 할지 action 을 정하고
 * 수행하는 class
 */
public class Action {

    private Car car;

    public Action(Car car) {
        this.car = car;
    }

    /* 전진 할 경우 자동차 객체를 이동시킨다. */
    public void actBasedOnDecision() {
        if (decideAction()) {
            car.moveCarPosition();
        }
    }

    /**
     * 0 에서 9사이에 random 값을 구한다.
     * 구한 값이 4이상일 경우 전진, 3이하일 경우 정지
     *
     * @return true 일 경우 moveCarPosition, false 일 경우 stop
     */
    private boolean decideAction() {
        int value = makeRandomNumber();
        return value >= ConstValue.ACTION_DECISION_VALUE;
    }

    private int makeRandomNumber() {
        return (int) (Math.random() * ConstValue.RANDOM_NUMBER_RANGE);
    }
}