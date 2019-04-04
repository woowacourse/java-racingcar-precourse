import domain.Car;
import java.util.*;

public class Racing {
    public static int car_num, racing_num, winner_num;
    public static Car[] cars;
    public static String[] winners;
    public static int count_car_num(String s){
        int count=1;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)==',')
                count++;
        }
        return count;
    }
    public static void main(String[] args){
        get_input();
        racing();
        find_winner();
        print_winner();
    }
}
