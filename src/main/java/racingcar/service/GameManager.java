package racingcar.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import racingcar.domain.Car;
import racingcar.domain.GameRoundResultDto;
import racingcar.domain.GameTotalResultDto;
import racingcar.resource.rule.RunnableCondition;
import racingcar.service.picker.NumberPicker;

public class GameManager {

    private final NumberPicker numberPicker;

    private GameTotalResultDto gameTotalResult;
    private Map<String, Car> carMap;
    private int winnerPosition;

    public GameManager(NumberPicker numberPicker) {
        this.numberPicker = numberPicker;
    }

    public GameTotalResultDto getGameTotalResult() {
        return this.gameTotalResult;
    }

    public void playGame(List<String> names, int executionCount) {
        initGameManager(names);
        for (int i = 0; i < executionCount; i++) {
            playRound();
            updateGameRoundStatuses();
        }
        updateGameWinners();
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

    private void updateGameRoundStatuses() {
        GameRoundResultDto roundStatusesDto = new GameRoundResultDto();
        carMap.forEach((name, car) -> roundStatusesDto.appendStatus(car.toString()));
        gameTotalResult.appendRoundResult(roundStatusesDto);
    }

    private void updateGameWinners() {
        carMap.forEach((name, car) -> {
            if (car.isSamePosition(winnerPosition)) {
                gameTotalResult.appendWinner(name);
            }
        });
    }


    private void initGameManager(List<String> names) {
        this.resetNames(names);
        this.resetGameTotalResultDto();
        this.resetWinnerPosition();
    }

    private void resetNames(List<String> names) {
        carMap = new LinkedHashMap<>();
        names.forEach(name -> carMap.put(name, new Car(name)));
    }

    private void resetGameTotalResultDto() {
        this.gameTotalResult = new GameTotalResultDto();
    }

    private void resetWinnerPosition() {
        this.winnerPosition = 0;
    }

}
