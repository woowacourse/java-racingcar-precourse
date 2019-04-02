package domain;

import java.util.Scanner;

public class RacingGame {
    public static void main(String[] args){
        String[] CarName = InputCarNames();
        Car[] CarList = SetCarList(CarName);
        int GameNumber = HowManyGame();
        for(int i=0; i<GameNumber; i++)
        {
            GameStart(CarList);
            System.out.println();
        }
        int MaxPosition=GetMaxPosition(CarList);
        WhoIsWin(CarList, MaxPosition);
    }

    public static String[] InputCarNames(){
        Scanner sc = new Scanner(System.in);
        String[] InputCar;
        do {
            System.out.println("경주할 자동차 이름을 입력하세요: ");
            String Input = sc.nextLine();
            InputCar=Input.split(",");
        }while(!CheckCarNameLength(InputCar));
        return InputCar;
    }


    public static boolean CheckCarNameLength(String[] InputCarName){
        for(int i=0; i<InputCarName.length; i++){
            if(InputCarName[i].length()>5){
                System.out.println("자동차 이름을 5자 이하로 다시 입력해 주세요");
                return false;
            }
        }
        return true;
    }

    public static Car[] SetCarList(String[] CarNameList){
        Car[] Cars = new Car[CarNameList.length];
        for(int i=0; i<CarNameList.length; i++){
            Cars[i] = new Car(CarNameList[i]);
        }
        return Cars;
    }
    public static int HowManyGame(){
        int number;
        Scanner sc = new Scanner(System.in);
        System.out.println("몇 번 시도할 것인가요? : ");
        number= sc.nextInt();
        return number;
    }
    public static void GameStart(Car[] CarList){
        for(int i=0; i<CarList.length; i++)
        {
            CarList[i].MakeRandomNum();
            CarList[i].ResultPositon();
        }
    }
    public static int GetMaxPosition(Car[] CarList)
    {
        int MaxNum =0;
        for(int i=0; i<CarList.length; i++)
        {
            if(MaxNum<CarList[i].getPosition())
            {
                MaxNum=CarList[i].getPosition();
            }
        }

        return MaxNum;
    }
    public static void WhoIsWin(Car[] CarList, int MaxNum)
    {
        String Winner = "";
        for(int i=0; i<CarList.length; i++){
            if(MaxNum==CarList[i].getPosition())
            {
                Winner += CarList[i].getName() + ", ";
            }
        }
        Winner = Winner.substring(0, Winner.length() - 2);
        Winner += "가 최종 우승했습니다.";
        System.out.println(Winner);
    }
}



