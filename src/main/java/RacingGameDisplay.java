
 /**
 * RacingGameDisplay 클래스는 RacingGame 에 관련된 모든 문구를 출력하는 기능을 가진 클래스입니다.
 *
 * @version 2019년 3월 30일
 * @author 이중혁
 */

public class RacingGameDisplay {

     public static void getRacingCarName() {

         System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
     }

     public static void getMoveNumber() {

         System.out.println("이동할 횟수를 입력해 주세요");
     }

     public static void showGameResult() {

         System.out.println("실행 결과");
     }

     public static void showDuringRacing(String[] playCarName, int[] getForwardArray){

         for(int i=0;i<playCarName.length;i++){

             System.out.print(playCarName[i] + " : ");
             for(int k=0;k<getForwardArray[i];k++){

                 System.out.print("-");
             }
            System.out.println("");
         }
     }

 }

