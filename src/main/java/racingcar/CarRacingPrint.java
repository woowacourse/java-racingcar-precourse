package racingcar;

public class CarRacingPrint {

    public static void printCarRacing(int positionCount) {
        String meter = "-";
        for (int i = 0; i < positionCount; i++) {
            System.out.printf(meter);
        }
    }
}
