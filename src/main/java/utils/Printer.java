package utils;

import domain.Car;

public class Printer {

    public static void printCurrentPosition(Car car) {
        String name = car.getName();
        int currentPosition = car.getCurrentPosition();
        String graph = convertToGraph(currentPosition);
        System.out.println(name + " : " + graph);
    }

    private static String convertToGraph(int currentPosition) {
        StringBuilder graph = new StringBuilder();
        for (int i = 0; i < currentPosition; i++) {
            graph.append('-');
        }
        return graph.toString();
    }

}
