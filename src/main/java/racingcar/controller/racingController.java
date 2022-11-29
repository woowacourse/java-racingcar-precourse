package racingcar.controller;

import racingcar.message.outputMessage;
import racingcar.model.Car;
import racingcar.model.racingGame;
import racingcar.model.winningResult;
import racingcar.view.inputView;
import camp.nextstep.edu.missionutils.Randoms;
import racingcar.view.outputView;

import java.util.ArrayList;
import java.util.List;

public class racingController {
    private final racingGame racinggame = new racingGame();
    private final winningResult winningresult = new winningResult();
    private final inputView inputView = new inputView();
    private final outputView outputview = new outputView();
    public void start() {
        String[] names = inputView.getNames();
        int round = inputView.getRound();
        List<Car> cars = racinggame.saveCars(names);
        roundResult(round, cars);
        winningresult.winnigScore(cars);
        outputview.result(cars, winningresult.winningScore);
    }
    public void roundResult(int round, List<Car> cars){
        System.out.println();
        System.out.println(outputMessage.GAME_ROUND);
        for(int i=0; i<round; i++) {
            racinggame.updatePhase(cars);
            outputview.round(cars);
        }
    }
}