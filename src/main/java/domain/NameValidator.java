package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NameValidator {
    private String inputData;

    public void checkSomethingIsHere(){
        if(this.inputData.equals("")){
            throw new IllegalArgumentException("이름을 입력해주세요.");
        }
    }

}
