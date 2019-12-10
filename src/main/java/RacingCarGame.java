
import domain.RacingCars;
import domain.Winners;
import utils.InputUtil;
import utils.OutputUtil;

class RacingCarGame {
    private final RacingCars racingCars;
    private Integer count;

    private RacingCarGame(RacingCars racingCars, Integer count) {
        checkCarNameIsEmpty(racingCars);
        this.racingCars = racingCars;
        this.count = count;
    }

    static RacingCarGame inputSettings() {
        RacingCars racingCars = inputRacingCars();
        Integer count = inputCount();
        return new RacingCarGame(racingCars, count);
    }

    static RacingCars inputRacingCars() {
        OutputUtil.printRacingCarsNameDemand();
        return new RacingCars(InputUtil.inputRacingCars());
    }

    static Integer inputCount() {
        OutputUtil.askAttempTime();
        return InputUtil.inputCount();
    }

    static void checkCarNameIsEmpty(RacingCars racingCars) {
        if (racingCars.getRacingCars().size() == 0) {
            throw new IllegalArgumentException("자동차 이름을 채워주세요!");
        }
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
