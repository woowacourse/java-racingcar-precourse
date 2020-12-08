package racingcar;

import java.util.ArrayList;

public class Output {
    private static final String GO_MARK = "-";
    private static final String FINAL_WINNER_INFO_MESSAGE = "최종 우승자: ";
    private static final String SPLIT_DELIMITER = ", ";
    
    private ArrayList<Car> cars;
    
    public Output(ArrayList<Car> cars) {
        this.cars = cars;
    }
    
    public void printResult(){
        for (Car car : cars) {
            String carName = car.getName();
            int carPosition = car.getPosition();
            System.out.print(carName + " : ");
            for (int j = 0; j < carPosition; j++) {
                System.out.print(GO_MARK);
            }
            System.out.println();
        }
        System.out.println();
    }
    public void printFinalWinner() {
        ArrayList<Car> finalWinner = getFinalWinner();
        System.out.print(FINAL_WINNER_INFO_MESSAGE);
        int index = 0;
        for (Car car : finalWinner) {
            System.out.print(car.getName());
            index++;
            if (index != finalWinner.size()) {
                System.out.print(SPLIT_DELIMITER);
            }
        }
    }
    
    public ArrayList<Car> getFinalWinner() {
        ArrayList<Car> finalWinner = new ArrayList<Car>();
        int maxPosition = 0;
        for (Car car : cars) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                finalWinner.add(car);
            }
        }
        return finalWinner;
    }
}