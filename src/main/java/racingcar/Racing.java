package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;

public class Racing {

    private Car car[];
    private int times;
    private String winners = "";

    public Racing() {
        car = Car.getNamesFromUser();
        getTimesFromUser();
        for (int i = 0; i < times; i++) {
            doGame();
        }
        findWinners();
        printWinners();
    }

    public void getTimesFromUser() {
        boolean isTimesNumber = false;
        while (!isTimesNumber) {
            System.out.println("시도할 회수는 몇회인가요?");
            String times = Console.readLine();
            isTimesNumber = validateTime(times);
            if (isTimesNumber) {
                this.times = Integer.parseInt(times);
            }
        }
    }

    public void doGame() {
        for (Car car : car) {
            if (Utils.isExceedMoveScore(Utils.getRandomNumber())) {
                car.move();
            }
            car.printCarName();
            car.printPosition();
        }
        System.out.println();
    }

    public void findWinners() {
        Optional<Car> cars = Arrays.stream(car).max(Comparator.comparing(Car::getPosition));
        int maxPosition = cars.get().getPosition();
        System.out.print("최종 우승자 : ");
        for (Car car : car) {
            if (car.getPosition() == maxPosition) {
                winners += (car.getName() + ", ");
            }
        }
    }

    public void printWinners() {
        System.out.println(Utils.removeComma(winners));
    }

    private boolean validateTime(String str) {
        try {
            Integer.parseInt(str);
        } catch (Exception e) {
            System.out.println("[ERROR] 시도 횟수는 숫자여야 한다.");
            return false;
        }
        return true;
    }
}
