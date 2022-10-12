package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Game {
    { playGame(); }
    Player player;
    Car[] cars;
    int rounds;

    Game() { // Game의 생성자, 게임 시작을 위한 초기 세팅
        player = new Player();
        rounds = player.rounds;
        cars = new Car[player.cars.length]; // 자동차 n개의 배열을 위한 메모리 할당
        for (String car : player.cars) { // n개의 car 인스턴스 생성
            cars[i] = new Car(car);
        }
    }

    public void playGame() { // 입력 횟수만큼 반복
        for (int i = 0; i < player.round; i++) {
            startRound();
        }
    }

    public void startRound() {
        for (int j = 0; j < player.cars.length; j++) {
            boolean move = moveForward(Randoms.pickNumberInRange(0, 9));

        }
    }

    public boolean moveForward(int randomNumber) {
        if (randomNumber >= 4) {
            return true;
        }

        return false;
    }

    public int getRandomNumbers() {

    }

    public void printProgress() {

    }

    public void printResult() {

    }
}
