package baseball.model;

import java.io.ObjectOutputStream;

public class Verify {

    private static final int INPUT_LENGTH = 3;
    private static final String INPUT_CONTENT_REGEX = "^[1-9]+$";

    public void inputNum(String num) {
        numbers(num);
        length(num);
    }

    public void length(String num) {
        if (num.length() != INPUT_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    public void numbers(String num) {
        if (!num.matches(INPUT_CONTENT_REGEX)) {
            throw new IllegalArgumentException();
        }
    }
}
