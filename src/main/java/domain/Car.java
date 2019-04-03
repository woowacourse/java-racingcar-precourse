package domain;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    private int randomNumGenerator() {

        int randomNumber = 0;

        while (true) {

            randomNumber = (int) (Math.random() * 10);

            if (randomNumber == 0)
                continue;
            return randomNumber;
        }
    }


}
