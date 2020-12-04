package racingcar;


import java.util.List;

public class Result {

    public static void printCarName(String name){
        System.out.print(name + " : ");
    }

    public static void printCarPosition(int position){
        for(int i=0; i < position; i++){
            System.out.print('-');
        }
        System.out.println();
    }

    public static void printFinalWinner(List<String> winners){
        System.out.print("최총 우승자: ");
        for(int i=0; i < winners.size(); i++){
            System.out.print(winners.get(i));
            if(i != winners.size()-1){
                System.out.print(", ");
            }
        }
    }

}
