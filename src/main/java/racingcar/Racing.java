package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Racing {
    private static List<Car> carList;
    private static int gameNumber;

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        String[] nameList = inputCarsNameList(scanner);
        setCarList(nameList);
        gameNumber = inputNumberofGame(scanner);
        for(int i=0;i<gameNumber;i++){
            carRacing();
        }
        whichCarsWin();
        // TODO 구현 진행
    }

    /* 자동차들의 입력받아 쉼표로 구분하여(,) 반환하는 메소드 */
    public static String[] inputCarsNameList(Scanner scanner) {
        String namesInput;
        String[] nameList = null;

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        try {
            namesInput = scanner.nextLine();
            nameList = namesInput.split(",");
            if (isValidNames(nameList) == false) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 이름은 5자리 이하 문자를 입력해주세요.");
            return inputCarsNameList(scanner);
        }
        return nameList;
    }

    /* 5자리를 초과하거나 빈 문자가 있는지 검사하는 메소드 */
    public static boolean isValidNames(String[] nameList) {
        for (int i = 0; i < nameList.length; i++) {
            if ((nameList[i].length() > 5) || (nameList[i].indexOf(" ") > -1)
                || nameList[i].length() == 0) {
                return false;
            }
        }
        return true;
    }

    /* 이름 리스트를 받아서 Car 객체를 생성하는 메소드*/
    public static void setCarList(String[] nameList){
        carList=new ArrayList<Car>();
        for(int i=0;i<nameList.length;i++){
            carList.add(new Car(nameList[i]));
        }
    }

    /*  */
    public static int inputNumberofGame(Scanner scanner){
        int gameNumber=0;
        System.out.println("시도할 회수는 몇회인가요?");
        try{
            gameNumber=Integer.parseInt(scanner.nextLine());
            if(gameNumber<=0){
                throw new IllegalArgumentException();
            }
        }catch(IllegalArgumentException e){
            System.out.println("[ERROR] 양의 정수를 입력해주세요.");
            return inputNumberofGame(scanner);
        }
        return gameNumber;
    }

    /* 회차마다 차들의 경기를 진행하는 메소드 */
    public static void carRacing(){
        for(int i=0;i<carList.size();i++){
            carList.get(i).movePosition();
        }
        printCarsPosition();
        System.out.println("");
    }

    /* 차량들의 전진 상황을 출력하는 메소드 */
    public static void printCarsPosition(){
        System.out.println("\n실행 결과");
        for(int i=0;i<carList.size();i++){
            System.out.printf(carList.get(i).getName()+" : ");
            carList.get(i).printPosition();
            System.out.println("");
        }
    }

    /* 어떤 차들이 우승했는지 계산하는 메소드*/
    public static List<String> whichCarsWin(){
        int maxPosition=0;
        List<String> winnerList = new ArrayList<String>();
        for(int i=0;i<carList.size();i++){
            if(carList.get(i).getPosition()>maxPosition){
                maxPosition=carList.get(i).getPosition();
            }
        }
        for(int i=0;i<carList.size();i++){
            if(carList.get(i).getPosition()==maxPosition){
                winnerList.add(carList.get(i).getName());
            }
        }
        return winnerList;
    }
}
