package racingcar.race;

import racingcar.Constant;
import racingcar.Validation;
import racingcar.car.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class RaceService {
    public String[] getAllCarName(Scanner scanner) {
        String input = scanner.nextLine();
        String[] allCarName = Stream.of(input.split(Constant.DELIMITER)).map(String::trim).toArray(String[]::new);
        checkRightCarName(allCarName);

        return allCarName;
    }

    public List<Car> carRegistration(String[] cars) {
        List<Car> allRacingCars = new ArrayList<>();

        for (String carName : cars) {
            Car car = new Car(carName);
            allRacingCars.add(car);
        }

        return allRacingCars;
    }

    public int getRaceRound(Scanner scanner) {
        String number = scanner.nextLine();
        checkRightNumber(number);

        return Integer.parseInt(number);
    }

    public int driveCar(List<Car> allRacingCars, int position) {
        int leadPosition = position;
        for (Car car : allRacingCars) {
            int value = car.getRandomValue();
            car.forward(value);

            leadPosition = getLeadPosition(leadPosition, car.getPosition());
        }

        return leadPosition;
    }

    public void showCurrentSituation(List<Car> allRacingCars) {
        for (Car car : allRacingCars) {
            System.out.print(car.getName() + Constant.COLON);
            showEachCarSituation(car.getPosition());
        }
        System.out.println();
    }

    private void showEachCarSituation(int position) {
        for (int j = 0; j < position; j++) {
            System.out.print(Constant.FORWARD_SIGN);
        }
        System.out.println();
    }

    public List<String> findWinner(List<Car> allRacingCars, int leadPosition) {
        List<String> winners = new ArrayList<>();

        for (Car car : allRacingCars) {
            if (car.getPosition() == leadPosition) {
                winners.add(car.getName());
            }
        }

        return winners;
    }

    public void printWinner(List<String> winners) {
        System.out.print(Constant.FINAL_WINNER);

        for (int i = 0; i < winners.size(); i++) {
            System.out.print(winners.get(i));

            if (i != winners.size() - 1) {
                System.out.print(Constant.COMMA);
            }
        }
    }

    private int getLeadPosition(int leadPosition, int position) {
        return Math.max(leadPosition, position);
    }

    private void checkRightCarName(String[] cars) {
        Validation.carNameValidation(cars);
    }

    private void checkRightNumber(String number) {
        Validation.raceNumberValidation(number);
    }
}
