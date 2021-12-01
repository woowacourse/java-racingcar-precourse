package racingcar;

import java.util.List;

import static util.CarConstant.*;

public class CarView {

    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printImplResult(Car car){
        int position = car.getPosition();
        StringBuilder sb = new StringBuilder();
        while(position-- > ZERO){
            sb.append(MARK);
        }
        String positionMark = sb.toString();
        System.out.println(car.getName() + SEPARATOR + positionMark);
    }

    public static void printFinalWinner(List<Car> winners){
        System.out.print(FINAL_WINNER + SEPARATOR);
        if(winners.size() > 1){
            System.out.println(createWinnersName(winners));
            return ;
        }
        System.out.println(winners.get(ZERO).getName());
    }

    private static String createWinnersName(List<Car> winners) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < winners.size(); i++){
            sb.append(winners.get(i).getName());
            appendDelimeter(winners, sb, i);
        }
        return sb.toString();
    }

    private static void appendDelimeter(List<Car> winners, StringBuilder sb, int i) {
        if(i != winners.size()-1){
            sb.append(DELIMITER + SPACE);
        }
    }


    public static void breakLine() {
        System.out.println();
    }

}
