import java.util.HashSet;
import java.util.Set;

public class TestUnique {
    public static void main(String[] args) {
        String[] A = { "pobi", "apple", "pobi", "banana", "pobi"};
        String[] B = { "pobi", "apple", "banana", "carrot", "jinseong"};

        Set<String> unique = new HashSet<String>();

        boolean dup = false;

        for (String name : B) {
            if (!unique.contains(name)) {
                unique.add(name);
            } else {
                dup = true;
                break;
            }
        }

        System.out.println(dup);
    }

}
