/*
 * 클래스 이름: Car
 * 버전 정보: v1.0
 * 날짜: 12월 7일
 * 저작권 주의
 */

package domain;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    // 추가 기능 구현
    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }

    public void moveForward() {
        this.position++;
    }

    public String currentPosition() {
        String currentPosition = "";
        for (int i = 0; i < this.position; i++) {
            currentPosition += "-";
        }
        return currentPosition;
    }

}
