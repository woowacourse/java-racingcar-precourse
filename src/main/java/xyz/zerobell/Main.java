package xyz.zerobell;

import java.util.ArrayList;
import java.util.Scanner;


/*
 * Main class
 *
 * ver 2.0
 *
 * 2019-04-04
 *
 * MIT License
 *
 * author : zerobell-lee
 *
 */

public class Main {

    static private Scanner staticSc;

    static private Scanner getScanner() {
        if (staticSc==null) {
            staticSc = new Scanner(System.in);
        }

        return staticSc;
    }

    static private String[] separateStrings(String str) {
        return str.split(",");
    }

    static private boolean isStringsValid(String[] strings) {
        for (String s : strings) {
            if (!Car.isNameValid((s))) {
                return false;
            }
        }
        return true;
    }

    static private String[] getStrings() {
        Scanner sc = getScanner();

        while (true) {
            System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");
            String[] strings = separateStrings(sc.next());

            if (isStringsValid(strings)) {
                return strings;
            }
            System.out.println("자동차의 이름은 5자 이하어야 합니다!!");
        }
    }

    static private Car[] makeCars(String[] strings) {
        Car[] cars = new Car[strings.length];
        for (int i = 0; i < strings.length; i++) {
            cars[i] = new Car(strings[i]);
        }

        return cars;
    }

    static private void race(Car[] cars) {
        for (Car car: cars) {
            car.boostOrStop();
            System.out.println(car.toString());
        }
    }

    static private void repeatRace(Car[] cars, int trial) {
        for (int i = 0; i < trial; i++) {
            race(cars);
            System.out.println();
        }
    }

    static private ArrayList<String> findWinner(Car[] cars) {
        ArrayList<String> winnerList = new ArrayList<>();
        int maximum = 0;

        for (Car car : cars) {
            if (car.getPosition() == maximum) {
                winnerList.add(car.getName());
            }
            if (car.getPosition() > maximum) {
                winnerList.clear();
                winnerList.add(car.getName());
                maximum = car.getPosition();
            }
        }

        return winnerList;
    }

    static private String getWinnerText(ArrayList<String> winners) {
        String text = "";
        for (int i = 0; i < winners.size(); i++) {
            text += winners.get(i);
            if (i != winners.size() - 1) {
                text += ", ";
            }
        }

        return text + "가 최종 우승했습니다.";
    }

    public static void main(String[] args) {
        Scanner sc;
        Car[] cars;

        int trial;

        sc = getScanner();
        cars = makeCars(getStrings());

        System.out.println("시도할 회수는 몇회인가요?");
        trial = sc.nextInt();

        System.out.println("실행 결과");
        repeatRace(cars, trial);

        System.out.println(getWinnerText(findWinner(cars)));
    }

}
