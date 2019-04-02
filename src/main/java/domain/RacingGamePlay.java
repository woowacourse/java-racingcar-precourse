package domain;

public class RacingGamePlay {

    private User user;
    private Car[] cars;
    private Action act;

    /**
     * User 의 입력을 받아 경주할 자동차를 셋팅한다.
     */
    public RacingGamePlay() {
        user = new User();
        createCars(user.getCarNames());
    }

    /**
     * 게임을 진행하는 함수
     * 사용자가 입력한 시도 횟수에 따라 이동을 진행한다.
     * 실행이 완료된 후 우승자를 알려준다.
     */
    public void play() {
        int trialCount;

        System.out.println("실행 결과");
        trialCount = user.getNumberOfTrials();
        while(trialCount > 0){
            actionAllCars();
            trialCount--;
        }
    }

    /**
     * car 객체 생성(name 개수 만큼)
     * @param carNames  : car's name 을 저장한 String 배열
     */
    private void createCars(String[] carNames) {
        cars = new Car[carNames.length];

        for(int i = 0; i < cars.length; i++) {
            cars[i] = new Car(carNames[i]);
        }
    }

    /**
     * 매 시도마다 자동차의 action 을 결정한다.
     * 결정된 action 에 따라서 이동 or 정지한다.
     * 정지 일 경우 이동하지 않는다(따로 함수 호출 안함)
     */
    private void actionAllCars() {
        for(int i = 0; i < cars.length; i++) {
            act = new Action(cars[i]);
            act.actBasedOnDecision();
            System.out.println(cars[i].getPosition());
        }
    }
}
