package racingcar;

public class Player {

	protected void getMessage(String message) {
		System.out.print(message);
	}

	protected String askQuestionReturnAnswer(String message) {
		getMessage(message);
		return camp.nextstep.edu.missionutils.Console.readLine();
	}
}
