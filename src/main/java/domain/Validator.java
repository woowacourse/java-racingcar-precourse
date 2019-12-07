package domain;

public interface Validator {
    public boolean validateNames(String[] names);
    public boolean validateCycles(int cycles);
}
