package domain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

        static Car[] cars;
        static int n;
        static int counter = 0;
        static int max = -1;
        static String[] winner;

        public static void main(String args[]) throws IOException {
                inputNames();
                inputGameNumber();
                playRace();
                compare();
                outputWinner();

        }

        public static void inputNames() throws IOException {
                System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
                BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
                String names = bf.readLine();
                String[] name = names.split(",");
                makeCars(name);
        }

        public static void makeCars(String[] name) {
                cars = new Car[name.length];
                for (int i = 0; i < name.length; i++) {
                        cars[i] = new Car(name[i]);
                }
        }

        public static void inputGameNumber() {
                System.out.println("시도할 회수는 몇회인가요?");
                Scanner scanner = new Scanner(System.in);
                n = scanner.nextInt();
                System.out.println();
        }

        public static void playRace() {
                System.out.println("실행 결과");
                for (int i = 0; i < n; i++) {
                        gameOnce();
                }
        }

        public static void gameOnce() {
                for (int i = 0; i < cars.length; i++) {
                        cars[i].movePosition();
                        outputPosition(cars[i]);
                }
                System.out.println();
        }

        public static void compare() {
                for (int i = 0; i < cars.length; i++) {
                        findMaximum(cars[i].getPosition());
                }
                winner = new String[counter];
                int j = 0;
                for (int i = 0; i < cars.length; i++) {
                        if (cars[i].getPosition() == max) {
                                winner[j] = cars[i].getName();
                                j++;
                        }
                }
        }

        public static void findMaximum(int pos) {
                if (pos > max) {
                        max = pos;
                        counter = 1;
                        return;
                }
                if (pos == max) {
                        counter++;
                        return;
                }
        }

        public static String arrayJoin(String glue, String array[]) {
                StringBuffer result = new StringBuffer();

                for (int i = 0; i < array.length; i++) {
                        result.append(array[i]);
                        if (i < array.length - 1) result.append(glue);
                }

                return result.toString();
        }

        public static void outputWinner() {
                String winnerName = arrayJoin(",", winner);
                System.out.println(winnerName + "가 최종 우승 했습니다.");
        }

        public static void outputPosition(Car car) {
                System.out.print(car.getName() + ":");
                for (int i = 0; i < car.getPosition(); i++) {
                        System.out.print("-");
                }
                System.out.println();
        }
}
