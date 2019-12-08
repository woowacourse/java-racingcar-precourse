package domain;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class ConsoleMain {
    private static String[] carName;
    private static int movementNumber;
    private static String winners = "";
    private static final int MAX_NAME_LENGTH = 5;

    public static void main(String[] args){
        ArrayList<Car> car = new ArrayList<>();
        inputCarName();
        inputMovementNumber();
        for(int i = 0; i < carName.length; i++){
            car.add(new Car(carName[i]));
        }

        System.out.println("실행 결과");
        for(int i = 0; i < movementNumber; i++){
            moveCar(car);
            printCarPosition(car);
        }

        getWinner(car);
    }

    private static void inputCarName() {
        Scanner sc = new Scanner(System.in);
        String carName_Line;

        System.out.println("경주할 자동차 이름을 입력하세요."
                                +"(이름은 쉼표(,) 기준으로 구분)");
        carName_Line = sc.nextLine();
        carName = carName_Line.split(",");

        for(int i = 0; i < carName.length; i++){
            if(carName[i].length() > MAX_NAME_LENGTH){
                inputCarName();
            }
        }
    }

    private static void inputMovementNumber(){
        Scanner sc = new Scanner(System.in);

        System.out.println("시도할 회수는 몇회인가요?");
        movementNumber = sc.nextInt();
    }

    private static boolean decideMovement(){
        Random random = new Random();
        if(random.nextInt(10) >= 4){
            return true;
        }else{
            return false;
        }
    }

    private static void moveCar(ArrayList<Car> car){
        for(int i = 0; i < car.size(); i++){
            if(decideMovement()){
                car.get(i).moveForward();
            }
        }
    }

    private static void printCarPosition(ArrayList<Car> car){
        for(int i = 0; i < car.size(); i++){
            System.out.println(car.get(i).getName() + " : "
                                + printPositionByLine(car.get(i).getPosition()));
        }
        System.out.println();
    }

    private static String printPositionByLine(int position){
        String Line = "";

        for(int i = 0; i < position; i++){
            Line += "-";
        }
        return Line;
    }

    private static void getWinner(ArrayList<Car> car){
        int max = 0;

        for(int i = 0; i < car.size(); i++){
            if(car.get(i).getPosition() > max){
                winners = car.get(i).getName();
                max = car.get(i).getPosition();
            }else if(car.get(i).getPosition() == max){
                winners += ", " + car.get(i).getName();
            }
        }

        System.out.println(winners + "가 최종 우승했습니다.");
    }
}
