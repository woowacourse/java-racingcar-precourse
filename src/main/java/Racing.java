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
    public static void get_input(){
        Scanner scan = new Scanner(System.in);
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String car_names;
        car_names = scan.nextLine();
        car_num = count_car_num(car_names);
        cars = new Car[car_num];
        winners = new String[car_num];
        String temp = "";
        int temp_num=0;
        for(int i=0; i<car_names.length(); i++){
            temp+=car_names.charAt(i);
            if(car_names.charAt(i)!=',') continue;
            cars[temp_num++] = new Car(temp.substring(0, temp.length()-1));
            temp = "";
        }
        cars[temp_num] = new Car(temp);
        System.out.println(("시도할 회수는 몇회인가요?"));
        racing_num = scan.nextInt();
    }
    public static void racing(){
        System.out.println("실행 결과");
        for(int i=1; i<=racing_num; i++){
            for(int j=0; j<car_num; j++){
                cars[j].move();
                cars[j].print_status();
            }
            System.out.println();
        }
    }
    public static void main(String[] args){
        get_input();
        racing();
        find_winner();
        print_winner();
    }
}
