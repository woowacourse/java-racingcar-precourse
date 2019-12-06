package domain;

import java.util.*;
import domain.*;

public class TryInput {
    public int tryInput(){
        boolean check = false;
        int tryCount;
        Scanner sc = new Scanner(System.in);

        while(true) {
            check = false;
            System.out.println("시도할 회수는 몇회인가요?");
            tryCount = sc.nextInt();

            /*예외처리*/
            if(tryCount<1){
                System.out.println("시도할 회수는 1회 이상 재입력!!");
                check = true;
            }

            if(!check){
                break;
            }
        }

        return tryCount;
    }
}
