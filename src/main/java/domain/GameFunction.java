package domain;

public class GameFunction {
    public static int randomNumber;
    public static void startRacingGame(Car[] cars, int raceCount) {
        for (int i = 0; i < raceCount; i++) {
            moveCars(cars);
            printRacingResult(cars);
        }
    }

    public static void moveCars(Car[] cars) {
        for (Car car : cars) {
            if (checkRandomNumber()) {
                car.moveCarPosition();
            }
        }
    }

    public static boolean checkRandomNumber() {
        randomNumber = (int) ((Math.random() * 9) + 1);
        return randomNumber >= 4;
    }

    public static void printRacingResult(Car[] cars) {
        System.out.println("실행 결과");
        for (Car car : cars) {
            System.out.printf("%s : %s \n",car.getCarName(),car.printCarPosition());
        }
    }

}
