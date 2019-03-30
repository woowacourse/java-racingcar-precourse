package domain;

import java.util.*;


public class Car {
    private final String name;
    private int position = 0;

    Car(final String name) {
        this.name = name;
    }

    /*
    0에서 9 사이의 임의의 수를 생성하여 4 이상인 경우 방향으로 전진, 아닌 경우 정지.
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
    private static int numbersToTry;
    private static int positionOfTheWinner = 0;

    public static void main(String args[]) {
        if (!inputNames() || !inputNumbers()) {
            System.out.println("잘못된 입력입니다.");
            System.exit(0);
        }
        playGame();
        getWinners();
    }

    private static boolean inputNames() {
        final List<String> names;

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        names = Arrays.asList(input.nextLine().split(","));
        if (checkLengthsOfNames(names)) {
            return addCars(names);
        }
        return false;
    }

    private static boolean checkLengthsOfNames(final List<String> names) {
        for (String name : names) {
            if (name.length() > 5) {
                return false;
            }
        }
        return true;
    }

    private static boolean addCars(final List<String> names) {
        if (names.size() <= 1) {
            return false;
        }
        names.forEach(name -> {
            cars.add(new Car(name));
        });
        return true;
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
                final int temp = car.tryToMoveAndReturnPosition();
                if (temp > positionOfTheWinner) {
                    positionOfTheWinner = temp;
                }
                System.out.println(car.getName() + " : " + printTrail(temp));
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
        String message = "";
        final String iGaDifferentiation;

        for (Car car : cars) {
            if (car.getPosition() == positionOfTheWinner) {
                message += car.getName() + ", ";
            }
        }
        message = message.substring(0, message.length() - 2);
        iGaDifferentiation = ((message.charAt(message.length() - 1) - (0xAC00)) % 28) == 0
                ? "가"
                : "이";
        System.out.println( message + iGaDifferentiation + " 최종 우승했습니다.");
    }
}