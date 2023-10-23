package baseball.view;

public class OutputView {
    public void StartGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public boolean showResult(int strikeNum, int ballNum) {
        if (strikeNum == 3) {
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        } else if (strikeNum > 0 || ballNum > 0) {
            System.out.printf("%d볼 %d스트라이크 ", strikeNum, ballNum);
        } else {
            System.out.println("낫싱");
        }
        return false;
    }
}
