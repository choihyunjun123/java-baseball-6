package baseball;

import baseball.view.OutputView;

public class Application {
    private static final OutputView outputView = new OutputView();
    public static void main(String[] args) {
        outputView.start();
    }
}