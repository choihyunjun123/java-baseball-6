package baseball.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class VerifyTest {

    @DisplayName("입력 숫자를 잘못하면 예외가 발생한다.")
    @ParameterizedTest
    @CsvSource(value = {"1234", "12a"})
    void inputNum(String num) {
        Verify verify = new Verify();
        assertThatThrownBy(() -> verify.inputNum(num))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력 숫자가 3자리가 아니면 예외가 발생한다.")
    @Test
    void length() {
        Verify verify = new Verify();
        assertThatThrownBy(() -> verify.length("1234"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력 숫자에 숫자가 아닌걸 입력하면 예외가 발생한다.")
    @ParameterizedTest
    @CsvSource(value = {"a", "12a"})
    void numbers(String num) {
        Verify verify = new Verify();
        assertThatThrownBy(() -> verify.numbers(num))
                .isInstanceOf(IllegalArgumentException.class);
    }
}