package view;

public class OutputView {
    public void printOneLine(){
        System.out.println();
    }
    public void printNowCars(String name, int position) {
        StringBuilder stringBuilder = new StringBuilder();
        System.out.println(stringBuilder.append(name).append(" : ").append(printPosition(position)).toString());
    }

    private String printPosition(int position) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < position; i++) {
            stringBuilder.append("-");
        }
        return stringBuilder.toString();
    }

    public void printResult() {
        System.out.println();
        System.out.println("실행 결과");
    }
}
