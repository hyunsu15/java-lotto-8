package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoSizeTest {
    @ParameterizedTest
    @CsvSource({
            "1",
            "999",
            "10",
            "0"
    })
    @DisplayName("값이 천단위가 아니면, 예외를 반환한다.")
    void test1(int value) {
        Assertions.assertThatThrownBy(() -> new LottoSize(value));
    }

    @ParameterizedTest
    @CsvSource({
            "0",
            "-1000",
            "-2000"
    })
    @DisplayName("값이 양수가 아니면, 예외를 반환한다.")
    void test2(int value) {
        Assertions.assertThatThrownBy(() -> new LottoSize(value));
    }

    @ParameterizedTest
    @CsvSource({
            "1000",
            "2000"
    })
    @DisplayName("나머지는 예외가 나오지 않는다.")
    void test3(int value) {
        Assertions.assertThatCode(() -> new LottoSize(value)).doesNotThrowAnyException();
    }
}