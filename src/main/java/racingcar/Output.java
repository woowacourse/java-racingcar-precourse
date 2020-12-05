package racingcar;

import java.util.ArrayList;

public class Output {
    private static final String GO_MARK = "-";
    private static final String FINAL_WINNER_INFO_MESSAGE = "최종 우승자: ";
    private static final String SPLIT_DELIMITER = ", ";
    
    private Car[] car;
    
    public Output(Car[] car) {
        this.car = car;
    }
    
    public void printResult(){
        for (int i = 0; i < car.length; i++) {
            String carName = car[i].getName();
            int carPosition = car[i].getPosition();
            System.out.print(carName + " : ");
            for (int j = 0; j < carPosition; j++) {
                System.out.print(GO_MARK);
            }
            System.out.println();
        }
    }
    public void printFinalWinner() {
        ArrayList<Car> finalWinner = getFinalWinner();
        System.out.print(FINAL_WINNER_INFO_MESSAGE);
        int index = 0;
        for (Car car : finalWinner) {
            System.out.print(car.getName());
            index++;
            if (index != finalWinner.size() - 1) {
                System.out.print(SPLIT_DELIMITER);
            }
        }
    }
    
    public ArrayList<Car> getFinalWinner() {
        ArrayList<Car> finalWinner = new ArrayList<Car>();
        int maxPosition = 0;
        for (int i = 0; i < car.length; i++) {
            maxPosition = Math.max(maxPosition, car[i].getPosition());
        }
        for (int i = 0; i < car.length; i++) {
            if (car[i].getPosition() == maxPosition) {
                finalWinner.add(car[i]);
            }
        }
        return finalWinner;
    }
}