/*
 *@(#)Game.java           1.1 2019/04/04
 *Copyright (c) 2019 Hyogeon Kim.
 *Racing Car Game, Java, Mungyeong, KOREA
 */

package domain;

/**
 * 자동차 경주 게임의 전반적인 흐름에 관련 된 클래스
 *
 * @author 김효건
 * @version 1.1 2019년 04월 04일
 */

public class Game {
        /*
         * 입력, 출력, 내부동작 관련 객체를 각각 가지고
         * 전체적인 게임 흐름을 통해 게임을 실행할 클래스
         *  */

        /*입력 관련 작업을 할 객체*/
        private InputUtility inputer;

        /*출력 관련 작업을 할 객체*/
        private PrintUtility printer;

        /*내부동작 관련 작업을 할 객체*/
        private InternalOperation operator;

        private final int trialNumber;
        private final Car[] cars;

        Game() {
                inputer = new InputUtility();
                printer = new PrintUtility();
                operator = new InternalOperation();

                settingInputValue();
                trialNumber = inputer.getTrialNumber();
                cars = inputer.getCars();
        }

        /*게임을 시작하는 메서드*/
        public void start() {
                playGame();
                printResult();
        }

        /*자동차 전진/정지하는 1싸이클 진행하는 메서드*/
        private void playOneCycle() {
                for (Car car : cars) {
                        excutingOneCar(car);
                }
                System.out.println();
        }

        /*초기 입력 화면 출력 및 값 입력 동작 수행하는 메서드*/
        private void settingInputValue() {
                settingCarNames();
                settingTrialNumber();
                printer.printResultMessage();
        }

        /*차의 이름을 세팅하는 메서드*/
        private void settingCarNames() {
                do {
                        printer.printCarNamesInputMessage();
                } while (!inputer.inputCarNames());
        }

        /*시도 횟수를 세팅하는 메서드*/
        private void settingTrialNumber() {
                do {
                        printer.printTrialNumberInputMessage();
                } while (!inputer.inputTrialNumber());
        }

        /*게임 진행하는 메서드*/
        private void playGame() {
                for (int i = 0; i < trialNumber; i++) {
                        playOneCycle();
                }
        }

        /*결과를 출력하는 메서드*/
        private void printResult() {
                int maxPosition = operator.getMaxPosition(cars);
                printer.printWinnerMessage(cars, maxPosition);
        }

        /*하나의 차에 대해 전진/정지 동작을 수행하는 메서드*/
        private void excutingOneCar(Car car) {
                printer.printCarName(car);
                if (operator.isMove()) {
                        car.moveCar();
                }
                car.printPosition();
        }
}
