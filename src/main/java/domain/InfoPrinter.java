package domain;

import java.util.ArrayList;

public class InfoPrinter {
    public static void printCurrent(){
        for(int i=0; i<CarRepository.carPark.size(); i++) {
            System.out.print(CarRepository.carPark.get(i).getName()+" : ");
            for(int j=0; j<CarRepository.carPark.get(i).getPosition(); j++)
                System.out.print("-");
            System.out.println();
        }
        System.out.println("\n");
    }

    public static void printWinner(){
        ArrayList<Car> list = winnerPicker.getWinner();
        String winners="";
        for(int i=0; i<list.size(); i++)
            winners += (i==0)? list.get(i).getName() : ", "+list.get(i).getName();
        System.out.print(winners);
        System.out.println("가 최종우승했습니다.");
    }
}
