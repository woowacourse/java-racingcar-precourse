import domain.Cars;
import utils.InputUtils;

import java.util.ArrayList;
import java.util.List;

public class RacingCarGame {
    private Cars cars;

    public void run() {
        cars = Cars.makeCars(InputUtils.inputCarNames());
    }
}