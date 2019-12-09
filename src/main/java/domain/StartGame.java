/*
 * 클래스 이름   StartGame
 * 버전 정보    1.0
 * 날짜        2019.12.05
 * 저작권      YebinK
 */

package domain;

import java.util.Random;

public class StartGame {

    private Car[] cars;
    private int attempts;

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

    private void getRandomNumber() {
        Random r = new Random();

        for (int i = 0 ; i < cars.length ; i++) {
            int number = r.nextInt(9);
            if (decideToMove(number)) cars[i].increasePosition();
        }
    }

    private boolean decideToMove (int number) {
        if (number >= 4) return true;
        return false;
    }

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

    private void printWinner() {
        StringBuilder winner = new StringBuilder();
        int winnerScore = -1;

        for (int i = 0 ; i < cars.length; i++) {
            if (cars[i].getPosition() > winnerScore) {
                winnerScore = cars[i].getPosition();
                winner.append(cars[i].getName());
            } else if (cars[i].getPosition() == winnerScore) {
                winner.append(", " + cars[i].getName());
            }
        }
        System.out.println(winner + "가 최종 우승했습니다.");
    }
}