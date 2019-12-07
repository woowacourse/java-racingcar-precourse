/**
 * Main 클래스
 *
 * RacingManager Class를 호출하고
 * start 함수를 사용해서 게임을 시작한다.
 */
package domain;

import domain.Controller.RacingManager;

public class Main {

    public static void main(String[] args) {
        RacingManager racingmanager = new RacingManager();

        racingmanager.start();
    }
}
