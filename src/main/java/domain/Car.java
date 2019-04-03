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

    public void goAndStop() {

        if (randomNumGenerator() >= 4)
            this.position++;

    }

    public void playRacing() {

        System.out.print(this.name + ":");
        for (int i = 0; i < this.position; i++) {
            System.out.print("-");
        }
        System.out.println();

    }

    public String getName() {
        return name;
    }


    public int getPosition() {
        return position;
    }
}
