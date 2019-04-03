/*
 * @(#)Car.java
 * 2019년 4월 3일
 * version: 1.0.0
 * by KIM JUNG MIN
 * testprogramms9104@gmail.com
 */
package domain;

import java.util.*;

/**
 * Car.java는 자동차의 attibutes와 class/instance의 method를 정의하는 class입니다.
 *
 * @version 1.0.0
 * @author KIM JUNG MIN
 */

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    //추가 기능 구현
    private static final int NAME_MIN_LENGTH = 1;
    private static final int NAME_MAX_LENGTH = 5;
    private static final boolean IS_SOMETHING_WRONG = false;
    //보통 위 3개와 같은 java constant를 class맨위에 두지만
    //저는 제공해주신 Car.java를 최대한 건들지 않기 위해 밑에 정의합니다.

    public static String[] askCarNames() {
        String userInput;
        String[] userInputArray;
        while (true) {
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분합니다)");
            Scanner reader = new Scanner(System.in);
            userInput = reader.nextLine();
            userInputArray = userInput.split(",");
            if ((isNameLengthBetweenOneAndFive(userInputArray) == IS_SOMETHING_WRONG) && (isDuplicate(userInputArray) == IS_SOMETHING_WRONG)) {
                break;
            }
        }
        return userInputArray;
    }

    private static boolean isDuplicate(String[] userInputArray) {
        for (int i = 0; i < userInputArray.length; i++) {
            if (count(userInputArray, userInputArray[i]) > 1) {
                System.out.println("중복되는 이름의 선수들이 있습니다! 모두 다른 이름으로 해주세요!");
                return true;
            }
        }
        return false;
    }

    private static int count(String[] userInputArray, String userInput) {
        int count = 0;
        for (int i = 0; i < userInputArray.length; i++) {
            if (userInput.equals(userInputArray[i])) {
                count++;
            }
        }
        return count;
    }

    private static boolean isNameLengthBetweenOneAndFive(String[] userInputArray) {
        if (userInputArray.length == 0) {
            System.out.println("선수들의 이름의 길이는 1이상 5이하로 해주십시오");
            return true;
        }
        for (int i = 0; i < userInputArray.length; i++) {
            if ((userInputArray[i].length() < NAME_MIN_LENGTH) || (userInputArray[i].length() > NAME_MAX_LENGTH)) {
                System.out.println("선수들의 이름의 길이는 1이상 5이하로 해주십시오");
                return true;
            }
        }
        return false;
    }

    public static int askHowManyTurns() {
        String turns;
        while (true) {
            System.out.println("시도할 회수는 몇회인가요?");
            Scanner reader = new Scanner(System.in);
            turns = reader.nextLine();
            boolean isUserInputRight = checkUserInput(turns); //check for zero also.
            if (isUserInputRight) {
                break;
            }
        }
        return Integer.parseInt(turns);
    }

    private static boolean checkUserInput(String turns) {
        if (isNonNumberThere(turns)) {
            return false;
        }
        if (isItSmallerThanOne(turns)) {
            return false;
        }
        return true;
    }

    private static boolean isItSmallerThanOne(String turns) {
        int intTurns = Integer.parseInt(turns);
        if (intTurns < 1) {
            System.out.println("0보다 큰 숫자를 입력해 주세요!");
            return true;
        }
        return false;
    }

    private static boolean isNonNumberThere(String turns) {
        for (int i = 0, n = turns.length(); i < n; i++) {
            if (!(Character.isDigit(turns.charAt(i)))) {
                System.out.println("정수인 숫자만 입력해주세요!");
                return true;
            }
        }
        return false;
    }

    public static Car[] instantiateAndReturnCars(String[] carNames) {
        Car[] cars = new Car[carNames.length];
        for (int i = 0; i < carNames.length; i++) {
            cars[i] = new Car(carNames[i]);
        }
        return cars;
    }

    public static void updateCarMovements(Car[] cars) {
        for (int i = 0; i < cars.length; i++) {
            int distance = generateDistance();
            cars[i].position += distance;
        }
    }

    private static int generateDistance() {
        int distance = 0;
        int randomNumber = (int) (Math.random() * 10);
        if (randomNumber >= 4) {
            distance = 1;
        }
        return distance;
    }

    public static void printCarMovements(Car[] cars) {
        for (int i = 0; i < cars.length; i++) {
            System.out.print("" + cars[i].name + ":");
            for (int j = 0; j < cars[i].position; j++) {
                System.out.print("-");
            }
            System.out.println();
        }
    }

    public static void announceWinners(Car[] cars) {
        int maxPosition = decideMaxPosition(cars);
        ArrayList<Car> winners = decideWinners(cars, maxPosition);
        printWinners(winners);
    }

    private static int decideMaxPosition(Car[] cars) {
        int maxPosition = 0;
        for (int i = 0; i < cars.length; i++) {
            if (cars[i].position > maxPosition) {
                maxPosition = cars[i].position;
            }
        }
        return maxPosition;
    }

    private static ArrayList<Car> decideWinners(Car[] cars, int maxPosition) {
        ArrayList<Car> winners = new ArrayList<Car>();
        for (int i = 0; i < cars.length; i++) {
            if (cars[i].position >= maxPosition) {
                winners.add(cars[i]);
            }
        }
        return winners;
    }

    private static void printWinners(ArrayList<Car> winners) {
        int n = winners.size();
        for (int i = 0; i < n - 1; i++) {
            System.out.print("" + winners.get(i).name + ", ");
        }
        System.out.print("" + winners.get(n - 1).name + "가 최종 우승했습니다!");
    }

    public static boolean getUserAnswer() {
        do {
            System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요: ");
            Scanner scanner = new Scanner(System.in);
            String strUserAnswer = scanner.nextLine();
            if ((strUserAnswer.length() == 1) && (strUserAnswer.charAt(0) == '1')) {
                return true;
            }
            if ((strUserAnswer.length() == 1) && (strUserAnswer.charAt(0) == '2')) {
                return false;
            }
        } while (true);
    }
}
