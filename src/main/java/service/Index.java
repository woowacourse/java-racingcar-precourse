package service;

import domain.Config;

import java.util.Arrays;
import java.util.Scanner;

public class Index {
    public static void main(String[] args) {
        Config config = new Config();
        Scanner scan = new Scanner(System.in);
        System.out.println("경주할 자동차의 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
        String[] carArrays = config.loopIfNotFiveLess();
        System.out.println(Arrays.toString(carArrays));
    }

}

