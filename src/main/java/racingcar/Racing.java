package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;

public class Racing {

    private Car car [];
    private int times;
    private String winners;

    public Racing() {
        car = Car.getCarName();
        getTimes();
        for (int i = 0; i < times; i++) {
            doGame();
        }
        findWinners();
    }

    public void getTimes() {
        System.out.println("시도할 회수는 몇회인가요?");
        times = Integer.parseInt(Console.readLine());
    }

    public void doGame() {
        for (Car car : car) {
            if (Utils.exceedMoveForwardScoreOrNot(Utils.getRandomNumber())) {
                car.move();
            }
            car.printCarName();
            car.printPosition();
        }
        System.out.println();
    }

    public void findWinners() {
        Optional<Car> cars = Arrays.stream(car).max(Comparator.comparing(Car::getPosition));
        int max = cars.get().getPosition();
        System.out.print("최종 우승자 : ");
        for (Car car : car) {
            if (car.getPosition() == max) {
                winners += (car.getName() + ",");
            }
        }
    }
}
