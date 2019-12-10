package domain;

import java.util.List;

public class RacingCars {
    private final List<Car> carList;

    public RacingCars(List<Car> carList) {
        validateRacingCarName(carList);
        this.carList = carList;
    }

    public List<Car> getCarList() {
        return carList;
    }

    private void validateRacingCarName(List<Car> carList) {
        for (Car c : carList) {
            if (c.getName().startsWith(" ")) {
                throw new IllegalStateException("이름은 공백으로 시작할 수 없습니다.");
            }
        }
    }
}
