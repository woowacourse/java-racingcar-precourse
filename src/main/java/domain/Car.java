package domain;

import view.OutputForNotify;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Car {
    private static final String SPACING_WORDS = " : ";
    private static final String STAR_FOR_POSITION = "*";
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public static void makeResult(Car user, boolean goOrStop) {
        if(goOrStop){
            user.position++;
        }
    }

    public static void printResult(Car user) {
        System.out.print(user.name + SPACING_WORDS);
        for(int i=0; i<user.position; i++){
            System.out.print(STAR_FOR_POSITION);
        }
        OutputForNotify.nextLine();
    }

    public static String getWinner(List<Car> users) {
        List<Integer> positionList = new ArrayList<>();
        for(int i=0; i<users.size(); i++){
            positionList.add(users.get(i).position);
        }
        Integer max = Collections.max(positionList);
        StringBuilder sb = new StringBuilder();
        sb.append("최종 우승자는 : ");
        for(int i=0; i<users.size(); i++){
            if(users.get(i).position == max)
                sb.append(users.get(i).name + " ");
        }
        sb.append("입니다");
        return sb.toString();
    }
}
