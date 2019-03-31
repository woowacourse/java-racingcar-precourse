package com.conatuseus.racingcar.model;


public class Car {
    private static final int MAX_RANDOM=9;
    private static final int MIN_RANDOM=0;
    private static final int CAN_GOING=4;

    private final String name;
    private int position = 0;
    private String result="";

    public Car(String name) {
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public int getPosition(){
        return this.position;
    }

    public void addRandomNumToPosition(){
        int random=(int)(Math.random()*MAX_RANDOM) + MIN_RANDOM;
//        AppView.outputLine(random+"");          // 랜덤 수 확인하기 위한 코드
        if(this.isGoingPossible(random)){
            this.position+=random;
            this.addResult(random);
        }
    }

    private boolean isGoingPossible(int random){
        return random >= CAN_GOING;
    }

    private void addResult(int random){
        StringBuilder sb=new StringBuilder(this.result);
        for(int i=0; i<random; i++){
            sb.append("-");
        }
        this.result=sb.toString();
    }

    @Override
    public String toString(){
        return this.getName() + " : " + this.result;
    }

}
