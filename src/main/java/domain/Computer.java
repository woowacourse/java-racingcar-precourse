package domain;

import view.OutputForNotify;

import java.util.List;

public class Computer {
    private static final int MIN_OF_GO = 4;
    private static final int RANGE_OF_NUMBER = 9;

    public static void gameStart(List<Car> users, int howMany) {
        OutputForNotify.gameResult();
        for(int i =0; i<howMany; i++){
            for(int k =0; k<users.size(); k++){
                Car.makeResult(users.get(k),notifyGoOrStop());
                Car.printResult(users.get(k));
            }
            OutputForNotify.nextLine();
        }
    }
    public static String whosWin(List<Car> users){
        return Car.getWinner(users);
    }

    private static int makeRandomNumber(){
        return (int)(Math.random() * RANGE_OF_NUMBER);
    }

    private static boolean notifyGoOrStop(){
        if(makeRandomNumber()>=MIN_OF_GO)
            return true;
        return false;
    }

}
