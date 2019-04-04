package com.nekisse;

import java.util.Map;

public class OutPutView {
    public static void showTurnResult(TurnResult turnResult) {
        Map<String, String> turnResult1 = turnResult.getTurnResult();
        for (Map.Entry<String, String> stringStringEntry : turnResult1.entrySet()) {
            System.out.println(stringStringEntry.getKey() + stringStringEntry.getValue());
        }
    }



    public static void printEmptyLine() {
        System.out.println();
    }
}
