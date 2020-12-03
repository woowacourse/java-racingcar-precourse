package racingcar;

import java.util.ArrayList;
import java.util.Scanner;

public class Racing {

    public StringUtils racingEvent;

    ArrayList<Car> racerList = new ArrayList<Car>();

    public Racing(Scanner promptInput) {
        // start game prompt
        racingEvent = new StringUtils(promptInput);
        setGrid(racingEvent);
    }

    private void setGrid(StringUtils racingEvent) {
        for (String name : racingEvent.racerNameList) {
            Car racer = new Car(name);
            racerList.add(racer);
        }
    }

}
