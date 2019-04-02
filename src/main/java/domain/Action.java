package domain;

public class Action {
    private Car car;

    public Action(Car car) {
        this.car = car;
    }

    public void actBasedOnDecision(){
        if(decideAction()){
            car.move();
        }
    }

    /**
     * 0 에서 9사이에 random 값을 구한다.
     * 구한 값이 4이상일 경우 전진, 3이하일 경우 정지
     * @return  true 일 경우 move, false 일 경우 stop
     */
    private boolean decideAction() {
        int value = randomNumber();
        return value >= 4;
    }

    private int randomNumber() {
        return (int) (Math.random() * 10 + 1);
    }
}
