package com.minuyim.race.utils;

public class StringsInputs {
    private static final int STRING_MIN_LIMIT = 0;
    private static final int STRING_MAX_LIMIT = 5;
    private static final int STRINGS_MIN_LIMIT = 0;
    private String[] output;
    
    public StringsInputs() {
        this.startInput();
    }
    
    public String[] getOutput() {
        return this.output;
    }
    
    private void startInput() {
        System.out.println(MessageStrings.NAME_INPUT_MESSAGE);
        inputRightValue();
    }
    
    private void inputRightValue() {
        while (true) {
            try {
                this.output = validateString(UserInputs.input());
                validateStrings(this.output);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(MessageStrings.WRONG_LENGTH_ERROR);
            }
        }
    }
    
    private String[] validateString(String input) {
        String[] strings = input.split(",", -1);
        
        for (String string : strings) {
            if (!isLengthInRange(string)) {
                throw new IllegalArgumentException();
            }
        }
        
        return strings;
    }
    
    private void validateStrings(String[] strings) {
        if (isAllNone(strings)) {
            throw new IllegalArgumentException();
        }
    }
    
    private boolean isLengthInRange(String string) {
        return string.length() <= STRING_MAX_LIMIT 
                && string.length() > STRING_MIN_LIMIT;
    }
    
    private boolean isAllNone(String[] strings) {
        return strings.length == STRINGS_MIN_LIMIT;
    }
}
