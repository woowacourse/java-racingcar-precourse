package domain;

public interface Validator {
    boolean validateNames(String[] names);
    boolean validateCycles(int cycles);
}
