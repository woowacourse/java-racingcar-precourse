package tokenizer;

import java.util.Arrays;
import java.util.List;

public class CommaTokenizer implements Tokenizer{

    @Override
    public List<String> tokenize(String s) {
        return Arrays.asList(s.split(","));
    }
}
