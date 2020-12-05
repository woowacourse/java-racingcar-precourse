package racingcar;

import utils.RandomUtils;

public class GameProgression {
    private static String printFormat = " : ";

    public static void moveOrStop(Car car) {
        //랜덤 생성후 Position 판별
        int progressCheck = RandomUtils.nextInt(0, 9);
        if(progressCheck >= 4) {
            car.move();
        }
    }

    public static void printPosition(Car car) {
        //Car 객체의 position 출력
        String carName = car.getName();
        int carPosition = car.getPosition();
        String printCurrentPosition = "";
        printCurrentPosition += carName;
        printCurrentPosition += printFormat;
        for(int i=0; i<carPosition; i++) {
            printCurrentPosition += "-";
        }
        System.out.println(printCurrentPosition);
    }

    public static int checkFrontRunner(Car car, int frontRunnerPosition) {
        int carPosition = car.getPosition();
        if( carPosition > frontRunnerPosition ) {
            return carPosition;
        }
        return frontRunnerPosition;
    }
}
