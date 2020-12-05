package racingcar;

import utils.RandomUtils;

public class Car implements Comparable<Car>{
    private final String name;
    private int position = 0;
    private int randNum;

    public Car(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Car o) {
        return Integer.compare(o.getPosition(), this.position);
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void move() {
        randNum = RandomUtils.nextInt(Constant.MIN_RANGE_NUM, Constant.MAX_RANGE_NUM);
        if (randNum >= Constant.ADVANCE_NUM) {
            advance();
        }
    }

    public void advance() {
        position++;
    }

    public void print() {
        StringBuilder result = new StringBuilder(name + " : ");
        for (int i = Constant.ZERO; i < position; i++) {
            result.append(Constant.BAR);
        }
        System.out.println(result);
    }
}
