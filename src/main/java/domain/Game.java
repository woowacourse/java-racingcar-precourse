package domain;

import java.util.Scanner;
import java.util.Random;

public class Game {
        private static final int MAXCARNAMENUMBER = 5;
        private static final int MAXRANDOMNUMBER = 10;
        private static final int MINMOVENUMBER = 4;

        private Car[] cars;
        private int trialNumber;

        Game() {}

        public void start() {

        }

        private void playOneCycle() {
                for (Car car : cars) {
                        car.printName();
                        if (isMove()) {
                                car.moveCar();
                        }
                        car.printPosition();
                }
                System.out.println();
        }

        private void printCarNamesInputMessage() {
                System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
        }

        private void inputCarNames() {
                Scanner scan = new Scanner(System.in);
                String inputCarNames = scan.nextLine();

                String[] splitedCarNames = inputCarNames.split(",");

                cars = new Car[splitedCarNames.length];

                for (int i = 0; i < splitedCarNames.length; i++) {
                        cars[i] = new Car(splitedCarNames[i]);
                }
        }

        private void printTrialNumberInputMessage() {
                System.out.println("시도할 회수는 몇회인가요?");
        }

        private void inputTrialNumber() {
                Scanner scan = new Scanner(System.in);
                this.trialNumber = scan.nextInt();
        }

        private void printResultMessage() {
                System.out.println("\n실행 결과");
        }

        private boolean isMove() {
                Random random = new Random();
                return random.nextInt(MAXRANDOMNUMBER) >= MINMOVENUMBER ? true : false;
        }

}
