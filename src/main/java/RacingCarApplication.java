import domain.Cars;
import domain.RacingRounds;
import view.InputView;
import view.OutputView;

public class RacingCarApplication {
    public static void main(String[] args) {
        Cars cars = getReadyCars();
        RacingRounds racingRounds = decideRacingRounds();

        System.out.println("실행 결과");
        while (racingRounds.isLeft()) {
            racingRounds.minus();
            cars.play();
            OutputView.printCarPositions(cars);
        }
        OutputView.printWinners(cars);
    }

    private static Cars getReadyCars() {
        try {
            return new Cars(InputView.inputCarNames());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getReadyCars();
        }
    }

    private static RacingRounds decideRacingRounds() {
        try {
            return new RacingRounds(InputView.inputRacingRounds());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return decideRacingRounds();
        }
    }
}