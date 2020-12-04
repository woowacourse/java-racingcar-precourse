package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class Race {
    private List<Car> allRacingCars = new ArrayList<>();
    private int raceNumber;
    private int leadPosition = 0;

    public Race(Scanner scanner) {
        generateCars(scanner);
        decideRaceNumber(scanner);
        raceStart();
    }

    private void generateCars(Scanner scanner) {
        while (true) {
            System.out.println(Constant.PARTICIPATING_CAR_NAME_INPUT_MESSAGE);

            try {
                String input = scanner.nextLine();
                String[] cars = Stream.of(input.split(Constant.DELIMITER)).map(String::trim).toArray(String[]::new);

                checkRightCarName(cars);
                carRegistration(cars);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void decideRaceNumber(Scanner scanner) {
        while (true) {
            System.out.println(Constant.RACE_NUMBER_INPUT_MESSAGE);

            try {
                String number = scanner.nextLine();

                checkRightNumber(number);
                this.raceNumber = Integer.parseInt(number);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void raceStart() {
        System.out.println(Constant.RACE_PROCESS);

        for (int i = 0; i < raceNumber; i++) {
            driveCar();
            printResult();
        }
    }

    private void driveCar() {
        for (Car car : allRacingCars) {
            int value = car.getRandomValue();
            car.forward(value);

            updateLeadPosition(car.getPosition());
        }
    }

    private void updateLeadPosition(int position) {
        if (leadPosition < position) {
            this.leadPosition = position;
        }
    }

    private void printResult() {
        for (Car car : allRacingCars) {
            System.out.print(car.getName() + " : ");

            for (int j = 0; j < car.getPosition(); j++) {
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }

    private void findWinner() {
        List<String> winners = new ArrayList<>();

        for (Car car : allRacingCars) {
            if (car.getPosition() == leadPosition) {
                winners.add(car.getName());
            }
        }
    }

    private void checkRightCarName(String[] cars) {
        if (!Validation.carNameValidation(cars)) {
            throw new IllegalArgumentException(Constant.ERROR_CAR_NAME);
        }
    }

    private void carRegistration(String[] cars) {
        for (String carName : cars) {
            Car car = new Car(carName);
            allRacingCars.add(car);
        }
    }

    private void checkRightNumber(String number) {
        if (!Validation.raceNumberValidation(number)) {
            throw new IllegalArgumentException(Constant.ERROR_RACE_NUMBER);
        }
    }
}
