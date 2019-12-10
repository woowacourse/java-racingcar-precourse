
import domain.RacingCars;
import domain.Winners;
import utils.InputUtil;
import utils.OutputUtil;

class RacingCarGame {

    private final RacingCars racingCars;
    private Integer count;

    private RacingCarGame(RacingCars racingCars, Integer count) {
        this.racingCars = racingCars;
        this.count = count;
    }

    static RacingCarGame inputSettings() {
        OutputUtil.printRacingCarsNameDemand();
        RacingCars racingCars = new RacingCars(InputUtil.inputRacingCars());
        OutputUtil.askAttempTime();
        Integer count = InputUtil.inputCount();
        return new RacingCarGame(racingCars, count);
    }

    void start() {
        while (count-- > 0) {
            racingCars.move();
            printCarsPosition();
        }
        printWinners();
    }

    private void printCarsPosition() {
        OutputUtil.printRacingSituation(racingCars);
    }

    private void printWinners() {
        Referee referee = new Referee();
        Winners winners = new Winners(referee.decideWinners(racingCars.getRacingCars()));
        OutputUtil.printWinners(winners);
    }
}
