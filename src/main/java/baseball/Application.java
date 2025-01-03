package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;
import java.util.Set;

public class Application {

    private static final int NUMBER_LENGTH = 3;

    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");

        playGame();
    }

    private static void playGame() {
        String computer = generateRandomNumber();

        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            String userInput = Console.readLine();

            validateUserInput(userInput);

            String result = getResult(computer, userInput);
            System.out.println(result);

            if (result.equals("3스트라이크")) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                if (!askRestart()) {
                    break;
                }
                computer = generateRandomNumber();
            }
        }
    }

    private static String generateRandomNumber() {
        Set<Integer> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();

        while (set.size() < NUMBER_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!set.contains(randomNumber)) {
                set.add(randomNumber);
                sb.append(randomNumber);
            }
        }
        return sb.toString();
    }

    private static void validateUserInput(String userInput) {
        if (userInput.length() != NUMBER_LENGTH) {
            throw new IllegalArgumentException("입력은 3자리 숫자여야 합니다.");
        }
        Set<Character> checkSet = new HashSet<>();
        for (int i = 0; i < NUMBER_LENGTH; i++) {
            char c = userInput.charAt(i);
            if (c < '1' || c > '9') {
                throw new IllegalArgumentException("각 자리는 1~9 범위의 숫자여야 합니다.");
            }
            if (checkSet.contains(c)) {
                throw new IllegalArgumentException("입력 숫자는 서로 달라야 합니다.");
            }
            checkSet.add(c);
        }
    }

    private static String getResult(String computer, String userInput) {
        int strike = 0;
        int ball = 0;

        for (int i = 0; i < NUMBER_LENGTH; i++) {
            char userChar = userInput.charAt(i);
            if (computer.charAt(i) == userChar) {
                strike++;
            }
            else if (computer.indexOf(userChar) != -1) {
                ball++;
            }
        }

        if (strike == 0 && ball == 0) {
            return "낫싱";
        }
        if (strike == 0 && ball > 0) {
            return ball + "볼";
        }
        if (strike > 0 && ball == 0 && strike < 3) {
            return strike + "스트라이크";
        }
        if (strike > 0 && ball > 0) {
            return ball + "볼 " + strike + "스트라이크";
        }
        return "3스트라이크";
    }

    private static boolean askRestart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine();
        if (input.equals("1")) {
            return true;
        }
        if (input.equals("2")) {
            return false;
        }
        throw new IllegalArgumentException("잘못된 입력입니다. 게임을 종료합니다.");
    }
}