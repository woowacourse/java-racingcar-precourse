package domain;

import view.PrintHandler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * @author 김시영
 * @since 2019-12-05
 * @apiNote 자동차 경주를 위한 클래스로 게임시작, 사용자별 전진&스탑 여부, 우승자찾기 등의 메서드로 이루어져있습니다.
 */
public class RacingController {
    private static final int MIN_OF_GO = 4;
    private static RacingController INSTANCE;

    private RacingController() {
        throw new AssertionError();
    }

    public static RacingController getInstance(){
        if(INSTANCE ==null){
            INSTANCE = new RacingController();
        }
        return INSTANCE;
    }

    public void gameStart(List<Car> users, int howMany) {
        PrintHandler.gameResult();
        for (int i = 0; i < howMany; i++) {
            for (int k = 0; k < users.size(); k++) {
                users.get(k).goForwardPosition(notifyGoOrStop());
                PrintHandler.printLocations(users.get(k));
            }
            PrintHandler.nextLine();
        }
    }

    private boolean notifyGoOrStop() {
        return Computer.makeRandomNumber() >= MIN_OF_GO;
    }

    public List<String> getWinner(List<Car> users) {
        int maxPositionValue = maxPositionNumber(users);
        return whoIsTheSameAsMaxPosition(users, maxPositionValue);
    }

    private int maxPositionNumber(List<Car> users) {
        List<Integer> positionList = new ArrayList<>();
        Iterator<Car> userIterator = users.iterator();
        while(userIterator.hasNext()){
            positionList.add(userIterator.next().getPosition());
        }
        return Collections.max(positionList);
    }

    private List<String> whoIsTheSameAsMaxPosition(List<Car> users, int maxPosition) {
        List<String> winners = new ArrayList<>();
        Iterator<Car> userIterator = users.iterator();
        while(userIterator.hasNext()){
            Car next = userIterator.next();
            if(next.getPosition() == maxPosition){
                winners.add(next.getName());
            }
        }
        return winners;
    }

}
