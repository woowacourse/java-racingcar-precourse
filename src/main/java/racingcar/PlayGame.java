package racingcar;

import java.util.Scanner;

public class PlayGame {
    String tmpCarNameSave;
    String[] carNameSave;
    int doAttemptNumber;
    Car[] carObject;

    public PlayGame(Scanner scanner) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        tmpCarNameSave = scanner.nextLine();
        System.out.println("시도할 회수는 몇회인가요?");
        doAttemptNumber = scanner.nextInt();
        splitCommaInString();
        makingCarObjectArray();
        implementGetPrintCarPositionToMinus();
    }
    public void startRacingCar(){

    }
    public void splitCommaInString(){
        carNameSave=tmpCarNameSave.split(",");
    }
    public void makingCarObjectArray(){
        carObject=new Car[carNameSave.length];
        for(int i=0;i<carObject.length;i++){
            carObject[i]=new Car(carNameSave[i]);
        }
    }
    public void printCarPositionToMinus(Car tmpCarObjectParameter){
        tmpCarObjectParameter.decidePositionNumber();
        System.out.print(tmpCarObjectParameter.getName()+" : ");
        for(int i=0;i<tmpCarObjectParameter.getPosition();i++){
            System.out.print("-");
        }
        System.out.println();

    }
    public void getPrintCarPositionToMinus(){
        for(int i=0;i<carObject.length;i++){
            printCarPositionToMinus(carObject[i]);
        }
    }
    public void implementGetPrintCarPositionToMinus(){
        for(int i=0;i<doAttemptNumber;i++){
            getPrintCarPositionToMinus();
            System.out.println();
        }
    }





}
