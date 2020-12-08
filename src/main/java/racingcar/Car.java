package racingcar;

import utils.RandomUtils;

/**
 * 자동차 경주 게임을 위한 자동차의 이름과 얼마나 전진했는지를 나타내는 클래스
 */
public class Car {
    private static final int START = 0;
    private static final int END = 9;
    private static final String moveCharacter = "-";

    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    /**
     * RandomUtils 를 이용해서 START 부터 END 사이의 임의의 숫자를 생성
     * 임의의 숫자가 4이상이면 전진하여 position 을 1증가시킴
     */
    public void tryMove() {
        if (RandomUtils.nextInt(START, END) >= 4) {
            position++;
        }
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }

    /**
     * 자동차의 현재 위치를 문자열로 보여주는 메서드
     * (자동차 이름) : 현재 위치("-"을 단위로 position 을 표현합니다.)
     * 예시) bmw : ----
     *      genesis : ------
     *
     * @return "(자동차 이름) : (현재 위치)" 반환
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < position; i++) {
            sb.append(moveCharacter);
        }
        return this.name + " : " + sb;
    }

    // 추가 기능 구현
}
