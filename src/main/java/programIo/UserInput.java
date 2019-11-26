package programIo;

import java.util.Scanner;

public class UserInput {
    private static final Scanner sc  = new Scanner(System.in);

    public static String[] UsernameReturnArray(){
        System.out.println("자동차 경주 게임입니다. 경주에 참여할 자동차의 이름을 적어주세요\n ',' 를 기준으로 적어주시고 이름은 5글자 이내로 적어주세요.");
        String UserInput = sc.nextLine();
        String[] UserInputArray = UserInput.split(",");
        return UserInputArray;
    }
    public static int HowManyTimesPlayReturn(){
        System.out.println("게임은 시도 할 횟수를 입력하고, 그 횟수만큼 각각 난수를 추츨하여 전진할지 스탑할지를 결정합니다.\n 시도 할 횟수는 몇번인가요?");
        return sc.nextInt();
    }
}
