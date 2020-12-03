import java.util.ArrayList;
import java.util.Scanner;

class Data {
    private int index;
    private String name;

    public Data(int index, String name) {
        this.index = index;
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public String getName() {
        return name;
    }
}

public class TestNameInput {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        String input = scanner.nextLine();
        String[] nameList = input.split(",");

        ArrayList<Data> tooLong = new ArrayList<>();
        for (int i = 0; i < nameList.length; i++) {
            if (nameList[i].length() > 5) {
                tooLong.add(new Data(i, nameList[i]));
            }
        }

        System.out.print("[ERROR] ");
        for (int i = 0; i < tooLong.size(); i++) {
            System.out.print(tooLong.get(i).getName());
            if (i < tooLong.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("은(는) 길이가 너무 깁니다. 5자 이하로 수정해주세요.\n");

        for (int i = 0; i < tooLong.size(); i++) {
            Data elem = tooLong.get(i);
            System.out.print("[MODIFY] " + elem.getName() + " -> ");
            String newName = scanner.nextLine();
            System.out.print("[MESSAGE] ");
            if (newName.length() > 5) {
                System.out.println(newName + "은(는) 길이가 너무 깁니다. 5자 이하로 수정해주세요.");
                i--;
            } else {
                nameList[elem.getIndex()] = newName;
                System.out.println(elem.getName() + "은(는) " + newName + "(으)로 성공적으로 수정되었습니다.");
            }
        }

        System.out.println("===== 자동차 명단 =====");
        for (String name : nameList) {
            System.out.println(name);
        }
    }
}
