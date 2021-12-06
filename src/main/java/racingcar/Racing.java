package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;

public class Racing {

    private Car car [];
    private int times;
    private String winners = "";

    public Racing() {
        car = Car.getCarName();
        getTimes();
        for (int i = 0; i < times; i++) {
            doGame();
        }
        findWinners();
        printWinners();
    }

    public void getTimes() {
        boolean isTimesNumber = true;
        while (isTimesNumber) {
            System.out.println("시도할 회수는 몇회인가요?");
            String str = Console.readLine();
            isTimesNumber = validateTime(str);
            if(!isTimesNumber){
                times = Integer.parseInt(str);
            }
        }
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
                winners += (car.getName() + ", ");
            }
        }
    }

    public void printWinners() {
        System.out.println(Utils.removeComma(winners));
    }

    private boolean validateTime (String str) {
        try {
            Integer.parseInt(str);
        }catch (Exception e) {
            System.out.println("[ERROR] 시도 횟수는 숫자여야 한다.");
            return true;
        }
        return false;
    }
}
