package racingcar.utils;

import java.util.ArrayList;
import java.util.List;

import racingcar.constants.ConstMessage;

import camp.nextstep.edu.missionutils.Console;

public class NamesInputCheck {

    public static List<String> getRightNamesInput(){
        List<String> names;

        do{
            System.out.println(ConstMessage.NAMES_INPUT_REQUEST);

            names = parseNames(Console.readLine());
        }while(!checkIsPossibleNames(names));

        return names;
    }

    private static List<String> parseNames(String input){
        int parsingBeginIndex=0, parsingEndIndex;
        List<String> names = new ArrayList<>();

        while((parsingEndIndex = input.indexOf(',', parsingBeginIndex)) != -1){
            names.add(input.substring(parsingBeginIndex, parsingEndIndex));
            parsingBeginIndex = parsingEndIndex+1;
        }

        //마지막 이름 넣어주기
        names.add(input.substring(parsingBeginIndex, input.length()));
        return names;
    }

    private static boolean checkIsPossibleNames(List<String> names){
        boolean isPossibleName = true;

        try{
            checkNamesLength(names);
        }catch(IllegalArgumentException exception){
            System.out.println("[ERROR]: 모든 이름은 5이하의 문자로 입력해주세요.");
            isPossibleName = false;
        }

        return isPossibleName;
    }

    private static void checkNamesLength(List<String> names) throws IllegalArgumentException{

        for(String name : names){

            if(name.length() > 5){
                throw new IllegalArgumentException();
            }

        }

    }

}
