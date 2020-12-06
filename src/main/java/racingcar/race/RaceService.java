package racingcar.race;

import racingcar.Constant;
import racingcar.car.Car;
import racingcar.car.CarNameValidation;
import racingcar.car.ParticipatingCars;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class RaceService {
    public String[] getAllCarName(Scanner scanner) {
        String input = scanner.nextLine();
        String[] allCarName = Stream.of(input.split(Constant.DELIMITER))
                                    .map(s -> s.replaceAll(Constant.BLANK, Constant.EMPTY_NAME))
                                    .toArray(String[]::new);

        CarNameValidation.validation(allCarName);

        return allCarName;
    }

    public void carRegistration(ParticipatingCars cars, String[] allCarName) {
        for (String carName : allCarName) {
            Car car = new Car(carName);
            cars.addCar(car);
        }
    }

    public int getRaceRound(Scanner scanner) {
        String number = scanner.nextLine();
        RaceRoundValidation.validation(number);

        return Integer.parseInt(number);
    }

    public int driveCar(ParticipatingCars allRacingCars, int position) {
        int leadPosition = position;
        for (Car car : allRacingCars.getCars()) {
            int value = car.getRandomValue();
            car.forward(value);

            leadPosition = getLeadPosition(leadPosition, car.getPosition());
        }

        return leadPosition;
    }

    public void showCurrentSituation(ParticipatingCars allRacingCars) {
        for (Car car : allRacingCars.getCars()) {
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

    public List<String> findWinner(ParticipatingCars allRacingCars, int leadPosition) {
        List<String> winners = new ArrayList<>();

        for (Car car : allRacingCars.getCars()) {
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
}
