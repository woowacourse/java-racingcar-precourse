package racingcar.domain;

import java.util.List;
import racingcar.NumberGenerator;
import racingcar.dto.CarPositionDto;
import racingcar.dto.WinnerDto;
import racingcar.view.OutputView;

public class RacingGameApplication {

    private final RacingGameGenerator racingGameGenerator;
    private final NumberGenerator numberGenerator;
    private final OutputView outputView;

    public RacingGameApplication(RacingGameGenerator racingGameGenerator,
                                 NumberGenerator numberGenerator,
                                 OutputView outputView) {
        this.racingGameGenerator = racingGameGenerator;
        this.numberGenerator = numberGenerator;
        this.outputView = outputView;
    }

    public void run() {
        RacingGame racingGame = racingGameGenerator.generate();
        runningGame(racingGame);
        outputView.printWinnerNames(racingGame.getWinners());
    }

    private void runningGame(RacingGame racingGame) {
        outputView.printRunMessage();
        while (!racingGame.isOver()) {
            List<CarPositionDto> carPositionDtos = racingGame.move(numberGenerator);
            outputView.printCarsPosition(carPositionDtos);
        }
    }
}
