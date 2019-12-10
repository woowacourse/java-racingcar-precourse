package racing.domain;

public class RunRuleFactory {
    private static boolean isDefaultOption = true;

    private RunRuleFactory() {
    }

    public static CarRunRule getInstance() {
        if (isDefaultOption) {
            return new RandomNumberRule();
        }
        return null;
    }
}
