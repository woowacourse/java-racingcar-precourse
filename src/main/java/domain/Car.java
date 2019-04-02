package domain;

public class Car {
    private final String name;
    private int position = 0;
    private int randomNumber;

    public Car(String name) {
        this.name = name;
    }

    // 추가 기능 구현

    private void makeRandomNumber(){
        randomNumber = (int)(Math.random() * 10);
    }

    private void checkCarFoward(){

        if (randomNumber >= 4){
            this.position++;
        }

    }

    private void printCarPosition(){

        System.out.print(name + " : ");

        for (int i = 0; i < position; i++) {
            System.out.print("-");
        }
        System.out.println();

    }

    public void oneLoop(){

        makeRandomNumber();
        checkCarFoward();
        printCarPosition();

    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }



}
