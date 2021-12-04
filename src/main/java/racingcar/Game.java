package racingcar;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class Game {

    public static final String WINNER_PREFIX = "최종 우승자 : ";

    GameExecutor gameExecutor = new GameExecutor();

    public void play() {
        try {
            List<Car> carList = gameExecutor.createCars();
            int count = gameExecutor.getCount();

            doMatch(count, carList);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public void doMatch(int count, List<Car> carList) {
        for (int i = 0 ; i < count ; i++) {
            for (Car car : carList) {
                car.go();
            }

            printCurrentState(carList);
        }
        printWinners(carList);
    }

    public void printCurrentState(List<Car> carList) {
        String result = "";
        for (Car car : carList) {
            result += car.getName() + " : " + convertInt2Hyphen(car.getPosition()) + "\n";
        }
        System.out.println(result);
    }

    private String convertInt2Hyphen(int goCount) {
        String result = "";

        for (int i = 0 ; i < goCount ; i++) {
            result += "-";
        }

        return result;
    }

    public List<Car> getWinners(List<Car> carList) {
        int maximum = carList.stream()
                                .max(Comparator.comparing(Car::getPosition))
                                .orElseThrow(NoSuchElementException::new)
                                .getPosition();

        List<Car> winnerList = carList.stream()
                                        .filter(car -> car.getPosition() == maximum)
                                        .collect(Collectors.toList());

        return winnerList;
    }

    public void printWinners(List<Car> carList) {
        List<Car> winnerList = getWinners(carList);

        List<String> winnerNameList = winnerList.stream()
                                        .map(Car::getName)
                                        .collect(Collectors.toList());
        System.out.println(WINNER_PREFIX + String.join(", ",  winnerNameList));
    }
}
