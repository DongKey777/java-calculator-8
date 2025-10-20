package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("계산기 테스트")
class CalculatorTest {
    private Calculator calculator;

    @BeforeEach
    void setUp() {
        Delimiter delimiter = new Delimiter();
        Parser parser = new Parser(delimiter);
        calculator = new Calculator(parser);
    }

    @Test
    @DisplayName("쉼표로 구분된 숫자들의 합을 계산한다")
    void 쉼표_구분자_계산() {
        assertThat(calculator.calculate("1,2,3")).isEqualTo(6);
    }

    @Test
    @DisplayName("콜론으로 구분된 숫자들의 합을 계산한다")
    void 콜론_구분자_계산() {
        assertThat(calculator.calculate("1:2:3")).isEqualTo(6);
    }

    @Test
    @DisplayName("커스텀 구분자로 구분된 숫자들의 합을 계산한다")
    void 커스텀_구분자_계산() {
        assertThat(calculator.calculate("//;\\n1;2;3")).isEqualTo(6);
    }

    @Test
    @DisplayName("커스텀 구분자와 기본 구분자를 함께 사용할 수 있다.")
    void 커스텀_기본_구분자_함께_사용() {
        assertThat(calculator.calculate("//a\\n5:6,2")).isEqualTo(13);
    }

    @Test
    @DisplayName("빈 문자열 입력시 0을 반환한다")
    void 빈_문자열_처리() {
        assertThat(calculator.calculate("")).isEqualTo(0);
    }

    @Test
    @DisplayName("구분자가 연속으로 나올 경우 0으로 처리한다")
    void 구분자_연속_처리() {
        assertThat(calculator.calculate("1,,2")).isEqualTo(3);
    }

    @Test
    @DisplayName("구분자만 있는 경우엔 0을 반환한다")
    void 구분만_있는_경우() {
        assertThat(calculator.calculate(",,,,")).isEqualTo(0);
    }


    @Test
    @DisplayName("음수 입력시 예외가 발생한다")
    void 음수_입력_예외() {
        assertThatThrownBy(() -> calculator.calculate("1,-2,3"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("양수만 입력 가능");
    }
}