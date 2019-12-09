package com.minuyim.race.utils;

public class NumberInputs {
    private int output;
    
    public NumberInputs() {
        this.startInput();
    }
    
    public int getOutput() {
        return this.output;
    }
    
    private void startInput() {
        System.out.println(MessageStrings.TOTALNUM_INPUT_MESSAGE);
        inputRightValue();
    }
    
    private void inputRightValue() {
        while (true) {
            try {
                this.output = validate(UserInputs.input());
                break;
            } catch (NumberFormatException e) {
                System.out.println(MessageStrings.WRONG_TYPE_ERROR);
            } catch (IllegalArgumentException e) {
                System.out.println(MessageStrings.WRONG_NUMBER_ERROR);
            }
        }
    }
    
    private int validate(String input) {
        int num = Integer.valueOf(input);
        
        if (num < 0) {
            throw new IllegalArgumentException();
        }
        
        return num;
    }
}
