package domain;

/**
 * RacingGame 을 진행하는 class
 * car 객체를 생성하고 현재 상태를 출력한다.
 *
 * @author 강연욱
 */
public class RacingGamePlay {

    private User user;
    private Car[] cars;
    private Action act;
    private Winner win;

    /* User 의 입력을 받아 경주할 자동차를 셋팅한다. */
    public RacingGamePlay() {
        user = new User();
        createCarObjects(user.getCarNames());
    }

    public void play() {
        System.out.println("실행 결과");

        excuteRacingBasedOnTrialCount();

        win = new Winner(cars);
        win.callFindWinnerFunctions();
    }

    private void excuteRacingBasedOnTrialCount() {
        int trialCount;

        trialCount = user.getNumberOfTrials();
        while (trialCount > 0) {
            actionAllCars();
            callAllCarsPrintFunction();

            trialCount--;
            System.out.println();
        }
    }

    private void createCarObjects(String[] carNames) {
        cars = new Car[carNames.length];

        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(carNames[i]);
        }
    }

    /**
     * 매 시도마다 car 객체의 action 을 결정한다.
     * 결정된 action 에 따라서 이동 or 정지한다.
     * 정지 일 경우 이동하지 않는다(따로 함수 호출 안함)
     */
    private void actionAllCars() {
        for (int i = 0; i < cars.length; i++) {
            act = new Action(cars[i]);
            act.actBasedOnDecision();
        }
    }

    private void callAllCarsPrintFunction() {
        for (int i = 0; i < cars.length; i++) {
            printNowCarPosition(cars[i]);
        }
    }

    /**
     * car 객체 이름과 현재 position 을 출력한다.
     *
     * @param car : 자동차 객체
     */
    private void printNowCarPosition(Car car) {
        System.out.format("%s : ", car.getName());
        for (int i = 0; i < car.getPosition(); i++) {
            System.out.printf("-");
        }
        System.out.println();
    }
}