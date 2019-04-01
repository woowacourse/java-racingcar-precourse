package domain;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    /**
     * 자동차를 이동시킨다.
     * 랜덤한 숫자를 뽑아서 4이상일 경우 전진, 3이하일 경우 멈춤.
     */
    public void move() {
        int randomNumber = getRandomNumber();
        position = (randomNumber >= 4) ? position + 1 : position;

        /* 랜덤 값에 따른 자동차의 이동 테스트 코드 */
        //System.out.println("randomNumber : " + randomNumber);
    }

    public void printPosition() {
        System.out.print(getName() + " : ");
        for (int i = 0; i < position; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    private int getRandomNumber() {
        return (int) (Math.random() * 10);
    }
}
