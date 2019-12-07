/**
 * Main.java 2019.12.07
 * <p>
 * version 1.0
 */
package domain;

import domain.Controller.RacingManager;

/**
 * RacingManager를 생성하고 start를 호출하여 게임을 시작한다.
 *
 * @version 1.0 2019-12-07
 * @author 황성찬
 */
public class Main {

    public static void main(String[] args) {
        RacingManager racingmanager = new RacingManager();

        racingmanager.start();
    }
}
