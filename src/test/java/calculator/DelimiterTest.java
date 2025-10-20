package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("구분자 테스트")
class DelimiterTest {

    @Test
    @DisplayName("기본 구분자로 문자열을 분리한다")
    void 기본_구분자_분리() {
        // given
        Delimiter delimiter = new Delimiter();

        // when
        String[] result = delimiter.split("1,2:3");

        // then
        assertThat(result).containsExactly("1", "2", "3");
    }

    @Test
    @DisplayName("커스텀 구분자를 추가하여 분리한다")
    void 커스텀_구분자_추가() {
        // given
        Delimiter delimiter = new Delimiter();
        delimiter.addDelimiter(";");

        // when
        String[] result = delimiter.split("1,2;3");

        // then
        assertThat(result).containsExactly("1", "2", "3");
    }

    @Test
    @DisplayName("특수문자 구분자를 처리한다")
    void 특수문자_구분자() {
        // given
        Delimiter delimiter = new Delimiter();
        delimiter.addDelimiter("*");

        // when
        String[] result = delimiter.split("1*2,3");

        // then
        assertThat(result).containsExactly("1", "2", "3");
    }
}