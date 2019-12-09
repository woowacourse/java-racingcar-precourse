package domain.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * @author 김시영
 * @apiNote 승자를 찾기 위한 클래스입니다.
 * @since 2019-12-08
 * @param <T> 자동차 이외의 탈 것이 추가되는 경우를 고려해 자동차의 상위클래스 Vehicle을 상속받는 T(자동차,비행기 등등의 클래스)
 */
public class Winner<T extends Vehicle> {
    private List<T> user;

    public Winner(List<T> user) {
        this.user = user;
    }

    /**
     * 포지션 값이 가장 높은 유저의 이름을
     * @return List<String>에 담아 리턴
     */
    public List<String> getWinner() {
        int maxPositionValue = maxPositionNumber(user);
        return whoIsTheSameAsMaxPosition(user, maxPositionValue);
    }

    /**
     * 유저 중 가장 높은 포지션의 값을 계산
     * @param users
     * @return 가장 높은 포지션 값
     */
    private int maxPositionNumber(List<T> users) {
        List<Integer> positionList = new ArrayList<>();
        Iterator<T> userIterator = users.iterator();
        while (userIterator.hasNext()) {
            positionList.add(userIterator.next().getPosition());
        }
        return Collections.max(positionList);
    }

    /**
     * 가장 높은 포지션과 포지션이 같은 유저를 리스트에 담아 반환
     */
    private List<String> whoIsTheSameAsMaxPosition(List<T> users, int maxPosition) {
        List<String> winners = new ArrayList<>();
        Iterator<T> userIterator = users.iterator();
        while (userIterator.hasNext()) {
            T next = userIterator.next();
            if (next.getPosition() == maxPosition) {
                winners.add(next.getName());
            }
        }
        return winners;
    }


}
