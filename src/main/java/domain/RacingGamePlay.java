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

    private void actionAllCars() {
        for(int i = 0; i < cars.length; i++) {
            act = new Action(cars[i]);
            act.actBasedOnDecision();
            System.out.println(cars[i].getPosition());
        }
    }
}
