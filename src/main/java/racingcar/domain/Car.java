package racingcar.domain;

import lombok.Getter;
import racingcar.constants.ViewConstants;

@Getter
public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void increasePosition() {
        this.position += 1;
    }

    public void notifyStatement() {
        System.out.print(String.format(ViewConstants.NOTIFY_CAR_NAME, name));
        for(int i = 0; i < position; i++) {
            System.out.print(ViewConstants.RACE_BAR);
        }
        System.out.println();
    }
}
