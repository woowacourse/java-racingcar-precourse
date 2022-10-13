package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Vector;

public class Game {
    Player player;
    Car[] cars;
    int rounds;
    int firstPosition;
    Vector<String> winners;

    Game() { // Game의 생성자, 게임 시작을 위한 초기 세팅
        winners = new Vector();
        firstPosition = 0;
        player = new Player();
        rounds = player.rounds;
        cars = new Car[player.cars.length]; // 자동차 n개의 배열을 위한 메모리 할당
        for (int i = 0; i < player.cars.length; i++) { // n개의 car 인스턴스 생성
            cars[i] = new Car(player.cars[i]);
        }
    }

    public void playGame() { // 입력 횟수만큼 반복
        for (int i = 0; i < rounds; i++) {
            startRound();
            printProgress();
        }
        getWinners();
        finishGame();
    }

    public void startRound() {
        for (int i = 0; i < cars.length; i++) {
            if (moveForward(Randoms.pickNumberInRange(0, 9))) { // 난수 생성 및 4보다 큰지 판단
                cars[i].moveForward();
            }
        }
    }

    public boolean moveForward(int randomNumber) {
        if (randomNumber >= 4) {
            return true;
        }

        return false;
    }

    public void printProgress() {
        for (int i = 0; i < cars.length; i++) {
            String name = cars[i].getName();
            int position = cars[i].getPosition();
            System.out.print(name + " : ");
            for (int j = 0; j < position; j++) {
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }

    public int getFirstPosition() {
        int firstPosition = 0;
        for (int i = 0; i < cars.length; i++) {
            int tmp = cars[i].getPosition();
            if (tmp < firstPosition) {
                continue;
            }
            firstPosition = tmp;
        }

        return firstPosition;
    }

    public void getWinners() {
        int firstPosition = getFirstPosition();
        for (int i = 0; i < cars.length; i++) {
            int tmp = cars[i].getPosition();
            if (tmp == firstPosition) {
                winners.add(cars[i].getName());
            }
        }
    }

    public void finishGame() {
        String result = String.join(", ", winners);
        System.out.print("최종 우승자 : " + result);
    }
}
