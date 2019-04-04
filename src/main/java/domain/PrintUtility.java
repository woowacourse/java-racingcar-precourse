/*
 *@(#)PrintUtility.java           1.1 2019/04/04
 *Copyright (c) 2019 Hyogeon Kim.
 *Racing Car Game, Java, Mungyeong, KOREA
 */

package domain;

/**
 * 자동차 경주 게임의 전반적인 출력에 관련 된 클래스
 *
 * @author 김효건
 * @version 1.1 2019년 04월 04일
 */

public class PrintUtility {
        /*
         * 게임 진행 시 입력 지시 메세지를 출력,
         * 게임 종료 시 우승자 메세지를 출력,
         * 우승자 출력시 우승자가 다수 일 경우 이름 사이에 ','를 추가하는
         * 역할을 하는 클래스
         *  */

        /*첫번째 우승자인지 구분하기 위한 변수*/
        private boolean isFirstWinner;

        PrintUtility() {
                isFirstWinner = true;
        }

        /*자동차 이름 입력 지시하는 메세지 출력 메서드*/
        public void printCarNamesInputMessage() {
                System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
        }

        /*시도 횟수 입력을 지시하는 메서드*/
        public void printTrialNumberInputMessage() {
                System.out.println("시도할 회수는 몇회인가요?");
        }

        /*'실행 결과'메세지 출력하는 메서드*/
        public void printResultMessage() {
                System.out.println("\n실행 결과");
        }

        /*우승자 메세지를 출력하는 메서드*/
        public void printWinnerMessage(Car[] cars, int maxPosition) {
                for (Car car : cars) {
                        printOneWinnerCarName(car, maxPosition);
                }
                System.out.println("가 최종 우승했습니다.");
        }

        /*하나의 차 이름 + ':"를 출력하는 메서드*/
        public void printCarName(Car car) {
                car.printName();
                System.out.print(" : ");
        }

        /*하나의 우승자 차 이름을 출력하는 메서드*/
        private void printOneWinnerCarName(Car car, int maxPosition) {
                if (car.getPosiotion() == maxPosition) {
                        printComma(isFirstWinner);
                        car.printName();
                        isFirstWinner = false;
                }
        }

        /*우승자가 여러명일 경우 이름 사이에 ','를 출력하는 메서드*/
        private void printComma(Boolean isFirstWinner) {
                if (!isFirstWinner) {
                        System.out.print(", ");
                }
        }
}
