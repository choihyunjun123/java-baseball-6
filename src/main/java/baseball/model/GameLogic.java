package baseball.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GameLogic {

    private static final int STRIKE_BALL_LENGTH = 2;
    private static final int STRIKE_POSITION = 0;
    private static final int BALL_POSITION = 1;

    public List<Integer> inputNumToList(String num) {
        List<Integer> user = new ArrayList<>();
        for (int i = 0; i < num.length(); i++) {
            user.add(Integer.parseInt(num.substring(i, i + 1)));
        }
        return user;
    }

    public int[] strikeBall(List<Integer> random, String input) {
        List<Integer> inputNum = inputNumToList(input);
        int[] count = new int[STRIKE_BALL_LENGTH];
        int strike = 0;
        int contain = 0;
        for (int i = 0; i < random.size(); i++) {
            if (Objects.equals(random.get(i), inputNum.get(i))) {
                strike++;
            }
            if (random.contains(inputNum.get(i))) {
                contain++;
            }
        }
        count[STRIKE_POSITION] = strike;
        count[BALL_POSITION] = contain - strike;
        return count;
    }
}
