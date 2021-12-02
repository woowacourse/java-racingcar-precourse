package racingcar.utils;

import java.util.ArrayList;
import java.util.List;

public class InputCheck {
    public static List<String> parseNames(String input){
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
}
