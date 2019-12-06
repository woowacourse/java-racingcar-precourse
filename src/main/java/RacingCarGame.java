import domain.Cars;
import domain.RacingRounds;
import utils.InputUtils;

public class RacingCarGame {
    private Cars cars;
    private RacingRounds racingRounds;

    public RacingCarGame() {
        this.cars = getReadyCars();
        this.racingRounds = decideRacingRounds();
    }

    public void run() {
        while(racingRounds.isLeft()) {
            racingRounds.minus();
            cars.play();
        }
    }

    private Cars getReadyCars() {
        try {
            return new Cars(InputUtils.inputCarNames());
        } catch (IllegalArgumentException e) {
            return getReadyCars();
        }
    }

    private RacingRounds decideRacingRounds() {
        try {
            return new RacingRounds(InputUtils.inputRacingRounds());
        } catch (IllegalArgumentException e) {
            return decideRacingRounds();
        }
    }
}