package racingcar;

import java.util.List;

public class Race {
    public static Game game = new Game();

    public static void generateCarName(User user) {
        while (true) {
            try {
                System.out.println(Constant.INPUT_MESSAGE_CAR_NAME);
                user.enterCarName();
                user.toNameArray();
                CarNameException.validateCarName(user.getCarName());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void generateTryTimes(User user) {
        while (true) {
            try {
                System.out.println(Constant.INPUT_MESSAGE_TRY_TIMES);
                user.enterTimes();
                RoundTimesException.validateRoundTimes(user.getInputTimes());
                user.toIntegerTimes();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void printRaceProcess(User user) {
        System.out.println();
        System.out.println(Constant.RACE_PROCESS);
        List<Car> cars = game.makeCarObject(user.getCarName());

        for (int i = 0; i < user.getTimes(); i++) {
            game.runCarRacingOneRound(cars);
            System.out.println();
        }
    }

    
}
