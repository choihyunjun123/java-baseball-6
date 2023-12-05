package baseball;

import baseball.model.GameLogic;
import baseball.model.RandomNumber;
import baseball.model.Verify;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.List;

public class Application {

    private static final int STRIKE_POSITION = 0;

    private static List<Integer> randomNum;
    private static String inputNum;
    private static final OutputView outputView = new OutputView();
    private static final InputView inputView = new InputView();
    private static final Verify verify = new Verify();
    private static final RandomNumber randomNumber = new RandomNumber();
    private static final GameLogic gameLogic = new GameLogic();

    public static void inputNum() {
        randomNum = randomNumber.generateNum();
//        System.out.println(randomNum);
        inputNum = inputView.inputNum();
        try {
            verify.inputNum(inputNum);
            gameLogic();
        } catch (IllegalArgumentException e) {
            outputView.error(e.getMessage());
            inputNum();
        }
    }

    public static void gameLogic() {
        int[] strikeBall = gameLogic.strikeBall(randomNum, inputNum);
        if (strikeBall[STRIKE_POSITION] != 3) {
            inputNum();
        }
        restart();
    }

    public static void restart() {
        String result = inputView.restart();
        if (result.equals("1")) {
            inputNum();
        }
    }

    public static void main(String[] args) {
        outputView.start();
        inputNum();
    }
}