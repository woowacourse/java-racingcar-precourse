package domain;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

/*
 *
 * 경주게임에 필요한 Output 클래스
 *
 * @ver 1.0
 * @author 이준규
 *
 * */

public class Output {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void printResult(String[] carNamesList, Car[] carList, int movings) throws IOException {
        System.out.println("실행 결과");
        for (int i = 0; i < movings; ++i) {
            for (int j = 0; j < carNamesList.length; ++j) {
                carList[j].goOrStop();
                carList[j].printLocation();
            }
            bw.write("\n");
            bw.flush();
        }
    }

    public static int FarthestLocation(Car[] carList, int numberOfCars) {
        int farthest = -1;
        for (int i=0;i<numberOfCars;++i){
            int howFar = carList[i].location.length();
            if (howFar>farthest){
                farthest = howFar;
            }
        }
        return farthest;
    }

    public static void printWinner(Car[] carList, int farthest) {
        StringBuilder winnerList = new StringBuilder();
        for (int i=0;i<carList.length;++i){
            if(carList[i].getPosition() == farthest){
                winnerList.append(carList[i].getName()+", ");
            }
        }
        int len = winnerList.length();
        winnerList.delete(len-2,len);
        System.out.println(winnerList+"가 최종 우승했습니다.");
    }
}