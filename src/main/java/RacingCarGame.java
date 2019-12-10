
import domain.RacingCars;
import domain.Winners;
import utils.InputUtil;
import utils.OutputUtil;

class RacingCarGame {
    private final RacingCars racingCars;
    private Integer count;
    private static final Integer EMPTY = 0;

    private RacingCarGame(RacingCars racingCars, Integer count) {
        checkCarNameIsEmpty(racingCars);
        checkCountValid(count);
        this.racingCars = racingCars;
        this.count = count;
    }

    static RacingCarGame inputSettings() {
        RacingCars racingCars = inputRacingCars();
        Integer count = inputCount();
        return new RacingCarGame(racingCars, count);
    }

    void start() {
        while (count-- > 0) {
            racingCars.move();
            printRacingSituation();
        }
        printWinners();
    }

    private static RacingCars inputRacingCars() {
        OutputUtil.printRacingCarsNameDemand();
        return new RacingCars(InputUtil.inputRacingCars());
    }

    private static Integer inputCount() {
        OutputUtil.askAttempTime();
        return InputUtil.inputCount();
    }

    private static void checkCarNameIsEmpty(RacingCars racingCars) {
        if (racingCars.getRacingCars().size() == EMPTY) {
            throw new IllegalArgumentException("자동차 이름을 채워주세요!");
        }
    }

    private void printRacingSituation() {
        OutputUtil.printRacingSituation(racingCars);
    }

    private void printWinners() {
        Winners winners = new Winners(Referee.decideWinners(racingCars));

        if (winners.getWinnersSize() == EMPTY) {
            OutputUtil.printNoneWinners();
            return;
        }
        OutputUtil.printWinners(winners);
    }

    private static void checkCountValid(Integer count) {
        if (count.equals(EMPTY)) {
            throw new IllegalArgumentException("0이 아닌 카운트 값을 입력해주세요!");
        }
    }
}
