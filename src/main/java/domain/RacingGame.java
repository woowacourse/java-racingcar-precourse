package domain;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private int trialTime;
    private List<Car> carList = new ArrayList<>();
    private Winner winner;

    /**
     * 유저로 부터 입력을 받기위한 InputManager 인스턴스
     */
    private InputManager inputManager;

    public RacingGame() {
        inputManager = new InputManager();
        winner = new Winner();
    }

    /**
     * game 전체 로직을 순차적으로 실행하는 메서드
     * 데이터를 입력받고, 경주를 진행하고, 우승자를 출력한다.
     */
    public void play() {
        prepareRacing();
        raceCars();
		System.out.println("최종 승자는 " + winner.getWinner(carList) + "입니다.");
    }

    /**
     * 데이터를 입력받고, 경주를 위해 자동차 인스턴스를 생성
     */
    private void prepareRacing() {
        trialTime = inputManager.inputTrialTime();
        for (String name : inputManager.inputCarNames()) {
            carList.add(new Car(name));
        }
    }

    /**
     * 매 시도 마다, Car 객체에 메시지 전송하는 메서드
     */
    private void raceCars() {
        System.out.println("실행 결과");
        for (int i = 0; i < trialTime; i++) {
            carList.stream()
                    .map(car -> car.raceStatus())
                    .forEach(System.out::println);
            System.out.println();
        }
    }
}
