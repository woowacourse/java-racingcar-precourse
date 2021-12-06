package racingcar;

public class Player {

	protected void sendMessage(String message) {
		System.out.print(message);
	}

	protected String askQuestionReturnAnswer(String message) {
		sendMessage(message);
		return camp.nextstep.edu.missionutils.Console.readLine();
	}
}
