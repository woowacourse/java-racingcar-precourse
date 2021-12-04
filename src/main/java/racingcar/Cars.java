package racingcar;

import java.util.ArrayList;

public class Cars implements ICars {
    private Car[] carArray;
    private String match = "[^\uAC00-\uD7A30-9a-zA-Z]";

    @Override
    public void createCar(String[] names){
        carArray = new Car[names.length];
        for (int i = 0; i < names.length; i++) {
            carArray[i] = new Car(names[i]);
        }
    }

    @Override
    public void moveCar(){
        for (int i = 0; i < carArray.length; i++) {
            carArray[i].pickRandomNumber();
        }
    }

    @Override
    public void getWinner(){
        int maxPosition = getMaxPosition();
        String result = "최종 우승자 : ";

        for (int i = 0; i < carArray.length; i++) {
            if (carArray[i].getPosition() == maxPosition) {
                result += carArray[i].getName() + ", ";
            }
        }

        System.out.println(result.substring(0, result.length() - 2));
    }

    @Override
    public void printResult(int count) {
        for (int i = 0; i < carArray.length; i++) {
            System.out.println(carArray[i].getTrace().get(count));
        }
    }

    private int getMaxPosition() {
        int result = 0;
        for (int i = 0; i < carArray.length; i++) {
            result = Math.max(carArray[i].getPosition(), result);
        }
        return result;
    }
}
