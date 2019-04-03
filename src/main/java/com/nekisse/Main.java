package com.nekisse;

import com.nekisse.domain.CarName;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        String inputString = InputView.getInputCarName();

        List<CarName> carNames = Utils.parseStringToGetCarNames(inputString);

        int inputTryCount = InputView.getInputTryCount();

    }

}
