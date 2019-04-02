/**
 * 우아한테크코스 프리코스 2주차 미션
 * 자동차 경주 게임
 *
 * @author JiHoon Kim
 * @version 1.0
 */

package domain;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    /**
     * 전진 처리를 하는 메소드
     */
    public void goForward() {
        position++;
    }

    /**
     * 현재 위치만큼 '-'를 출력하는 메소드
     */
    public void printPosition() {
        System.out.print(name + " : ");
        for (int i = 0; i < position; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
