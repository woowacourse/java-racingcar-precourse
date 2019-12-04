package domain;

import java.util.Random;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }
    // 이 위로 건드리면 안됨!

    public void playTurn() {
        Random random = new Random();
        if(random.nextInt(10) >= 4) {
            this.proceed();
        }
        System.out.println(name+" : "+getBar());
    }

    public void proceed() {
        position++;
    }

    private String getBar() {
        String bar = "";
        for (int i = 0; i < position; i++) {
            bar += "-";
        }
        return bar;
    }


}
