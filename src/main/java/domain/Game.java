/*
 *@(#)Game.java           1.0 2019/04/04
 *Copyright (c) 2019 Hyogeon Kim.
 *Racing Car Game, Java, Mungyeong, KOREA
 */

package domain;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;

/**
 * 자동차 경주 게임에 관련 된 클래스
 *
 * @author 김효건
 * @version 1.0 2019년 04월 04일
 */

public class Game {
        /* 게임 시작
         * 입력 지시 메세지
         * 결과 출력 메세지
         * 차 이름, 시도 횟수 입력
         * 1싸이클 진행
         * 난수 발생 및 전진 조건 생성
         * 이동 최대값 추출
         * 우승자 메시지 출력
         * 우승자 이름 ','로 구분
         * 입력 예외처리
         * 구현
         *  */

        /*차 이름 최대 길이*/
        private static final int MAXCARNAMENUMBER = 5;

        /*난수 발생 최대값+1*/
        private static final int MAXRANDOMNUMBER = 10;

        /*난수 중 움직일 최솟값*/
        private static final int MINMOVENUMBER = 4;

        private Car[] cars;
        private int trialNumber;

        Game() {
        }

        /*게임을 시작하는 메서드*/
        public void start() {
                do {
                        printCarNamesInputMessage();
                } while (!inputCarNames());
                do {
                        printTrialNumberInputMessage();
                } while (!inputTrialNumber());
                printResultMessage();
                for (int i = 0; i < trialNumber; i++) {
                        playOneCycle();
                }
                printWinnerMessage();
        }

        /*자동차 전진/정지하는 1싸이클 진행하는 메서드*/
        private void playOneCycle() {
                for (Car car : cars) {
                        car.printName();
                        System.out.print(" : ");
                        if (isMove()) {
                                car.moveCar();
                        }
                        car.printPosition();
                }
                System.out.println();
        }

        /*자동차 이름 입력 지시하는 메세지 출력 메서드*/
        private void printCarNamesInputMessage() {
                System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
        }

        /*자동차 이름들을 입력받는 메서드*/
        private boolean inputCarNames() {
                Scanner scan = new Scanner(System.in);
                String inputCarNames = scan.nextLine();

                String[] splitedCarNames = inputCarNames.split(",");
                for (int i = 0; i < splitedCarNames.length; i++) {
                        if (!checkInputCarNames(splitedCarNames[i]))
                                return false;
                }
                cars = new Car[splitedCarNames.length];
                for (int i = 0; i < splitedCarNames.length; i++) {
                        cars[i] = new Car(splitedCarNames[i]);
                }
                return true;
        }

        /*자동차 이름이 올바른지 검사하는 메서드*/
        private boolean checkInputCarNames(String inputCarNames) {
                if (inputCarNames.length() > MAXCARNAMENUMBER) {
                        System.err.println("차 이름 길이 초과 오류");
                        return false;
                }

                for (int i = 0; i < inputCarNames.length(); i++) {
                        if (!(inputCarNames.charAt(i) >= 'a' && inputCarNames.charAt(i) <= 'z')
                                && !(inputCarNames.charAt(i) >= 'A' && inputCarNames.charAt(i) <= 'Z')) {
                                System.err.println("차 이름 입력 형식 오류 (알파벳만 입력)");
                                return false;
                        }
                }
                return true;
        }

        /*시도 횟수 입력을 지시하는 메서드*/
        private void printTrialNumberInputMessage() {
                System.out.println("시도할 회수는 몇회인가요?");
        }

        /*시도 횟수 입력하는 메서드*/
        private boolean inputTrialNumber() {
                Scanner scan = new Scanner(System.in);
                try {
                        this.trialNumber = scan.nextInt();
                        if (trialNumber < 1)
                                throw new InputTrialNumberNotNaturalNumber();
                } catch (InputMismatchException e) {
                        System.err.println("입력 형식 오류");
                        return false;
                } catch (InputTrialNumberNotNaturalNumber e) {
                        System.err.println("0이하 입력 오류");
                        return false;
                }
                ;
                return true;
        }

        /*입력한 시도횟수가 음수인 예외*/
        private class InputTrialNumberNotNaturalNumber extends RuntimeException {
        }

        /*'실행 결과'메세지 출력하는 메서드*/
        private void printResultMessage() {
                System.out.println("\n실행 결과");
        }

        /*전진할지 정지할지를 결정하는 메서드*/
        private boolean isMove() {
                Random random = new Random();
                return random.nextInt(MAXRANDOMNUMBER) >= MINMOVENUMBER ? true : false;
        }

        /*최대로 이동한 위치를 구하는 메서드*/
        private int getMaxPosition() {
                int max = -1;
                for (Car car : cars) {
                        int position = car.getPosiotion();
                        if (position > max) {
                                max = position;
                        }
                }
                return max;
        }

        /*우승자 메세지를 출력하는 메서드*/
        private void printWinnerMessage() {
                int maxPosiotion = getMaxPosition();
                boolean isFirst = true;
                for (Car car : cars) {
                        if (car.getPosiotion() == maxPosiotion) {
                                printComma(isFirst);
                                car.printName();
                                isFirst = false;
                        }
                }
                System.out.println("가 최종 우승했습니다.");
        }

        /*우승자가 여러명일 경우 이름 사이에 ','를 출력하는 메서드*/
        private void printComma(boolean isFirst) {
                if (!isFirst) {
                        System.out.print(", ");
                }
        }
}
