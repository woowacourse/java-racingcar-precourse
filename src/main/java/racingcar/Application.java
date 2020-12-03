package racingcar;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        AskQuestion askQuestion = new AskQuestion(scanner);
        GameManager gameManager = askQuestion.readyToGame();
        gameManager.gameStart();
    }
}
