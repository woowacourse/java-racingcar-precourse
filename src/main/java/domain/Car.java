package domain;
/*
 * 클래스 이름 : Car
 * 작성자 : Moonyoung Chae
 * 날짜 : 2019/12/05
 * Copyright (c) 2019 Moonyoung Chae
 */

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public int makeRandomNumber(){
        return (int) (Math.random() * 10);
    }

    public void move(int randomNumber){
        if(randomNumber >= 4)
            position++;
    }
}
