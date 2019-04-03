package domain;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

/*
 *
 * 경주게임에 필요한 Car 클래스
 *
 * @ver 1.0
 * @author 이준규
 *
 * */

public class Car {
    private final String name;
    private int position = 0;
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuilder location = new StringBuilder();

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void goOrStop() {
        int num = (int)(Math.random()*10);
        if (num >= 4) {
            position++;
            location.append("-");
        }
    }

    public void printLocation() throws IOException {
        String name = this.name;
        bw.write(name + " : ");
        bw.flush();
        System.out.println(location);

    }

}