package racingcar.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import racingcar.controller.dto.GameRoundResultDto;
import racingcar.controller.dto.GameTotalResultDto;
import racingcar.domain.Car;
import racingcar.service.picker.NumberPicker;
import racingcar.utils.RunnableCondition;

public class GameService {

    private final NumberPicker numberPicker;

    private GameTotalResultDto gameTotalResult;
    private Map<String, Car> carMap;
    private int winnerPosition;

    public GameService(NumberPicker numberPicker) {
        this.numberPicker = numberPicker;
    }

    public GameTotalResultDto getGameTotalResult() {
        return gameTotalResult;
    }

    public void playGame(List<String> names, int executionCount) {
        initGameManager(names);
        for (int i = 0; i < executionCount; i++) {
            playRound();
            updateGameRoundResult();
        }
        updateGameWinners();
    }

    private void initGameManager(List<String> names) {
        resetNames(names);
        resetGameTotalResultDto();
        resetWinnerPosition();
    }

    private void resetNames(List<String> names) {
        carMap = new LinkedHashMap<>();
        names.forEach(name -> carMap.put(name, new Car(name)));
    }

    private void resetGameTotalResultDto() {
        gameTotalResult = new GameTotalResultDto();
    }

    private void resetWinnerPosition() {
        winnerPosition = 0;
    }

    private void playRound() {
        carMap.forEach((name, car) -> {
            if (RunnableCondition.isRunnable(numberPicker.pickOne())) {
                car.forward();
            }
            if (car.isFatherThan(winnerPosition)) {
                winnerPosition++;
            }
        });
    }

    private void updateGameRoundResult() {
        GameRoundResultDto roundResultDto = new GameRoundResultDto();
        carMap.forEach((name, car) -> roundResultDto.appendCarStatus(car.toString()));
        gameTotalResult.appendRoundResult(roundResultDto);
    }

    private void updateGameWinners() {
        carMap.forEach((name, car) -> {
            if (car.isSamePosition(winnerPosition)) {
                gameTotalResult.appendWinner(name);
            }
        });
    }

}
