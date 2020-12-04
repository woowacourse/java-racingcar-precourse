package racingcar;


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

    public static void printFinalWinner(){
        System.out.println("실행 결과");

    }

}
