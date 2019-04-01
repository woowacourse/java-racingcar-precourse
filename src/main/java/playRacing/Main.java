package playRacing;

import domain.Car;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static Car[] cars;
    static final String WINNER_MESSAGE="가 최종 우승했습니다.";
    static final String EXCEPTION_MESSAGE="자동차의 이름은 5글자 이하로 입력해주세요.";
    static final String INPUT_NAMES_MESSAGE="경주할 자동차의 이름을 입력해주세요.(이름은 쉼표(,)기준으로 구분";
    static final String INPUT_TRIAL_MESSAGE="시도할 횟수는 몇 회인가요?";


    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        String[] carNames;

        while(true){
            System.out.println(INPUT_NAMES_MESSAGE);
            carNames=sc.nextLine().split(",");
            if(isNameValid(carNames)){
                break;
            }
        }

        System.out.println(INPUT_TRIAL_MESSAGE);
        int trial=Integer.parseInt(sc.nextLine());

        namesMappingToCars(carNames);

        for(int i=0; i<trial; i++){
            startAction();
            printAllPosition();
        }

        System.out.println(judgeWinner());



    }

    public static boolean isNameValid(String[] names) {
        for (int i = 0; i < names.length; i++) {
            if (names[i].length() > 5) {
                System.out.println(EXCEPTION_MESSAGE);
                return false;
            }
        }
        return true;
    }

    public static void namesMappingToCars(String[] names){
        cars = new Car[names.length];
        for(int i=0; i<names.length; i++){
            cars[i]=new Car(names[i]);
        }
    }

    /**
     * 모든 자동차의 액션(멈춤/전진)을 실행시키는 함수
     */
    public static void startAction() {
        for (int i = 0; i < cars.length; i++) {
            cars[i].goOrStop();
        }
    }

    public static void printAllPosition() {
        StringBuilder allPosition = new StringBuilder();
        for (int i = 0; i < cars.length; i++) {
            allPosition.append(cars[i].printPosition() + "\n");
        }
        System.out.println(allPosition.toString());
    }
    public static String judgeWinner(){
        Arrays.sort(cars);
        StringBuilder winner = new StringBuilder(cars[0].getName());
        int maxPosition=cars[0].getPosition();
        for(int i=1; i<cars.length; i++){
            if(cars[i].getPosition()==maxPosition){
                winner.append(","+cars[i].getName());
            }
        }
        winner.append(WINNER_MESSAGE);
        return winner.toString();
    }

}
