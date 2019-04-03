package domain;

import java.io.*;

public class RacingCar {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public void start() throws IOException {
        bw.write("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)" + "\n");
        bw.flush();
        String[] carNamesList = Input.readName(br);
        Car[] carList = Input.giveCarName(carNamesList);
        int numberOfCars = carNamesList.length;
        bw.write("시도할 회수는 몇회인가요?" + "\n");
        bw.flush();
        int movings = Input.countMovings(br);
        printResult(carNamesList,carList,movings);
        int farthest = FarthestLocation(carList,numberOfCars);
        printWinner(carList,farthest);
    }

    public void printResult(String[] carNamesList, Car[] carList, int movings) throws IOException {
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

    public int FarthestLocation(Car[] carList, int numberOfCars) {
        int farthest = -1;
        for (int i=0;i<numberOfCars;++i){
            int howFar = carList[i].location.length();
            if (howFar>farthest){
                farthest = howFar;
            }
        }
        return farthest;
    }

    public void printWinner(Car[] carList, int farthest) {
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


    public static void main(String[] args) throws IOException {
        RacingCar RacingCarGame = new RacingCar();
        RacingCarGame.start();
    }
}