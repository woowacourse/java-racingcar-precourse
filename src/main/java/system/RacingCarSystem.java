package system;

import domain.Car;
import io.InputRacingCar;
import io.OutputRacingCar;

import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class RacingCarSystem {
    private List<Car> cars = new LinkedList<>();

    public void run() {
        String carsName = InputRacingCar.inputCarsName();
        validateCarsName(carsName);
        setCarList(carsName);

        RacingSystem racingSystem = new RacingSystem(cars);
        racingSystem.startRacing();

        RankingSystem rankingSystem = new RankingSystem(cars);
        List<String> winnerList = rankingSystem.getWinner();
        OutputRacingCar.printWinner(winnerList);
    }

    public void setCarList(String carsName) {
        StringTokenizer st = splitCarName(carsName);

        while (st.hasMoreTokens()) {
            String carName = st.nextToken();

            validateCarName(carName);
            createCar(carName);
        }
    }

    public StringTokenizer splitCarName(String carsName) {
        return new StringTokenizer(carsName, ",");
    }

    public void createCar(String carName) {
        cars.add(new Car(carName));
    }

    public void validateCarsName(String carsName) {
        if (carsName.equals("")) {
            throw new IllegalStateException("이름은 공백이 될 수 없습니다.");
        }
    }

    public void validateCarName(String carsName) {
        if (carsName.startsWith(" ")) {
            throw new IllegalStateException("이름은 공백으로 시작할 수 없습니다.");
        }
    }
}
