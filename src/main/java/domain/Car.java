package domain;



import org.apache.commons.lang3.StringUtils;

import java.util.Random;

public class Car implements RacingCar, Comparable<Car> {
    //todo: apply annotation
    private int id;
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }
    public Car(int id, String name, int position) {
        this.id = id;
        this.name = name;
        this.position = position;
    }

    @Override
    public void race() {
        if (canGo()) {
            go();
        }

    }
    private boolean canGo() {
        int randomNumber = generateRandomNumber();
        return RacingGameConfig.STANDARD_TO_GO < randomNumber;
    }
    private int generateRandomNumber() {
        Random randomGenerator = new Random();
        //todo: check java convention
        return randomGenerator.ints(RacingGameConfig.MIN_RANDOM_NUMBER, RacingGameConfig.MAX_RANDOM_NUMBER + 1)
                .limit(1).findFirst().orElse(RacingGameConfig.MIN_RANDOM_NUMBER - 1);
    }

    private void go() {
        position += RacingGameConfig.STEP;
    }

    @Override
    public int getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object object) {
        if ((object == null) || object.getClass() != this.getClass()) {
            return false;
        }

        return this.name.equals(((Car)object).name) && (this.position == ((Car)object).position);
    }

    @Override
    public int compareTo(Car o) {
        if (o.position < this.position) {
            return 1;
        }

        if ((o.position == this.position) && (o.id < this.id)) {
            return 1;
        }
        if ((o.position == this.position) && (o.id == this.id)) {
            return 0;
        }

        return -1;
    }

    @Override
    public String toString() {
        return name + " : " + StringUtils.repeat(RacingGameConfig.POSITION_MARK, position);
    }
}
