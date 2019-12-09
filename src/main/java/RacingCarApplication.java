import domain.Cars;
import domain.RacingRounds;
import view.InputView;

public class RacingCarApplication {
    public static void main(String[] args) {
        Cars cars = getReadyCars();
        RacingRounds racingRounds = decideRacingRounds();

        while(racingRounds.isLeft()) {
            racingRounds.minus();
            cars.play();
        }
    }

    private static Cars getReadyCars() {
        try {
            return new Cars(InputView.inputCarNames());
        } catch (IllegalArgumentException e) {
            return getReadyCars();
        }
    }

    private static RacingRounds decideRacingRounds() {
        try {
            return new RacingRounds(InputView.inputRacingRounds());
        } catch (IllegalArgumentException e) {
            return decideRacingRounds();
        }
    }
}