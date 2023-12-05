package baseball;

import baseball.model.Verify;
import baseball.view.InputView;
import baseball.view.OutputView;

public class Application {
    private static final OutputView outputView = new OutputView();
    private static final InputView inputView = new InputView();
    private static final Verify verify = new Verify();

    public static void inputNum() {
        try {
            verify.inputNum(inputView.inputNum());
        } catch (IllegalArgumentException e) {
            outputView.error(e.getMessage());
            inputNum();
        }
    }

    public static void main(String[] args) {
        outputView.start();
        inputNum();
    }
}