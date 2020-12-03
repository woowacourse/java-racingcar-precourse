package racingcar;

import java.util.Scanner;

public class Racing {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        String[] nameList=inputCarsNameList(scanner);
        // TODO 구현 진행
    }

    /* 자동차들의 입력받아 쉼표로 구분하여(,) 반환하는 메소드 */
    public static String[] inputCarsNameList(Scanner scanner){
        String namesInput;
        String[] nameList=null;

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        try{
            namesInput=scanner.nextLine();
            nameList=namesInput.split(",");
            if(isValidNames(nameList)==false){
                throw new IllegalArgumentException();
            }
        }catch(IllegalArgumentException e){
            System.out.println("[ERROR] 이름은 5자리 이하 문자를 입력해주세요.");
            return inputCarsNameList(scanner);
        }
        return nameList;
    }

    /* 5자리를 초과하거나 빈 문자가 있는지 검사하는 메소드 */
    public static boolean isValidNames(String[] nameList){
        for(int i=0;i<nameList.length;i++){
            if((nameList[i].length()>5)||(nameList[i].indexOf(" ")>-1)||nameList[i].length()==0){
                return false;
            }
        }
        return true;
    }
}
