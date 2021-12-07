package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class PlayGame {
    private InputCarName inputCarName;
    private InputCount inputCount;

    private Car[] cars;
    private int playCount;

    public PlayGame() {
        inputCarName = new InputCarName();
        inputCount = new InputCount();
    }

    private void init() {
        cars = inputCarName.getCars();
        playCount = inputCount.stringToInteger();
    }

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
            int score = Randoms.pickNumberInRange(0,9);
            if(score>=4) { // 4이상이면 직진 가능
                cars[i].addPosition();
            }
            System.out.println(cars[i].toString()); // 메소드로 변경
        }
    }
}
