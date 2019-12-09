package domain.controller;

import java.util.List;

import domain.model.Car;

/**
 * @author 김시영
 * @apiNote RacingController의 필수 작업을 명확하게 하기 위한 인터페이스
 * @implSpec 게임시작을 위한 메서드와 승자를 리턴하는 메소드를 구현 해야한다.
 * @since 2019-12-08
 */
public interface Game {

    void gameStart(List<Car> users, int howManyPlay);

    List<String> getWinner(List<Car> users);

}
