package racingcar.controller;
import camp.nextstep.edu.missionutils.Console;
import racingcar.exception.ErrorResponse;
import racingcar.message.Message;
import racingcar.message.MessageResponse;
import racingcar.service.GameService;

public class GameController {

	public GameService gameService;

	public void inputCars() {
		MessageResponse.of(Message.ENTER_CARS_NAME.getMessage());

		try {
			gameService.inputCars(Console.readLine());
		} catch (IllegalArgumentException e){
			ErrorResponse.of(e.getMessage());
			inputCars();
		}

	}

	public void inputRepeatNumber() {
		MessageResponse.of(Message.ASK_REPEAT_NUM.getMessage());

		try {
			gameService.inputRepeatNumber(Console.readLine());
		} catch (IllegalArgumentException e) {
			ErrorResponse.of(e.getMessage());
			inputRepeatNumber();
		}
	}

	public void postResult() {
		MessageResponse.of(Message.PRINT_RESULT.getMessage());
		gameService.postResult();
	}

	public void postWinner() {
		MessageResponse.of(Message.ENTER_WINNER.getMessage());
		gameService.postWinner();
	}
}
