package baseball.view;

public class OutputView {
    public void start() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void error(String e) {
        System.out.println(e);
    }

    public void result(int[] strikeBall) {
        if (strikeBall[0] == 0) {
            System.out.println(strikeBall[1] + "볼");
        }
        if (strikeBall[1] == 0) {
            System.out.println(strikeBall[0] + "스트라이크");
            if (strikeBall[0] == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            }
        }
        if (strikeBall[0] != 0 && strikeBall[1] != 0) {
            System.out.println(strikeBall[1] + "볼 " + strikeBall[0] + "스트라이크");
        }
    }
}
