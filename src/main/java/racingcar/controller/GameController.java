package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.exception.dto.ErrorResponse;
import racingcar.message.Message;
import racingcar.message.dto.ResponseMessage;
import racingcar.service.GameService;

public class GameController {

	private GameService gameService;

	public GameController() {
		this.gameService = new GameService();
	}

	public void inputCars() {
		ResponseMessage.of(Message.ENTER_CARS_NAME.getMessage());

		try {
			gameService.inputCars(Console.readLine());
		} catch (IllegalArgumentException e) {
			ErrorResponse.of(e.getMessage());
			inputCars();
		}
	}

	public void inputRepeatNumber() {
		ResponseMessage.of(Message.ASK_REPEAT_NUM.getMessage());

		try {
			gameService.inputRepeatNumber(Console.readLine());
		} catch (IllegalArgumentException e) {
			ErrorResponse.of(e.getMessage());
			inputRepeatNumber();
		}
	}

	public void getResult() {
		ResponseMessage.of(System.lineSeparator() + Message.PRINT_RESULT.getMessage() + gameService.getResult());
	}

	public void getWinner() {
		ResponseMessage.of(Message.ENTER_WINNER.getMessage() + gameService.getWinner());
	}
}
