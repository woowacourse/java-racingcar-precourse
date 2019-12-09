/*
 * 클래스 이름   StartGame
 * 버전 정보    1.0
 * 날짜        2019.12.10
 * 저작권      YebinK
 */

package domain;

import java.util.Random;

/**
 * 실행 횟수만큼 자동차별로 랜덤값을 생성해 전진 여부를 '-'로 출력한다.
 * 게임의 최종 우승자도 출력한다.
 */

public class StartGame {

    private Car[] cars;
    private int attempts;
    private StringBuilder winner;
    private int winnerPosition;

    /**
     * 자동차별로 random값을 생성해 전진 여부를 결정, 출력하며 게임을 진행한다.
     * 최종 우승자도 출력한다.
     */

    public void start(Car[] cars, int attempts) {
        this.cars = cars;
        this.attempts = attempts;

        System.out.println("실행 결과");
        for (int i = 0 ; i < this.attempts ; i++) {
            getRandomNumber();
            printResult();
        }
        printWinner();
    }

    /**
     * 게임에 참가하는 자동차 개수만큼 random 값을 생성한다.
     */

    private void getRandomNumber() {
        Random r = new Random();

        for (int i = 0 ; i < cars.length ; i++) {
        int number = r.nextInt(9);
        if (decideToMove(number)) cars[i].increasePosition();
    }
}

    /**
     * random 값이 4 이상이면 true 반환, 그렇지 않으면 false를 반환한다.
     */

    private boolean decideToMove (int number) {
        if (number >= 4) return true;
        return false;
    }

    /**
     * 중간 결과를 출력한다.
     */

    private void printResult() {
        for (int i = 0 ; i < cars.length ; i++) {
            System.out.println(cars[i].getName() + " : " + printDash(cars[i].getPosition()));
        }
        System.out.println('\n');
    }

    private String printDash(int n) {
        String result = "";
        for (int i = 0 ; i < n ; i++) {
            result += '-';
        }
        return result;
    }

    /**
     * 최종 우승자를 출력한다.
     */

    private void printWinner() {
        winner = new StringBuilder();
        winnerPosition = -1;

        for (int i = 0 ; i < cars.length; i++) {
            comparePosition(i);
        }
        System.out.println(winner + "가 최종 우승했습니다.");
    }

    /**
     * 자동차 배열의 현재 자동차 index(carIndex)의 position과 우승자 position을 비교하는 함수.
     * 두 값이 같으면 winner 변수에 현재 자동차 name을 추가해주고,
     * 현재 자동차 position이 더 크면 winner 변수와 winnerPosition 값을 모두 갱신한다.
     */

    private void comparePosition(int carIndex) {
        if (cars[carIndex].getPosition() == winnerPosition) {
            winner.append(", " + cars[carIndex].getName());
        }
        if (cars[carIndex].getPosition() > winnerPosition) {
            winnerPosition = cars[carIndex].getPosition();
            winner = new StringBuilder();
            winner.append(cars[carIndex].getName());
        }
    }
}