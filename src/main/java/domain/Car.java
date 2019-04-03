package domain;

import java.util.Scanner;
import java.util.Vector;
import java.util.List;
import java.util.Arrays;
import java.util.HashSet;
import java.util.InputMismatchException;


public class Car {
    private final String name;
    private int position = 0;

    Car(final String name) {
        this.name = name;
    }

    /*
    0에서 9 사이의 임의의 수를 생성하여 4 이상인 경우 전진, 아닌 경우 정지.
    이후 현재 위치를 반환한다.
    0에서 시작하여 + 방향으로 이동한다.
     */
    public int tryToMoveAndReturnPosition() {
        return ((int) (Math.random() * 10.0) >= 4) ? ++position : position;
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }

}

class GameManager {
    private static final Scanner input = new Scanner(System.in);
    private static final List<Car> cars = new Vector<>();
    private static int numbersToTry = 0;
    private static int positionOfTheWinner = 0;

    public static void main(String args[]) {
        while (!inputNames() || !inputNumbers()) {
            System.out.println("잘못된 입력입니다.");
            cars.clear();
        }
        playGame();
        getWinners();
        printWinners();
    }

    private static boolean inputNames() {
        final List<String> names;

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        names = Arrays.asList(input.next().split(","));
        if (checkNames(names)) {
            addCars(names);
            return true;
        }
        return false;
    }

    private static boolean checkNames(final List<String> names) {
        final int TRUE_SIZE = (new HashSet<>(names)).size();

        if (names.size() > TRUE_SIZE || TRUE_SIZE <= 1) {
            return false;
        }
        for (String name : names) {
            if (name.length() == 0 || name.length() > 5) {
                return false;
            }
        }
        return true;
    }

    private static void addCars(final List<String> names) {
        names.forEach(name -> {
            cars.add(new Car(name));
        });
    }

    private static boolean inputNumbers() {
        try {
            System.out.println("시도할 회수는 몇회인가요?");
            numbersToTry = input.nextInt();
            if (numbersToTry > 0) {
                return true;
            }
        } catch (InputMismatchException e) {
            input.next();
        }
        return false;
    }

    private static void playGame() {
        System.out.println("\n실행 결과");
        for (int i = 0; i < numbersToTry; i++) {
            cars.forEach(car -> {
                System.out.println(
                    car.getName()
                            + " : "
                            + printTrail(car.tryToMoveAndReturnPosition())
                );
            });
            System.out.println();
        }
    }

    private static String printTrail(final int number) {
        String trail = "";

        for (int i = 0; i < number; i++) {
            trail += "-";
        }
        return trail;
    }

    private static void getWinners() {
        for (Car car : cars) {
            if (car.getPosition() > positionOfTheWinner) {
                positionOfTheWinner = car.getPosition();
            }
        }
    }

    private static void printWinners() {
        String message = "";
        final String iGa;

        for (Car car : cars) {
            if (car.getPosition() == positionOfTheWinner) {
                message += car.getName() + ", ";
            }
        }
        message = message.substring(0, message.length() - 2);
        iGa = differentiateIGa(message.charAt(message.length() - 1));
        System.out.println( message + iGa + " 최종 우승했습니다.");
    }

    /*
    유니코드 표 상에서 앞 글자의 받침 여부를 판단해 이/가 중 적절한 조사를 고른다.
    알파벳이나 숫자의 경우 한글 발음으로 단순 치환.
    */
    private static String differentiateIGa(final char letter) {
        final char[] CONVERSION_TABLE = ("영일이삼사오육칠팔구:;<=>?@"
                + "이비씨디이프쥐치이이이엘엠엔오피큐알쓰티유이유스이지"
                + "[원]^_`이비씨디이프쥐치이이이엘엠엔오피큐알쓰티유이유스이지"
        ).toCharArray();
        if (48 <= letter && letter <= 122) {
            return ((CONVERSION_TABLE[letter - 48] - 0xAC00) % 28 == 0) ? "가" : "이";
        }

        return ((letter - 0xAC00) % 28 == 0) ? "가" : "이";
    }
}
