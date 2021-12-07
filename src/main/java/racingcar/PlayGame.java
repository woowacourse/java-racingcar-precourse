package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class PlayGame {
    private InputCarName inputCarName;
    private InputCount inputCount;

    private Car[] cars;
    private int playCount;

    // 위에서 쓸 객체들 생성
    public PlayGame() {
        inputCarName = new InputCarName();
        inputCount = new InputCount();
    }

    // 외부 입력 값을 받아와서 초기화해주는 메소드
    private void init() {
        cars = inputCarName.getCars();
        playCount = inputCount.stringToInteger();
    }

    // 실제 게임을 실행하는 메서드
    public void playGame() {
        init();
        System.out.println();
        System.out.println("실행 결과");
        for(int i = 0; i<playCount;i++) {
            perGame();
            System.out.println();
        }
        Winner winner = new Winner(cars);
        System.out.println(winner.result());
    }

    // 한번 게임이 실행될 때마다 각 자동차에게 랜덤 수 생성해서 전진/멈춤 유무 판단
    private void perGame() {
        for(int i = 0; i<cars.length;i++){
            int score = randomNumber();
            checkScore(cars[i], score);
            printPosition(cars[i]);
        }
    }

    // 점수 파악한 후 4점이상이면 위치 1 증가시키는 메서드
    private void checkScore(Car car, int score) {
        if(score>=4) { // 4이상이면 직진 가능
            car.addPosition();
        }
    }

    // 0부터 9사이의 랜덤한 수 반환해주는 메서드
    private int randomNumber() {
        return Randoms.pickNumberInRange(0,9);
    }

    // 현재 자동차의 이름과 위치를 출력해주는 메서드
    private void printPosition(Car car) {
        System.out.println(car.toString());
    }
}
