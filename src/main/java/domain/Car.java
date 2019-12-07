/*
 * class: Car
 *
 * version: 1.0
 *
 * date: 2019.12.07
 *
 * 이 프로그램의 저작권은 정은석에게 있습니다.
 * Copyright 2019.12.07
 */

package domain;

/**
 * 게임에서 쓰일 Car 객체를 만들 class.
 * car의 name과 position은 private속성
 */
public class Car {
    private final String name;
    private int position = 0;
    RandomMakeNum makeNum = new RandomMakeNum();

    /**
     * 차의 이름을 생성자로 지정해준다
     * @param name car의 name을 parameter로 넣어
     */
    public Car(String name) {
        this.name = name;
    }

    /**
     * 차의 위치를 리턴해준다
     * @return position
     */
    public int getPosition() {
        return this.position;
    }

    /**
     * 차의 이름을 리턴하는 getter
     * @return name
     */
    public String getName() {
        return this.name;
    }

    /**
     * 위치를 전진시켜주는 매소드
     * if문으로 randomMakeNum의 반환값 사용
     */
    public void forwordPosition() {
        if (makeNum.randomMakeNum()) {
            this.position++;
        }
    }


}
