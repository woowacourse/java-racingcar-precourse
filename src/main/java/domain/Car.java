/*
 * 클래스 이름   Car
 * 버전 정보    1.0
 * 날짜        2019.12.04
 * 저작권      woowacourse
 */

package domain;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    // 추가 기능 구현
    public void increasePosition() {
        position++;
    }
}
