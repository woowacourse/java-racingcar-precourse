package domain.controller;

import java.util.List;

import domain.model.Computer;
import domain.model.Vehicle;
import domain.model.Winner;
import view.PrintHandler;

/**
 * @author 김시영
 * @apiNote 자동차 경주를 위한 클래스입니다.
 * @since 2019-12-05
 */
public class RacingGame<T extends Vehicle> {
    private static final int MIN_OF_GO = 4;

    /**
     * 게임 시작을 위한 메서드로 각 게임에서 유저의 위치값을 변경시키고 위치를 보여줍니다.
     * @param users 사용자가 입력한 각기 다른 자동차 객체
     * @param howMany 몇번을 플레이 할 것인지 나타냄.
     */
    public void gameStart(List<T> users, int howMany) {
        PrintHandler.gameResult();
        for (int i = 0; i < howMany; i++) {
            for (int k = 0; k < users.size(); k++) {
                users.get(k).goForwardPosition(notifyGoOrStop(), users.get(k));
                PrintHandler.printLocations(users.get(k));
            }
            PrintHandler.nextLine();
        }
    }

    private boolean notifyGoOrStop() {
        return Computer.makeRandomNumber() >= MIN_OF_GO;
    }

    public List<String> getWinner(List<T> users) {
        Winner winner = new Winner(users);
        return winner.getWinner();
    }
}
