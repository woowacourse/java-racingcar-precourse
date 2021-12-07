package racingcar;

import java.util.List;

public class Application {
    public static void main(String[] args) {

        User user = new User();

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
        System.out.println();
        System.out.println(Constant.RACE_PROCESS);

        Game game = new Game();

        List<Car> cars = game.makeCarObject(user.getCarName());

        for (int i = 0; i < user.getTimes(); i++) {
            game.runCarRacingOneRound(cars);
            System.out.println();
        }

        int frontPosition = game.getFrontPosition(cars);

        List<String> winner = game.getWinner(cars, frontPosition);

        System.out.print(Constant.FINAL_WINNER + String.join(Constant.FINAL_WINNER_JOIN_DELIMITER, winner));

    }
}
