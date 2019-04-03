package domain;

import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Input {
    static String[] readName(BufferedReader br) throws IOException {
        String carNames = br.readLine();
        StringTokenizer st = new StringTokenizer(carNames, ",");
        int n = countNumberOfCars(carNames);
        String[] carNamesList = new String[n];
        for (int i = 0; i < n; ++i) {
            carNamesList[i] = st.nextToken();
        }
        return carNamesList;
    }

    static int countNumberOfCars(String carNames) {
        int count = 0;
        int len = carNames.length();
        for (int i = 0; i < len; ++i) {
            if (carNames.charAt(i) == ',') {
                count++;
            }
        }
        return count + 1;
    }

    static int countMovings(BufferedReader br) throws IOException {
        return Integer.parseInt(br.readLine());
    }

    static Car[] giveCarName(String[] carNamesList) {
        int len = carNamesList.length;
        Car[] carList = new Car[len];
        for (int i = 0; i < len; ++i) {
            carList[i] = new Car(carNamesList[i]);
        }
        return carList;
    }
}