package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Racing {

    private Car car [];
    private int times;

    public Racing() {
        car = Car.getCarName();
        getTimes();
        for (int i = 0; i < times; i++) {
            doGame();
        }
    }

    public void getTimes() {
        System.out.println("시도할 회수는 몇회인가요?");
        times = Integer.parseInt(Console.readLine());
    }

    public void doGame() {
        for (Car car : car) {
            if (Utils.exceedMoveForwardScoreOrNot(Utils.getRandomNumber())) {
                car.move();
                car.printCarName();
                car.printPosition();
            }
        }
    }
}
