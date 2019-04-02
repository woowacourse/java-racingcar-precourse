/*
 * 클래스 이름: Car.java
 * 버전 정보: 1.0.0
 * 날짜: 2019/04/03
 * Copyright 2019 Inkwon Lee
 */
package domain;

/*
 * Car 의 객체를 생성할 모델 클래스
 * 0~9까지의 난수를 통해 4이상일 경우 position 의 1을 올려주는 함수 구현
 */
public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void movePosition(){
        if((int)(Math.random()*10) >= 4){
            this.position++;
        }
    }

    public int getPosition() {
        return position;
    }

}
