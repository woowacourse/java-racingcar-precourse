package racingcar;

import com.sun.tools.sjavac.pubapi.TypeVarTypeDesc;
import java.util.ArrayList;
import java.util.Scanner;

public class StringUtils {
    public static final char runnerFormat = ',';

    public String inputRunnerString;
    public int inputRoundCount;

    public StringUtils(Scanner promptInput){
        inputRunnerString = promptInput.next();
    }
    public String[] splitRunner(){
        String[] runners = inputRunnerString.split(String.valueOf(runnerFormat), 0);

        return runners;
    }


    public static void main(String[] args) {
        String[] cast;
        final Scanner scanner = new Scanner(System.in);
        // Test

        StringUtils input = new StringUtils(scanner);
        cast = input.splitRunner();


    }
}
