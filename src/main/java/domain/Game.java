package domain;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;

public class Game {
        private static final int MAXCARNAMENUMBER = 5;
        private static final int MAXRANDOMNUMBER = 10;
        private static final int MINMOVENUMBER = 4;

        private Car[] cars;
        private int trialNumber;

        Game() {
        }

        public void start() {
                do {
                        printCarNamesInputMessage();
                }while(!inputCarNames());
                do{
                        printTrialNumberInputMessage();
                }while(!inputTrialNumber());
                printResultMessage();
                for (int i = 0; i < trialNumber; i++) {
                        playOneCycle();
                }
                printWinnerMessage();
        }

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

        private void printCarNamesInputMessage() {
                System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
        }

        private boolean inputCarNames() {
                Scanner scan = new Scanner(System.in);
                String inputCarNames = scan.nextLine();

                String[] splitedCarNames = inputCarNames.split(",");
                for(int i =0;i<splitedCarNames.length;i++){
                        if(!checkInputCarNames(splitedCarNames[i]))
                                return false;
                }
                cars = new Car[splitedCarNames.length];
                for (int i = 0; i < splitedCarNames.length; i++) {
                        cars[i] = new Car(splitedCarNames[i]);
                }
                return true;
        }

        private boolean checkInputCarNames(String inputCarNames) {
                if(inputCarNames.length()>MAXCARNAMENUMBER){
                        System.err.println("차 이름 길이 초과 오류");
                        return false;
                }

                for(int i=0;i<inputCarNames.length();i++){
                        if(!(inputCarNames.charAt(i) >= 'a' && inputCarNames.charAt(i)<='z')
                                && !(inputCarNames.charAt(i) >= 'A' && inputCarNames.charAt(i)<='Z')){
                                System.err.println("차 이름 입력 형식 오류 (알파벳만 입력)");
                                return false;
                        }
                }
                return true;
        }

        private void printTrialNumberInputMessage() {
                System.out.println("시도할 회수는 몇회인가요?");
        }

        private boolean inputTrialNumber() {
                Scanner scan = new Scanner(System.in);
                try {
                        this.trialNumber = scan.nextInt();
                        if(trialNumber < 1)
                                throw new InputTrialNumberNotNaturalNumber();
                }catch(InputMismatchException e){
                        System.err.println("입력 형식 오류");
                        return false;
                }catch(InputTrialNumberNotNaturalNumber e){
                        System.err.println("0이하 입력 오류");
                        return false;
                };
                return true;
        }

        private class InputTrialNumberNotNaturalNumber extends RuntimeException{
        }

        private void printResultMessage() {
                System.out.println("\n실행 결과");
        }

        private boolean isMove() {
                Random random = new Random();
                return random.nextInt(MAXRANDOMNUMBER) >= MINMOVENUMBER ? true : false;
        }

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

        private void printComma(boolean isFirst) {
                if (!isFirst) {
                        System.out.print(", ");
                }
        }
}
