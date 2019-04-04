package tokenizer;

import java.util.Arrays;
import java.util.List;

public class CommaTokenizer implements Tokenizer {

    private static final String SEPARATOR = ",";

    @Override
    public List<String> tokenize(String s) {
        return Arrays.asList(s.split(SEPARATOR));
    }
}
