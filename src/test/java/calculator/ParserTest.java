package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("파서 테스트")
class ParserTest {
    private Parser parser;

    @BeforeEach
    void setUp() {
        parser = new Parser(new Delimiter());
    }

    @Test
    @DisplayName("기본 구분자로 문자열을 분리한다")
    void 기본_구분자_파싱() {
        assertThat(parser.parse("1,2:3")).containsExactly("1", "2", "3");
    }

    @Test
    @DisplayName("커스텀 구분자로 문자열을 분리한다")
    void 커스텀_구분자_파싱() {
        assertThat(parser.parse("//;\\n1;2;3")).containsExactly("1", "2", "3");
    }

    @Test
    @DisplayName("null 입력시 빈 배열을 반환한다")
    void null_처리() {
        assertThat(parser.parse(null)).isEmpty();
    }
}