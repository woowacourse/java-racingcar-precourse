package racingcar;

public class Car implements Comparable<Car> {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    // 추가 기능 구현

    // 자동차 이름과 위치에 대한 getter
    public String getName() {
        return this.name;
    }

    // compareTo 메서드를 사용하기 위해서 Integer로 반환합니다.
    public Integer getPosition() {
        return this.position;
    }

    // 위치를 1 증가시키는 함수
    public void addPosition() {
        this.position++;
    }

    // 각 자동자(객체)마다 이름과 현재 위치 상태를 출력해주는 메서드
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i<getPosition(); i++) {
            stringBuilder.append('-');
        }
        return getName() + " : " + stringBuilder.toString();
    }

    // 다른 객체와의 위치를 비교하기 위한 함수
    @Override
    public int compareTo(Car c) {
        return getPosition().compareTo(c.getPosition());
    }

}
