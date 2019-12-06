import domain.Car;
import utils.InputUtils;

import java.util.ArrayList;
import java.util.List;

public class RacingCarGame {
    private List<Car> Cars = new ArrayList<>();

    public void run() {
        InputUtils.inputCarNames();
    }
}
