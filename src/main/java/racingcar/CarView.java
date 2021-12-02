package racingcar;

import java.util.List;

import static util.CarConstant.*;

public class CarView {

    public static int SINGLE = 1;

    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printImplResult(Car car){
        int position = car.getPosition();
        StringBuilder resultBuilder = new StringBuilder();
        while(position-- > ZERO){
            resultBuilder.append(MARK);
        }
        String positionMark = resultBuilder.toString();
        System.out.println(car.getName() + SEPARATOR + positionMark);
    }

    public static void printFinalWinner(List<Car> winners){
        System.out.print(FINAL_WINNER + SEPARATOR);
        if(winners.size() > SINGLE){
            System.out.println(createWinnersName(winners));
            return ;
        }
        System.out.println(winners.get(ZERO).getName());
    }

    private static String createWinnersName(List<Car> winners) {
        StringBuilder winnerBuilder = new StringBuilder();
        for(int i = 0; i < winners.size(); i++){
            winnerBuilder.append(winners.get(i).getName());
            appendDelimiter(winners, winnerBuilder, i);
        }
        return winnerBuilder.toString();
    }

    private static void appendDelimiter(List<Car> winners, StringBuilder winnerBuilder, int index) {
        if(index != winners.size()-1){
            winnerBuilder.append(DELIMITER + SPACE);
        }
    }


    public static void breakLine() {
        System.out.println();
    }

}
