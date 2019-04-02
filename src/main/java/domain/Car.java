/**
 * Car Class는 자동차의 이름과 현재 위치를 갖는 class이다.
 * Name은 생성 될 때 한번 정해지면 바뀌지 않고, Position은 Setposition으로 한번에 변경할 수 없게 구현한다.
 * Last Modified: 2019.04.02
 * Author: 원본 - woowacourse, 수정 - SM Jeon
 */

package domain;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public String getCarName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }

    public void addOnePosition() {
        this.position++;
    }
}
