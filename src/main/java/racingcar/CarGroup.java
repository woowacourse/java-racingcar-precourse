package racingcar;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CarGroup {

    private static final String ERROR_MESSAGE_START = "[ERROR] ";
    private static final String ERROR_MESSGAE_END_NAME_DUPLICATE = "자동차 이름은 중복되지 않아야 한다.";

    private List<Car> carGroup;

    public CarGroup(List<Car> carList) {
        validateDuplicate(carList);
        this.carGroup = carList;
    }

    public List<Car> getCarGroup() {
        return carGroup;
    }

    private void validateDuplicate(List<Car> carList) {
        Set<String> carNameSet = new HashSet<>();
        for (Car car : carList) {
            carNameSet.add(car.getName());
        }
        if (carList.size() != carNameSet.size()) {
            throw new IllegalArgumentException(ERROR_MESSAGE_START + ERROR_MESSGAE_END_NAME_DUPLICATE);
        }
    }

    public void raceOneRound() {
        for (Car car : carGroup) {
            car.moveForwardOrStop();
        }
    }

    public String getFinalWinner(int MaximumPosition) {
        List<String> finalWinnerList = new ArrayList<>();
        for (Car car : carGroup) {
            if (car.getPosition() == MaximumPosition) {
                finalWinnerList.add(car.getName());
            }
        }
        return String.join(", ", finalWinnerList);
    }
}
