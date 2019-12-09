package domain.controller;

import java.util.List;

import domain.model.Car;
import domain.model.Computer;
import domain.model.Winner;
import view.PrintHandler;

/**
 * @author 김시영
 * @apiNote 자동차 경주를 위한 클래스로 게임시작, 사용자별 전진&스탑 여부, 우승자찾기 등의 메서드로 이루어져있습니다.
 * @since 2019-12-05
 */
public class RacingGame implements Game {
    private static final int MIN_OF_GO = 4;

    @Override
    public void gameStart(List<Car> users, int howMany) {
        PrintHandler.gameResult();
        for (int i = 0; i < howMany; i++) {
            for (int k = 0; k < users.size(); k++) {
                users.get(k).goForwardPosition(notifyGoOrStop(),users.get(k));
                PrintHandler.printLocations(users.get(k));
            }
            PrintHandler.nextLine();
        }
    }

    private boolean notifyGoOrStop() {
        return Computer.makeRandomNumber() >= MIN_OF_GO;
    }

    @Override
    public List<String> getWinner(List<Car> users) {
        Winner winner = new Winner(users);
        return winner.getWinner();
    }
}
