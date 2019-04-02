import java.util.Arrays;
import java.util.Scanner;
import domain.Car;

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

        System.out.println("실행 결과");
        for(int i=0;i<num;i++){
            gameStart();
            printCarsPosition();
        }

        whoIsWinner();
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

    public static void gameStart(){
        for(int i=0; i<cars.length;i++)
            cars[i].chooseGoOrStop();
    }

    public static void printCarsPosition(){
        for(int i=0;i<cars.length;i++){
            System.out.print(cars[i].getName()+": ");
            int position = cars[i].getPosition();
            for(int j=0; j<position; j++){
                System.out.print("-");
            }
            System.out.println();
        }
    }

    public static void whoIsWinner(){
        Arrays.sort(cars);
        int max_position = cars[0].getPosition();
        System.out.print(cars[0].getName());
        for(int i=1;i<cars.length;i++){
            if(cars[i].getPosition() == max_position)
                System.out.print(", "+cars[i].getName());
        }
        System.out.println("가 최종 우승했습니다.");
    }
}
