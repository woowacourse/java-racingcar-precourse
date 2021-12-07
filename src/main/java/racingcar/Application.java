package racingcar;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        User user = new User();

        Race.generateCarName(user);
        Race.generateTryTimes(user);
        Race.printRaceProcess(user);
        Race.printFinalWinner(user);
    }
}