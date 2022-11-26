package racingcar.domain;


import racingcar.view.InputView;

public interface InputParser {

    Cars createCars(InputView inputView);

    CountOfMoves createCountOfMoves(InputView inputView);

}
