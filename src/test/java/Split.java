public class Split {

    public static void main(String[] args) {
        String names = "pobi,woni,jun";
        String[] splitName = names.split(",");

        for (String name : splitName) {
            System.out.println(name);
        }
    }
}
