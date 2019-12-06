package domain;
import java.util.Random;
import java.util.Scanner;

public class Manager {
    private int number;
    private Car[] cars;

    public Manager(){
        input_car_name();
        input_try_number();

    }

    private int generate_random_number(){
        Random rand = new Random();
        return rand.nextInt(10);
    }

    private void input_try_number(){
        Scanner sc = new Scanner(System.in);
        System.out.println("시도할 회수는 몇회인가요?");
        number = sc.nextInt();
    }

    private void input_car_name(){
        while(true){
            Scanner sc = new Scanner(System.in);
            System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");
            String string = sc.nextLine();
            String[] names = string.split(",");

            if(check_car_name(names)){
                generate_cars(names);
                break;
            }
            System.out.println("자동차 이름이 5글자를 초과하였습니다. 다시 입력해주세요.");
        }

    }

    private boolean check_car_name(String[] names){
        for(int i=0;i<names.length;++i){
            if(names[i].length() > 5){
                return false;
            }
        }
        return true;
    }

    private void generate_cars(String[] names){
        cars = new Car[names.length];
        for(int i=0;i<names.length;++i){
            cars[i] = new Car(names[i]);
        }
    }

    private boolean check_go_or_stop(){
        int random_number = generate_random_number();
        if(random_number >3){
            return true;
        }
        return false;
    }

    public void cars_go_or_stop(){
        for(int i=0;i<cars.length;++i){
            if(check_go_or_stop()){
                cars[i].increase_one_position();
            }
        }
    }

    public void print_winner(){
        int max_value = 0;
        String string = "";

        for(int i=0;i<cars.length;++i){
            if(max_value < cars[i].getPosition()){
                max_value = cars[i].getPosition();
            }
        }

        for(int i=0;i<cars.length;++i){
            if(max_value == cars[i].getPosition()) {
                string += cars[i].getName() + ", ";
            }
        }

        string = string.substring(0,string.length()-2) + "가 최종 우승했습니다.";
        System.out.println(string);
    }

    public int getNumber(){
        return number;
    }

    public void print_cars_position(){
        for(int i=0;i<cars.length;++i){
            System.out.printf("%s : ",cars[i].getName());

            for(int j=0;j<cars[i].getPosition();++j){
                System.out.printf("-");
            }
            System.out.printf("\n");
        }
    }

}
