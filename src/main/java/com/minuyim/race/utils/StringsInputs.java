package com.minuyim.race.utils;

public class StringsInputs {
    private String[] output;
    
    public StringsInputs() {
        this.startInput();
    }
    
    public String[] getOutput() {
        return this.output;
    }
    
    private void startInput() {
        System.out.println(Constants.NAME_INPUT_MESSAGE);
        inputRightValue();
    }
    
    private void inputRightValue() {
        while (true) {
            try {
                this.output = validate(UserInputs.input());
                break;
            } catch (NumberFormatException e) {
                System.out.println(Constants.WRONG_TYPE_ERROR);
            } catch (IllegalArgumentException e) {
                System.out.println(Constants.WRONG_LENGTH_ERROR);
            }
        }
    }
    
    private String[] validate(String input) {
        String[] strings = input.split(",");
        
        for (String string : strings) {
            if (string.length() > Constants.STRING_LIMIT_NUMBER) {
                throw new IllegalArgumentException();
            }
        }

        return strings;
    }
}
