package racingcar.domain;

import racingcar.utils.OutputFormatter;

public class Car {

    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void moveForward(MoveTicket moveTicket) {
        if (moveTicket.isValidTicket()) {
            this.position++;
        }
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }

    public boolean isLeadPosition(int position) {
        return this.position == position;
    }

    public String getCarStatus() {
        return OutputFormatter.converseCarStatus(position, name);
    }
}
