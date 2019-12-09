/*
 * 클래스 이름   Car
 * 버전 정보    1.0
 * 날짜        2019.12.04
 * 저작권      woowacourse
 */

package domain;

/**
 * 자동차 하나를 저장하는 객체. 자동차의 이름 name과 전진 횟수 position이 들어간다.
 */

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    // 추가 기능 구현

    /**
     * 자동차가 전진할 때 호출되는 함수이다.
     */
    public void increasePosition() {
        position++;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
