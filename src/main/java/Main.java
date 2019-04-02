import java.util.Scanner;
import domain.Car;

import javax.naming.Name;

public class Main {
    static Car[] cars;
    static String[] car_names;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
        while(true){
            car_names = sc.nextLine().split(",");
            if(checkName(car_names))
                break;
        }
        System.out.println("시도할 회수는 몇회인가요?");
        int num = sc.nextInt();

        NameMapping();
    

    }

    public static boolean checkName(String[] names) {
        for (int i = 0; i < names.length; i++) {
            if(names[i].length()>5){
                System.out.println("자동차 이름은 5자 이하로 입력해주세요");
                return false;
            }
        }
        return true;
    }

    public static void NameMapping(){
        cars = new Car[car_names.length];
        for(int i=0;i<cars.length;i++){
            cars[i] = new Car(car_names[i]);
        }
    }
}
