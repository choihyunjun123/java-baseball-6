package baseball;

import baseball.model.RandomNumber;
import baseball.model.Verify;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.List;

public class Application {

    private static List<Integer> RandomNum;
    private static String InputNum;
    private static final OutputView outputView = new OutputView();
    private static final InputView inputView = new InputView();
    private static final Verify verify = new Verify();
    private static final RandomNumber randomNumber = new RandomNumber();

    Application() {
        RandomNum = randomNumber.generateNum();
    }

    public static void inputNum() {
        InputNum = inputView.inputNum();
        try {
            verify.inputNum(InputNum);
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