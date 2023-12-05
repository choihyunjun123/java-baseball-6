package baseball.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.HashMap;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class GameLogicTest {

    @DisplayName("입력 숫자 배열로 변환")
    @Test
    void inputNumToList() {
        GameLogic gameLogic = new GameLogic();
        List<Integer> result = gameLogic.inputNumToList("123");
        List<Integer> expect = List.of(1, 2, 3);
        assertThat(result).isEqualTo(expect);
    }

    @DisplayName("3볼 확인")
    @Test
    void strikeBall1() {
        GameLogic gameLogic = new GameLogic();
        int[] result = gameLogic.strikeBall(List.of(1, 2, 3), "312");
        int[] expect = {0, 3};
        assertThat(result).isEqualTo(expect);
    }

    @DisplayName("2볼 1스트라이크 확인")
    @Test
    void strikeBall2() {
        GameLogic gameLogic = new GameLogic();
        int[] result = gameLogic.strikeBall(List.of(1, 2, 3), "213");
        int[] expect = {1, 2};
        assertThat(result).isEqualTo(expect);
    }

    @DisplayName("2스트라이크 확인")
    @Test
    void strikeBall3() {
        GameLogic gameLogic = new GameLogic();
        int[] result = gameLogic.strikeBall(List.of(1, 2, 3), "124");
        int[] expect = {2, 0};
        assertThat(result).isEqualTo(expect);
    }

    @DisplayName("3스트라이크 확인")
    @Test
    void strikeBall4() {
        GameLogic gameLogic = new GameLogic();
        int[] result = gameLogic.strikeBall(List.of(1, 2, 3), "123");
        int[] expect = {3, 0};
        assertThat(result).isEqualTo(expect);
    }
}