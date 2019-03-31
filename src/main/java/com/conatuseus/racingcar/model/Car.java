package com.conatuseus.racingcar.model;


public class Car {
    private static final int MAX_RANDOM=9;
    private static final int MIN_RANDOM=0;
    private static final int CAN_GOING=4;

    private final String name;
    private int position = 0;

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
        if(this.isGoingPossible(random)){
            this.position+=random;
        }
    }

    private boolean isGoingPossible(int random){
        return random >= CAN_GOING;
    }

    @Override
    public String toString(){
        StringBuilder sb=new StringBuilder();
        sb.append(this.getName());
        sb.append(" : ");
        for(int i=0; i<this.getPosition(); i++){
            sb.append("-");
        }
        return sb.toString();
    }

}
