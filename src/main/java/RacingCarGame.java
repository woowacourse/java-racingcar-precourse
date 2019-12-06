import domain.Cars;
import utils.InputUtils;

public class RacingCarGame {
    private Cars cars;
    private int racingRounds;

    public void run() {
        cars = Cars.makeCars(InputUtils.inputCarNames());
        racingRounds = InputUtils.inputRacingRounds();
    }
}