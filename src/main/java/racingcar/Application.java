package racingcar;

import java.util.List;

public class Application {
    public static void main(String[] args) {

        User user = new User();

        System.out.println("경주할 자동차 이름은 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        user.enterCarName();
        user.toNameArray();

        System.out.println("시도할 회수는 몇회인가요?");

        user.enterTimes();

        Game game = new Game();

        List<Car> cars = game.makeCarObject(user.getCarName());

        for (int i = 0; i < user.getTimes(); i++) {
            game.runCarRacingOneRound(cars);
            System.out.println();
        }
        
    }
}
