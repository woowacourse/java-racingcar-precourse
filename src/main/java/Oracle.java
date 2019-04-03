import java.util.Vector;

public class Oracle {

    static boolean checkLength(Vector<String> names, int MAX) {
        boolean flag = true;

        for (String name : names
        ) {
            if(name.length() > MAX) {
                flag = false;
            }
        }

        return flag;
    }

    static boolean checkRepeatedName(String specificName, Vector<String> names) {
        boolean repetition = false;
        int count;

        count = InputHandler.countName(specificName, names);
        if(count > 1) {
            repetition = true;
        }

        return repetition;
    }

    static boolean checkRepetition(Vector<String> names) {
        boolean repetition = false;

        for (String name : names
             ) {
            repetition = checkRepeatedName(name, names);
            if(repetition == true) {
                break;
            }
        }

        return repetition;
    }

    static boolean checkEmptyString(Vector<String> names) {
        boolean empty = false;

        if(names.size() == 0) {
            empty = true;
        }

        return empty;
    }

    /*static boolean checkFaultyInput(Vector<String> names, int max) {
        boolean faulty = false;

        faulty = checkLength(names, max);
        if(faulty) {
            System.out.println("다섯 글자 이하의 이름을 입력해야 합니다.");
        }

        faulty = checkRepetition(names);
        if(faulty) {
            System.out.println("차의 이름들은 모두 고유해야 합니다.(중복되면 안 됩니다)");
        }

        faulty = checkEmptyString(names);
        if(faulty) {
            System.out.println("공백이 아닌 문자를 입력해주세요.");
        }

        return faulty;
    }
    */
}
