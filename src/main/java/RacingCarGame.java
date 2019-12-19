
import domain.Count;
import domain.RacingCars;
import domain.Winners;
import utils.InputUtil;
import utils.OutputUtil;

class RacingCarGame {
    private final RacingCars racingCars;
    private final Count count;

    private RacingCarGame(RacingCars racingCars, int count) {
        this.racingCars = racingCars;
        this.count = new Count(count);
    }

    static RacingCarGame inputSettings() {
        return new RacingCarGame(inputRacingCars(), inputCount());
    }

    void start() {
        while (count.isNotLimitCount()) {
            racingCars.move();
            OutputUtil.printRacingSituation(racingCars);
            count.plusCount();
        }
        decideWinners();
    }

    private static RacingCars inputRacingCars() {
        OutputUtil.printRacingCarsNameDemand();
        String[] carNames = InputUtil.inputRacingCars();
        return RacingCars.initRacingCars(carNames);
    }

    private static int inputCount() {
        OutputUtil.printAttempTimeQUestion();
        return InputUtil.inputCount();
    }

    private void decideWinners() {
        Winners winners = new Winners(racingCars.decideWinners());
        // 분기를 여기서 이런식으로 하는게 나은가...?
        // TODO : 그냥 여기선 print하고 로직을 Winner에 넘겨버리자!
        winners.printWinner();
    }
}
